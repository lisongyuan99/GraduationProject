package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CartDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8169027+08:00", comments="Source Table: cart")
    public static final Cart cart = new Cart();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8169027+08:00", comments="Source field: cart.customer_id")
    public static final SqlColumn<Integer> customerId = cart.customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8169027+08:00", comments="Source field: cart.details")
    public static final SqlColumn<Object> details = cart.details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8169027+08:00", comments="Source Table: cart")
    public static final class Cart extends SqlTable {
        public final SqlColumn<Integer> customerId = column("customer_id", JDBCType.INTEGER);

        public final SqlColumn<Object> details = column("details", JDBCType.OTHER);

        public Cart() {
            super("cart");
        }
    }
}