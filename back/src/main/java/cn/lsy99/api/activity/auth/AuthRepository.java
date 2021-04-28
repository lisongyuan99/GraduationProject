package cn.lsy99.api.activity.auth;

import cn.lsy99.api.activity.generator.UserRole;
import cn.lsy99.api.activity.generator.mapper.SellerMapper;
import cn.lsy99.api.activity.generator.mapper.ShopMapper;
import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.generator.table.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.SellerDynamicSqlSupport.seller;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Repository
@Slf4j
public class AuthRepository {
    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private ShopMapper shopMapper;

    public Optional<Seller> getSeller(String openId){
        return sellerMapper.selectOne(c->c.where(seller.wxOpenId, isEqualTo(openId)));
    }

    public Seller newSeller(String openId){
        Seller seller = Seller.builder().wxOpenId(openId).type(UserRole.EMPTY.ordinal()).build();
        sellerMapper.insertSelective(seller);
        return seller;
    }

    public Optional<Shop> getShop(int shopId){
        return shopMapper.selectByPrimaryKey(shopId);
    }

}
