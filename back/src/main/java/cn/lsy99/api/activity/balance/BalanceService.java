package cn.lsy99.api.activity.balance;

import cn.lsy99.api.activity.balance.dto.BalanceInfo;
import cn.lsy99.api.activity.balance.dto.Bill;
import cn.lsy99.api.activity.generator.OrderStatus;
import cn.lsy99.api.activity.generator.table.*;
import org.aspectj.weaver.tools.ISupportsMessageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BalanceService {
    @Autowired
    private BalanceRepository balanceRepository;
    private static final String TOP_UP = "充值";
    private static final String WITHDRAW = "提现";
    private static final String VERIFY = "核销";
    private static final String REFUND = "退款";
    private static final String VIP = "会员续费";
    private static final String VIP_DAY = "天";
    private static final long DAY_MS = 24 * 60 * 60 * 1000;

    // 获取流水信息
    public BalanceInfo getBalanceInfo(int bossId) {
        Optional<Seller> seller = balanceRepository.getSeller(bossId);
        if (seller.isPresent()) {
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
                balanceBill.add(Bill.builder().info(info).time(e.getBillTime()).price(e.getAmount()).build());
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
                                .time(e.getUseTime())
                                .price(price)
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
                                .time(e.getUseTime())
                                .price(price)
                                .build();
                        Bill bill2 = Bill.builder()
                                .info(VERIFY + activity.get().getTitle())
                                .time(e.getUseTime())
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
                        .time(e.getPayTime())
                        .price(-e.getPrice())
                        .build();
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
        return null;
    }
}
