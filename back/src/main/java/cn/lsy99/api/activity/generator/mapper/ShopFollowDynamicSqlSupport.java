package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ShopFollowDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8428379+08:00", comments="Source Table: shop_follow")
    public static final ShopFollow shopFollow = new ShopFollow();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8438375+08:00", comments="Source field: shop_follow.id")
    public static final SqlColumn<Integer> id = shopFollow.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8438375+08:00", comments="Source field: shop_follow.organizer_id")
    public static final SqlColumn<Integer> organizerId = shopFollow.organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8438375+08:00", comments="Source field: shop_follow.customer_id")
    public static final SqlColumn<Integer> customerId = shopFollow.customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8438375+08:00", comments="Source Table: shop_follow")
    public static final class ShopFollow extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> organizerId = column("organizer_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> customerId = column("customer_id", JDBCType.INTEGER);

        public ShopFollow() {
            super("shop_follow");
        }
    }
}