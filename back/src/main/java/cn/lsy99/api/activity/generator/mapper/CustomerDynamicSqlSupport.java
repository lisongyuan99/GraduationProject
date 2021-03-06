package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CustomerDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: customer")
    public static final Customer customer = new Customer();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source field: customer.id")
    public static final SqlColumn<Integer> id = customer.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source field: customer.nickname")
    public static final SqlColumn<String> nickname = customer.nickname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source field: customer.avatar")
    public static final SqlColumn<String> avatar = customer.avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source field: customer.motto")
    public static final SqlColumn<String> motto = customer.motto;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source field: customer.email")
    public static final SqlColumn<String> email = customer.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source field: customer.phone_num")
    public static final SqlColumn<String> phoneNum = customer.phoneNum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source field: customer.wx_open_id")
    public static final SqlColumn<String> wxOpenId = customer.wxOpenId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source field: customer.type")
    public static final SqlColumn<Integer> type = customer.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source field: customer.create_time")
    public static final SqlColumn<Date> createTime = customer.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source field: customer.update_time")
    public static final SqlColumn<Date> updateTime = customer.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: customer")
    public static final class Customer extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> nickname = column("nickname", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<String> motto = column("motto", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> phoneNum = column("phone_num", JDBCType.VARCHAR);

        public final SqlColumn<String> wxOpenId = column("wx_open_id", JDBCType.VARCHAR);

        public final SqlColumn<Integer> type = column("type", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public Customer() {
            super("customer");
        }
    }
}