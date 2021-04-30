package cn.lsy99.api.activity.shop;

import cn.lsy99.api.activity.generator.UserRole;
import cn.lsy99.api.activity.generator.mapper.SellerMapper;
import cn.lsy99.api.activity.generator.mapper.ShopBalanceMapper;
import cn.lsy99.api.activity.generator.mapper.ShopMapper;
import cn.lsy99.api.activity.generator.mapper.ShopVipMapper;
import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.generator.table.Shop;
import cn.lsy99.api.activity.generator.table.ShopBalance;
import cn.lsy99.api.activity.generator.table.ShopVip;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.SellerDynamicSqlSupport.seller;
import static cn.lsy99.api.activity.generator.mapper.ShopDynamicSqlSupport.shop;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public class ShopRepository {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private ShopBalanceMapper shopBalanceMapper;
    @Autowired
    private ShopVipMapper shopVipMapper;

    // 新建商铺
    public int newShop(Shop shop) {
        shopMapper.insertSelective(shop);
        return shop.getId();
    }

    public int initBalance(int shopId) {
        ShopBalance shopBalance = ShopBalance.builder().shopId(shopId).balance(0.0).build();
        return shopBalanceMapper.insert(shopBalance);
    }

    public int initVip(int shopId){
        ShopVip shopVip = ShopVip.builder().shopId(shopId).expireTime(new Date(0)).build();
        return shopVipMapper.insert(shopVip);
    }

    // 卖家修改商铺id
    public int sellerUpdateShopId(int sellerId, int shopId) {
        Seller updateRecord = Seller.builder().id(sellerId).shopId(shopId).build();
        return sellerMapper.updateByPrimaryKeySelective(updateRecord);
    }

    // 更新商铺信息
    public int updateShop(Shop shop){
        return shopMapper.updateByPrimaryKeySelective(shop);
    }

    // 老板id获取商铺
    public Optional<Shop> getShopByBossId(int id){
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(shop.allColumns())
                .from(shop)
                .join(seller)
                .on(shop.id, equalTo(seller.shopId))
                .where(seller.id, isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        return shopMapper.selectOne(selectStatementProvider);
    }

    // 改变老板状态
    public void changeBossStatus(int sellerId, UserRole userRole){
        Seller updateRecord = Seller.builder().id(sellerId).type(userRole.ordinal()).build();
        sellerMapper.updateByPrimaryKeySelective(updateRecord);
    }
}
