package cn.lsy99.api.activity.balance;

import cn.lsy99.api.activity.balance.dto.BalanceInfo;
import cn.lsy99.api.activity.balance.dto.BalanceType;
import cn.lsy99.api.activity.balance.dto.Bill;
import cn.lsy99.api.activity.exception.exception.NoEnoughBalanceException;
import cn.lsy99.api.activity.exception.exception.NoShopException;
import cn.lsy99.api.activity.generator.OrderStatus;
import cn.lsy99.api.activity.generator.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BalanceService {
    @Autowired
    private BalanceRepository balanceRepository;
    private static final String TOP_UP = "充值";
    private static final String WITHDRAW = "提现";
    private static final String VERIFY = "核销：";
    private static final String REFUND = "退款：";
    private static final String VIP = "会员续费：";
    private static final String VIP_DAY = "天";
    private static final long DAY_MS = 24 * 60 * 60 * 1000;
    private static final String SUGGESTION = "付费推荐：";

    // 获取流水信息
    public BalanceInfo getBalanceInfo(int bossId) {
        Optional<Seller> seller = balanceRepository.getSeller(bossId);
        if (seller.isEmpty()) {
            throw new NoShopException();
        }
        List<Bill> balanceBill = new ArrayList<>();
        int shopId = seller.get().getShopId();
        double balance = balanceRepository.getBalance(shopId);
        double withdraw = 0; // 累计提现
        double get = 0; // 累计入账
        double today = 0; // 今日入账
        // 处理充值提现信息
        List<ShopBill> bills = balanceRepository.getBills(shopId);
        for (ShopBill e : bills) {
            String info = e.getAmount() > 0 ? TOP_UP : WITHDRAW;
            balanceBill.add(Bill.builder()
                    .info(info)
                    .time(e.getBillTime())
                    .price(e.getAmount())
                    .type(BalanceType.BALANCE.ordinal())
                    .build());
            if (e.getAmount() < 0) {
                withdraw -= e.getAmount();
            }
        }
        // 处理用户订单
        List<OrderInfo> orders = balanceRepository.getOrder(shopId);
        for (OrderInfo e : orders) {
            double price = e.getPrice() * e.getCount();
            OrderStatus status = OrderStatus.values()[e.getStatus()];
            Optional<Activity> activity = balanceRepository.getActivity(e.getActivityId());
            if (activity.isPresent()) {
                if (status == OrderStatus.USED || status == OrderStatus.COMMENTED) {
                    Bill bill = Bill.builder()
                            .info(VERIFY + activity.get().getTitle())
                            .id(activity.get().getId())
                            .time(e.getUseTime())
                            .price(price)
                            .type(BalanceType.ORDER.ordinal())
                            .build();
                    balanceBill.add(bill);
                    get += price;
                    if (new Date().getTime() - e.getUseTime().getTime() <= DAY_MS) {
                        today += price;
                    }
                } else if (status == OrderStatus.REFUND_NOT_USE || status == OrderStatus.REFUND_USED
                        || status == OrderStatus.REFUND_COMMENTED) {
                    Bill bill1 = Bill.builder()
                            .info(VERIFY + activity.get().getTitle())
                            .id(activity.get().getId())
                            .time(e.getUseTime())
                            .type(BalanceType.ORDER.ordinal())
                            .price(price)
                            .build();
                    Bill bill2 = Bill.builder()
                            .info(REFUND + activity.get().getTitle())
                            .id(activity.get().getId())
                            .time(e.getUseTime())
                            .type(BalanceType.ORDER.ordinal())
                            .price(-price)
                            .build();
                    balanceBill.add(bill1);
                    balanceBill.add(bill2);
                }
            }
        }
        // 处理VIP充值
        List<VipDetail> vipDetails = balanceRepository.getVipDetail(shopId);
        for (VipDetail e : vipDetails) {
            Bill bill = Bill.builder()
                    .info(VIP + e.getAddDays() + VIP_DAY)
                    .type(BalanceType.VIP.ordinal())
                    .time(e.getPayTime())
                    .price(-e.getPrice())
                    .build();
            balanceBill.add(bill);
        }
        // 处理活动推荐
        List<ActivitySuggestion> suggestions = balanceRepository.getSuggestion(shopId);
        for (ActivitySuggestion e : suggestions) {
            Optional<Activity> activity = balanceRepository.getActivity(e.getActivityId());
            Bill bill = Bill.builder()
                    .type(BalanceType.SUGGESTION.ordinal())
                    .time(e.getAddTime())
                    .price(-e.getPrice())
                    .build();
            if(activity.isPresent()){
                bill.setInfo(SUGGESTION + activity.get().getTitle());
                bill.setId(activity.get().getId());
            } else {
                bill.setInfo(SUGGESTION );
            }
            balanceBill.add(bill);
        }
        balanceBill.sort((o1, o2) -> o2.getTime().compareTo(o1.getTime()));
        return BalanceInfo.builder()
                .balance(balance)
                .withdraw(withdraw)
                .sum(get)
                .today(today)
                .bills(balanceBill)
                .build();
    }

    @Transactional
    public boolean topUp(int bossId, double price) {
        Optional<Seller> seller = balanceRepository.getSeller(bossId);
        if (seller.isEmpty()) {
            throw new NoShopException();
        }
        int shopId = seller.get().getShopId();
        double balance = balanceRepository.getBalance(shopId) + price;
        int i = balanceRepository.updateBalance(shopId, balance);
        int j = balanceRepository.addBill(shopId, new Date(), price);
        return true;
    }

    @Transactional
    public boolean withdraw(int bossId, double price) {
        Optional<Seller> seller = balanceRepository.getSeller(bossId);
        if (seller.isEmpty()) {
            throw new NoShopException();
        }
        int shopId = seller.get().getShopId();
        double balance = balanceRepository.getBalance(shopId);
        if (balance < price) {
            throw new NoEnoughBalanceException();
        }
        int i = balanceRepository.updateBalance(shopId, balance - price);
        int j = balanceRepository.addBill(shopId, new Date(), -price);
        return true;
    }
}
