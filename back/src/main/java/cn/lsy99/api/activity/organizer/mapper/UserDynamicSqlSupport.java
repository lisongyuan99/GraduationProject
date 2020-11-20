package cn.lsy99.api.activity.organizer.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4849852+08:00", comments="Source Table: user")
    public static final User user = new User();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.id")
    public static final SqlColumn<Integer> id = user.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.username")
    public static final SqlColumn<String> username = user.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.name")
    public static final SqlColumn<String> name = user.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.password")
    public static final SqlColumn<String> password = user.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.email")
    public static final SqlColumn<String> email = user.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.phone_area_code")
    public static final SqlColumn<String> phoneAreaCode = user.phoneAreaCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.phone_num")
    public static final SqlColumn<String> phoneNum = user.phoneNum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.wx_union_id")
    public static final SqlColumn<String> wxUnionId = user.wxUnionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.role")
    public static final SqlColumn<String> role = user.role;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.create_time")
    public static final SqlColumn<Date> createTime = user.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4859935+08:00", comments="Source field: user.update_time")
    public static final SqlColumn<Date> updateTime = user.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4849852+08:00", comments="Source Table: user")
    public static final class User extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> phoneAreaCode = column("phone_area_code", JDBCType.VARCHAR);

        public final SqlColumn<String> phoneNum = column("phone_num", JDBCType.VARCHAR);

        public final SqlColumn<String> wxUnionId = column("wx_union_id", JDBCType.VARCHAR);

        public final SqlColumn<String> role = column("role", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public User() {
            super("user");
        }
    }
}