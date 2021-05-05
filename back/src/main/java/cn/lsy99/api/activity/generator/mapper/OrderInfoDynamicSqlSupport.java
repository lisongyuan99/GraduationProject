package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class OrderInfoDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.099825+08:00", comments="Source Table: order_info")
    public static final OrderInfo orderInfo = new OrderInfo();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.099825+08:00", comments="Source field: order_info.id")
    public static final SqlColumn<Integer> id = orderInfo.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1008184+08:00", comments="Source field: order_info.customer_id")
    public static final SqlColumn<Integer> customerId = orderInfo.customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1008184+08:00", comments="Source field: order_info.status")
    public static final SqlColumn<Integer> status = orderInfo.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1008184+08:00", comments="Source field: order_info.price")
    public static final SqlColumn<Double> price = orderInfo.price;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1008184+08:00", comments="Source field: order_info.create_time")
    public static final SqlColumn<Date> createTime = orderInfo.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1008184+08:00", comments="Source field: order_info.pay_time")
    public static final SqlColumn<Date> payTime = orderInfo.payTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1008184+08:00", comments="Source field: order_info.refund_time")
    public static final SqlColumn<Date> refundTime = orderInfo.refundTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1008184+08:00", comments="Source field: order_info.count")
    public static final SqlColumn<Integer> count = orderInfo.count;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1008184+08:00", comments="Source field: order_info.activity_id")
    public static final SqlColumn<Integer> activityId = orderInfo.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1008184+08:00", comments="Source field: order_info.use_time")
    public static final SqlColumn<Date> useTime = orderInfo.useTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.099825+08:00", comments="Source Table: order_info")
    public static final class OrderInfo extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> customerId = column("customer_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<Double> price = column("price", JDBCType.DOUBLE);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> payTime = column("pay_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> refundTime = column("refund_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> count = column("count", JDBCType.INTEGER);

        public final SqlColumn<Integer> activityId = column("activity_id", JDBCType.INTEGER);

        public final SqlColumn<Date> useTime = column("use_time", JDBCType.TIMESTAMP);

        public OrderInfo() {
            super("order_info");
        }
    }
}