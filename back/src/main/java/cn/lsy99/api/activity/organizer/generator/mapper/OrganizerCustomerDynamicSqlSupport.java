package cn.lsy99.api.activity.organizer.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class OrganizerCustomerDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8646929+08:00", comments="Source Table: organizer_customer")
    public static final OrganizerCustomer organizerCustomer = new OrganizerCustomer();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8656934+08:00", comments="Source field: organizer_customer.id")
    public static final SqlColumn<Integer> id = organizerCustomer.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8656934+08:00", comments="Source field: organizer_customer.organizer_id")
    public static final SqlColumn<Integer> organizerId = organizerCustomer.organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8656934+08:00", comments="Source field: organizer_customer.customer_id")
    public static final SqlColumn<Integer> customerId = organizerCustomer.customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8646929+08:00", comments="Source Table: organizer_customer")
    public static final class OrganizerCustomer extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> organizerId = column("organizer_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> customerId = column("customer_id", JDBCType.INTEGER);

        public OrganizerCustomer() {
            super("organizer_customer");
        }
    }
}