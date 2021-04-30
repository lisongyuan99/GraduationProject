package cn.lsy99.api.activity.vip;

import cn.lsy99.api.activity.generator.mapper.*;
import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.generator.table.ShopBalance;
import cn.lsy99.api.activity.generator.table.ShopVip;
import cn.lsy99.api.activity.generator.table.VipDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.VipDetailDynamicSqlSupport.vipDetail;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Repository
public class VipRepository {

    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private VipDetailMapper vipDetailMapper;
    @Autowired
    private ShopVipMapper shopVipMapper;
    @Autowired
    private ShopBalanceMapper shopBalanceMapper;

    public Optional<Seller> getSeller(int bossId) {
        return sellerMapper.selectByPrimaryKey(bossId);
    }

    // 获取所有vip明细
    public List<VipDetail> getVipDetail(int shopId) {
        return vipDetailMapper.select(c -> c.where(vipDetail.shopId, isEqualTo(shopId)));
    }

    // 获取过期时间
    public Date getExpireTime(int shopId) {
        Optional<ShopVip> shopVip = shopVipMapper.selectByPrimaryKey(shopId);
        if (shopVip.isPresent()) {
            return shopVip.get().getExpireTime();
        } else {
            Date date = new Date(0);
            shopVipMapper.insert(ShopVip.builder().shopId(shopId).expireTime(date).build());
            return date;
        }
    }

    // 获取余额
    public double getBalance(int shopId) {
        Optional<ShopBalance> result = shopBalanceMapper.selectByPrimaryKey(shopId);
        if (result.isPresent()) {
            return result.get().getBalance();
        } else {
            // TODO 异常处理
            return 0;
        }
    }

    // 更新余额
    public int updateBalance(int shopId, double balance) {
        ShopBalance record = ShopBalance.builder().shopId(shopId).balance(balance).build();
        return shopBalanceMapper.updateByPrimaryKeySelective(record);
    }

    // 更新过期时间
    public int updateExpireTime(int shopId, Date date) {
        ShopVip record = ShopVip.builder().shopId(shopId).expireTime(date).build();
        return shopVipMapper.updateByPrimaryKeySelective(record);
    }

    // 添加记录
    public int addVipRecord(int shopId, int addDays, double price, Date payTime) {
        VipDetail record = VipDetail.builder()
                .shopId(shopId)
                .addDays(addDays)
                .payTime(payTime)
                .price(price)
                .build();
        return vipDetailMapper.insert(record);
    }
}
