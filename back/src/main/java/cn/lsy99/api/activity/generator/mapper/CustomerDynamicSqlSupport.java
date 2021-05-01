package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CustomerDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source Table: customer")
    public static final Customer customer = new Customer();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source field: customer.id")
    public static final SqlColumn<Integer> id = customer.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source field: customer.nickname")
    public static final SqlColumn<String> nickname = customer.nickname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source field: customer.avatar")
    public static final SqlColumn<String> avatar = customer.avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source field: customer.motto")
    public static final SqlColumn<String> motto = customer.motto;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source field: customer.phone_num")
    public static final SqlColumn<String> phoneNum = customer.phoneNum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source field: customer.wx_open_id")
    public static final SqlColumn<String> wxOpenId = customer.wxOpenId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source field: customer.type")
    public static final SqlColumn<Integer> type = customer.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6568099+08:00", comments="Source Table: customer")
    public static final class Customer extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> nickname = column("nickname", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<String> motto = column("motto", JDBCType.VARCHAR);

        public final SqlColumn<String> phoneNum = column("phone_num", JDBCType.VARCHAR);

        public final SqlColumn<String> wxOpenId = column("wx_open_id", JDBCType.VARCHAR);

        public final SqlColumn<Integer> type = column("type", JDBCType.INTEGER);

        public Customer() {
            super("customer");
        }
    }
}