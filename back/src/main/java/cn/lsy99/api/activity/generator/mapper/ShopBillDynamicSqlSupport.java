package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ShopBillDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.13373+08:00", comments="Source Table: shop_bill")
    public static final ShopBill shopBill = new ShopBill();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.13373+08:00", comments="Source field: shop_bill.id")
    public static final SqlColumn<Integer> id = shopBill.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.13373+08:00", comments="Source field: shop_bill.shop_id")
    public static final SqlColumn<Integer> shopId = shopBill.shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.13373+08:00", comments="Source field: shop_bill.bill_time")
    public static final SqlColumn<Date> billTime = shopBill.billTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.13373+08:00", comments="Source field: shop_bill.amount")
    public static final SqlColumn<Double> amount = shopBill.amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.13373+08:00", comments="Source Table: shop_bill")
    public static final class ShopBill extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> shopId = column("shop_id", JDBCType.INTEGER);

        public final SqlColumn<Date> billTime = column("bill_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Double> amount = column("amount", JDBCType.DOUBLE);

        public ShopBill() {
            super("shop_bill");
        }
    }
}