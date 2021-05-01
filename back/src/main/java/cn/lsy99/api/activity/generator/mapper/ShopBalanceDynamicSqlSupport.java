package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ShopBalanceDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6880502+08:00", comments="Source Table: shop_balance")
    public static final ShopBalance shopBalance = new ShopBalance();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6880502+08:00", comments="Source field: shop_balance.shop_id")
    public static final SqlColumn<Integer> shopId = shopBalance.shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6880502+08:00", comments="Source field: shop_balance.balance")
    public static final SqlColumn<Double> balance = shopBalance.balance;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6880502+08:00", comments="Source Table: shop_balance")
    public static final class ShopBalance extends SqlTable {
        public final SqlColumn<Integer> shopId = column("shop_id", JDBCType.INTEGER);

        public final SqlColumn<Double> balance = column("balance", JDBCType.DOUBLE);

        public ShopBalance() {
            super("shop_balance");
        }
    }
}