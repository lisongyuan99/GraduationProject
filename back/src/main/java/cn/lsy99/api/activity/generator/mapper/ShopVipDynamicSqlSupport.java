package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ShopVipDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5739406+08:00", comments="Source Table: shop_vip")
    public static final ShopVip shopVip = new ShopVip();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5739406+08:00", comments="Source field: shop_vip.shop_id")
    public static final SqlColumn<Integer> shopId = shopVip.shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5739406+08:00", comments="Source field: shop_vip.expire_time")
    public static final SqlColumn<Date> expireTime = shopVip.expireTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5739406+08:00", comments="Source Table: shop_vip")
    public static final class ShopVip extends SqlTable {
        public final SqlColumn<Integer> shopId = column("shop_id", JDBCType.INTEGER);

        public final SqlColumn<Date> expireTime = column("expire_time", JDBCType.TIMESTAMP);

        public ShopVip() {
            super("shop_vip");
        }
    }
}