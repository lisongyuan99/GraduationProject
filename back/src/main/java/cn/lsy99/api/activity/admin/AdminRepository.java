package cn.lsy99.api.activity.admin;

import cn.lsy99.api.activity.generator.ActivityStatus;
import cn.lsy99.api.activity.generator.ShopStatus;
import cn.lsy99.api.activity.generator.UserRole;
import cn.lsy99.api.activity.generator.mapper.ActivityMapper;
import cn.lsy99.api.activity.generator.mapper.AdminMapper;
import cn.lsy99.api.activity.generator.mapper.SellerMapper;
import cn.lsy99.api.activity.generator.mapper.ShopMapper;
import cn.lsy99.api.activity.generator.table.Activity;
import cn.lsy99.api.activity.generator.table.Admin;
import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.generator.table.Shop;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.ActivityDynamicSqlSupport.activity;
import static cn.lsy99.api.activity.generator.mapper.SellerDynamicSqlSupport.seller;
import static cn.lsy99.api.activity.generator.mapper.ShopDynamicSqlSupport.shop;
import static org.mybatis.dynamic.sql.SqlBuilder.and;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Repository
public class AdminRepository {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private ActivityMapper activityMapper;

    public Optional<Admin> getAdmin(String name){
        return adminMapper.selectByPrimaryKey(name);
    }

    public List<Shop> getAllShopToVerify(){
        int status = ShopStatus.NOT_VERIFY.ordinal();
        return shopMapper.select(c->c.where(shop.status, isEqualTo(status)));
    }

    public Optional<Seller> getSellerByShopId(int id){
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(seller.allColumns())
                .from(seller)
                .where(seller.shopId, isEqualTo(id), and(seller.type, isEqualTo(UserRole.BOSS.ordinal())))
                .build().render(RenderingStrategies.MYBATIS3);
        return sellerMapper.selectOne(selectStatementProvider);
    }

    public Optional<Shop> getShopById(int id) {
        return shopMapper.selectByPrimaryKey(id);
    }

    public int passShop(int id){
        Shop record = Shop.builder().id(id).status(ShopStatus.PASS.ordinal()).build();
        return shopMapper.updateByPrimaryKeySelective(record);
    }
    public int denyShop(int id){
        Shop record = Shop.builder().id(id).status(ShopStatus.REJECT.ordinal()).build();
        return shopMapper.updateByPrimaryKeySelective(record);
    }

    public List<Activity> getActivity(){
        return activityMapper.select(c->c.where(activity.status, isEqualTo(ActivityStatus.WAIT_FOR_VERIFY.ordinal())));
    }

    public int passActivity(int id){
        Activity record = Activity.builder().id(id).status(ActivityStatus.NORMAL.ordinal()).build();
        return activityMapper.updateByPrimaryKeySelective(record);
    }
    public int denyActivity(int id){
        Activity record = Activity.builder().id(id).status(ActivityStatus.VERIFY_REJECT.ordinal()).build();
        return activityMapper.updateByPrimaryKeySelective(record);
    }
}
