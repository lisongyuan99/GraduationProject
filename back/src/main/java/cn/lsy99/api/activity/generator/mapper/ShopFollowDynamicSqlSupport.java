package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ShopFollowDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5709623+08:00", comments="Source Table: shop_follow")
    public static final ShopFollow shopFollow = new ShopFollow();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5709623+08:00", comments="Source field: shop_follow.id")
    public static final SqlColumn<Integer> id = shopFollow.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5709623+08:00", comments="Source field: shop_follow.shop_id")
    public static final SqlColumn<Integer> shopId = shopFollow.shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5709623+08:00", comments="Source field: shop_follow.customer_id")
    public static final SqlColumn<Integer> customerId = shopFollow.customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5709623+08:00", comments="Source Table: shop_follow")
    public static final class ShopFollow extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> shopId = column("shop_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> customerId = column("customer_id", JDBCType.INTEGER);

        public ShopFollow() {
            super("shop_follow");
        }
    }
}