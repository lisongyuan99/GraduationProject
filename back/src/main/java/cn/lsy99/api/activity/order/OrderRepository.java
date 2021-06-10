package cn.lsy99.api.activity.order;

import cn.lsy99.api.activity.generator.OrderStatus;
import cn.lsy99.api.activity.generator.mapper.*;
import cn.lsy99.api.activity.generator.table.*;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static cn.lsy99.api.activity.generator.mapper.ActivityDynamicSqlSupport.activity;
import static cn.lsy99.api.activity.generator.mapper.OrderInfoDynamicSqlSupport.orderInfo;
import static cn.lsy99.api.activity.generator.mapper.ShopDynamicSqlSupport.shop;
import static cn.lsy99.api.activity.generator.mapper.CommentDynamicSqlSupport.comment;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ShopBalanceMapper shopBalanceMapper;

    public Optional<OrderInfo> getById(int id) {
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    public List<OrderInfo> getByActivityId(int id) {
        return orderInfoMapper.select(c -> c.where(orderInfo.activityId, isEqualTo(id)));
    }

    public List<OrderInfo> getByShopId(int id) {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(orderInfo.allColumns())
                .from(orderInfo)
                .join(activity).on(orderInfo.activityId, equalTo(activity.id))
                .join(shop).on(shop.id, equalTo(activity.shopId))
                .where(shop.id, isEqualTo(id))
                .build().render(RenderingStrategies.MYBATIS3);
        return orderInfoMapper.selectMany(selectStatementProvider);
    }

    public Optional<Seller> getSeller(int bossId) {
        return sellerMapper.selectByPrimaryKey(bossId);
    }


    public Optional<Activity> getActivity(int activityId) {
        return activityMapper.selectByPrimaryKey(activityId);
    }

    public Optional<Comment> getComment(int orderId) {
        return commentMapper.selectOne(c -> c.where(comment.orderId, isEqualTo(orderId)));
    }

    public int verifyOrder(int orderId) {
        OrderInfo orderInfo = OrderInfo.builder()
                .id(orderId).useTime(new Date()).status(OrderStatus.USED.ordinal())
                .build();
        return orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
    }

    public double getBalance(int shopId) {
        Optional<ShopBalance> shopBalance = shopBalanceMapper.selectByPrimaryKey(shopId);
        if (shopBalance.isEmpty()) {
            return 0;
        } else {
            return shopBalance.get().getBalance();
        }
    }

    public int updateBalance(int shopId, double balance) {
        ShopBalance shopBalance = ShopBalance.builder().shopId(shopId).balance(balance).build();
        return shopBalanceMapper.updateByPrimaryKeySelective(shopBalance);
    }

}
