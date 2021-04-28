package cn.lsy99.api.activity.follower;

import cn.lsy99.api.activity.generator.mapper.CustomerMapper;
import cn.lsy99.api.activity.generator.mapper.SellerMapper;
import cn.lsy99.api.activity.generator.mapper.ShopFollowMapper;
import cn.lsy99.api.activity.generator.table.Customer;
import cn.lsy99.api.activity.generator.table.Seller;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.CustomerDynamicSqlSupport.customer;
import static cn.lsy99.api.activity.generator.mapper.ShopFollowDynamicSqlSupport.shopFollow;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public class FollowerRepository {
    @Resource
    private SellerMapper sellerMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private ShopFollowMapper shopFollowMapper;

    public Optional<Seller> getSeller(int id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    public List<Customer> getAllFollower(int shopId) {
        SelectStatementProvider selectStatementProvider =
                select(customer.allColumns())
                        .from(customer)
                        .join(shopFollow, on(shopFollow.customerId, equalTo(customer.id)))
                        .where(shopFollow.shopId, isEqualTo(shopId))
                        .build().render(RenderingStrategies.MYBATIS3);
        return customerMapper.selectMany(selectStatementProvider);
    }

    public boolean removeFollower(int shopId, int followerId) {
        DeleteStatementProvider deleteStatementProvider = deleteFrom(shopFollow)
                .where(shopFollow.shopId, isEqualTo(shopId))
                .and(shopFollow.customerId, isEqualTo(followerId))
                .build().render(RenderingStrategies.MYBATIS3);
        return shopFollowMapper.delete(deleteStatementProvider) > 0;
    }
}