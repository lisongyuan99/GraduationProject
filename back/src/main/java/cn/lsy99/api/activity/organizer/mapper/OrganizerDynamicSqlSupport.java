package cn.lsy99.api.activity.organizer.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class OrganizerDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source Table: organizer")
    public static final Organizer organizer = new Organizer();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.id")
    public static final SqlColumn<Integer> id = organizer.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.username")
    public static final SqlColumn<String> username = organizer.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.name")
    public static final SqlColumn<String> name = organizer.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.password")
    public static final SqlColumn<String> password = organizer.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.email")
    public static final SqlColumn<String> email = organizer.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.phone_area_code")
    public static final SqlColumn<String> phoneAreaCode = organizer.phoneAreaCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.phone_num")
    public static final SqlColumn<String> phoneNum = organizer.phoneNum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source field: organizer.wx_union_id")
    public static final SqlColumn<String> wxUnionId = organizer.wxUnionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source field: organizer.role")
    public static final SqlColumn<String> role = organizer.role;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source field: organizer.create_time")
    public static final SqlColumn<Date> createTime = organizer.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source field: organizer.update_time")
    public static final SqlColumn<Date> updateTime = organizer.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source Table: organizer")
    public static final class Organizer extends SqlTable {
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

        public Organizer() {
            super("organizer");
        }
    }
}