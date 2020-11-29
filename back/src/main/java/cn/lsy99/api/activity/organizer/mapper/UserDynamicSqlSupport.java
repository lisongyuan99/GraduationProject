package cn.lsy99.api.activity.organizer.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: user")
    public static final User user = new User();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.id")
    public static final SqlColumn<Integer> id = user.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.nickname")
    public static final SqlColumn<String> nickname = user.nickname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.avatar")
    public static final SqlColumn<String> avatar = user.avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.motto")
    public static final SqlColumn<String> motto = user.motto;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.email")
    public static final SqlColumn<String> email = user.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.phone_num")
    public static final SqlColumn<String> phoneNum = user.phoneNum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.wx_open_id")
    public static final SqlColumn<String> wxOpenId = user.wxOpenId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.type")
    public static final SqlColumn<Integer> type = user.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.create_time")
    public static final SqlColumn<Date> createTime = user.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.update_time")
    public static final SqlColumn<Date> updateTime = user.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.sub_activities_id")
    public static final SqlColumn<Object> subActivitiesId = user.subActivitiesId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source field: user.sub_organizers_id")
    public static final SqlColumn<Object> subOrganizersId = user.subOrganizersId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: user")
    public static final class User extends SqlTable {
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

        public final SqlColumn<Object> subActivitiesId = column("sub_activities_id", JDBCType.ARRAY);

        public final SqlColumn<Object> subOrganizersId = column("sub_organizers_id", JDBCType.ARRAY);

        public User() {
            super("user");
        }
    }
}