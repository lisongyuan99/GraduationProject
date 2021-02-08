package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ActivityCustomerDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4137294+08:00", comments="Source Table: activity_customer")
    public static final ActivityCustomer activityCustomer = new ActivityCustomer();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4137294+08:00", comments="Source field: activity_customer.id")
    public static final SqlColumn<Integer> id = activityCustomer.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4137294+08:00", comments="Source field: activity_customer.activity_id")
    public static final SqlColumn<Integer> activityId = activityCustomer.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4137294+08:00", comments="Source field: activity_customer.customer_id")
    public static final SqlColumn<Integer> customerId = activityCustomer.customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4137294+08:00", comments="Source Table: activity_customer")
    public static final class ActivityCustomer extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> activityId = column("activity_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> customerId = column("customer_id", JDBCType.INTEGER);

        public ActivityCustomer() {
            super("activity_customer");
        }
    }
}