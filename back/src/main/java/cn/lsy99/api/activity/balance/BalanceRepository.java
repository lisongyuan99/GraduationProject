package cn.lsy99.api.activity.balance;

import cn.lsy99.api.activity.generator.mapper.*;
import cn.lsy99.api.activity.generator.table.*;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.ActivityDynamicSqlSupport.activity;
import static cn.lsy99.api.activity.generator.mapper.ActivitySuggestionDynamicSqlSupport.activitySuggestion;
import static cn.lsy99.api.activity.generator.mapper.OrderInfoDynamicSqlSupport.orderInfo;
import static cn.lsy99.api.activity.generator.mapper.ShopBillDynamicSqlSupport.shopBill;
import static cn.lsy99.api.activity.generator.mapper.VipDetailDynamicSqlSupport.vipDetail;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public class BalanceRepository {
    @Autowired
    private ShopBalanceMapper shopBalanceMapper;
    @Autowired
    private ShopBillMapper shopBillMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private VipDetailMapper vipDetailMapper;
    @Resource
    private SellerMapper sellerMapper;
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private ActivitySuggestionMapper activitySuggestionMapper;

    public Optional<Seller> getSeller(int bossId) {
        return sellerMapper.selectByPrimaryKey(bossId);
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

    // 获取充值提现账单
    public List<ShopBill> getBills(int shopId) {
        return shopBillMapper.select(c -> c.where(shopBill.shopId, isEqualTo(shopId)));
    }

    // 获取所有订单
    public List<OrderInfo> getOrder(int shopId) {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(orderInfo.allColumns())
                .from(orderInfo)
                .join(activity)
                .on(orderInfo.activityId, equalTo(activity.id))
                .where(activity.shopId, isEqualTo(shopId))
                .build().render(RenderingStrategies.MYBATIS3);
        return orderInfoMapper.selectMany(selectStatementProvider);
    }

    public List<ActivitySuggestion> getSuggestion(int shopId) {
        SelectStatementProvider selectStatementProvider = SqlBuilder
                .select(activitySuggestion.allColumns())
                .from(activitySuggestion)
                .join(activity)
                .on(activity.id, equalTo(activitySuggestion.activityId))
                .where(activity.shopId, isEqualTo(shopId))
                .build().render(RenderingStrategies.MYBATIS3);
        return activitySuggestionMapper.selectMany(selectStatementProvider);

    }

    // 获取所有vip明细
    public List<VipDetail> getVipDetail(int shopId) {
        return vipDetailMapper.select(c -> c.where(vipDetail.shopId, isEqualTo(shopId)));
    }

    // 获取活动
    public Optional<Activity> getActivity(int activityId) {
        return activityMapper.selectByPrimaryKey(activityId);
    }

    // 更新账单
    public int updateBalance(int shopId, double balance) {
        return shopBalanceMapper.updateByPrimaryKey(ShopBalance.builder().shopId(shopId).balance(balance).build());
    }

    // 添加账单
    public int addBill(int shopId, Date time, double amount) {
        ShopBill shopBill = ShopBill.builder().shopId(shopId).billTime(time).amount(amount).build();
        return shopBillMapper.insert(shopBill);
    }

}
