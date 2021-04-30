package cn.lsy99.api.activity.vip;

import cn.lsy99.api.activity.exception.exception.NoEnoughBalanceException;
import cn.lsy99.api.activity.exception.exception.NoShopException;
import cn.lsy99.api.activity.vip.dto.Bill;
import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.generator.table.VipDetail;
import cn.lsy99.api.activity.vip.dto.VipInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VipService {
    @Autowired
    private VipRepository vipRepository;

    private static final String VIP = "会员续费";
    private static final String VIP_DAY = "天";

    public VipInfo getVipInfo(int bossId) {
        Optional<Seller> seller = vipRepository.getSeller(bossId);
        if (seller.isEmpty()) {
            throw new NoShopException();
        }
        List<Bill> balanceBill = new ArrayList<>();
        List<VipDetail> vipDetails = vipRepository.getVipDetail(seller.get().getShopId());
        for (VipDetail e : vipDetails) {
            Bill bill = Bill.builder()
                    .info(VIP + e.getAddDays() + VIP_DAY)
                    .time(e.getPayTime())
                    .price(-e.getPrice())
                    .build();
            balanceBill.add(bill);
        }
        VipInfo vipInfo = VipInfo.builder().build();
        Date expireTime = vipRepository.getExpireTime(seller.get().getShopId());
        Date now = new Date();
        if (now.compareTo(expireTime) > 0) {
            vipInfo.setActiveDay(0);
        } else {
            vipInfo.setActiveDay((int) ((expireTime.getTime() - now.getTime()) / (24 * 60 * 60 * 1000) + 1));
        }
        vipInfo.setExpireDate(expireTime);
        balanceBill.sort((o1, o2) -> o2.getTime().compareTo(o1.getTime()));
        if (balanceBill.size() > 0) {
            vipInfo.setLastRenewDate(balanceBill.get(0).getTime());
        }
        vipInfo.setBills(balanceBill);
        return vipInfo;
    }

    @Transactional
    public boolean renew(int bossId, int day, double price) {
        Optional<Seller> seller = vipRepository.getSeller(bossId);
        if (seller.isEmpty()) {
            throw new NoShopException();
        }
        int shopId = seller.get().getShopId();
        // 判断余额
        double balance = vipRepository.getBalance(shopId);
        if (balance < price) {
            throw new NoEnoughBalanceException();
        }
        double newBalance = balance - price;
        // 计算过期时间
        Date expireDate = vipRepository.getExpireTime(seller.get().getShopId());
        Date now = new Date();
        Date newExpireDate = null;
        if (now.compareTo(expireDate) > 0) {
            // 已过期
            newExpireDate = new Date(now.getTime() + (long) day * 24 * 60 * 60 * 1000);
        } else {
            // 未过期
            newExpireDate = new Date(expireDate.getTime() + (long) day * 24 * 60 * 60 * 1000);
        }
        int i = vipRepository.updateBalance(shopId, newBalance);
        int j = vipRepository.updateExpireTime(shopId, newExpireDate);
        int k = vipRepository.addVipRecord(shopId, day, price, now);
        return true;
    }
}
