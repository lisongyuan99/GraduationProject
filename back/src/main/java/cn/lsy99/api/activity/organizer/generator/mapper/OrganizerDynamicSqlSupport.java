package cn.lsy99.api.activity.organizer.generator.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class OrganizerDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8576913+08:00", comments="Source Table: organizer")
    public static final Organizer organizer = new Organizer();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.id")
    public static final SqlColumn<Integer> id = organizer.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.nickname")
    public static final SqlColumn<String> nickname = organizer.nickname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.avatar")
    public static final SqlColumn<String> avatar = organizer.avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.motto")
    public static final SqlColumn<String> motto = organizer.motto;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.email")
    public static final SqlColumn<String> email = organizer.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.phone_num")
    public static final SqlColumn<String> phoneNum = organizer.phoneNum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.wx_open_id")
    public static final SqlColumn<String> wxOpenId = organizer.wxOpenId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.type")
    public static final SqlColumn<Integer> type = organizer.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.create_time")
    public static final SqlColumn<Date> createTime = organizer.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.update_time")
    public static final SqlColumn<Date> updateTime = organizer.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8586916+08:00", comments="Source field: organizer.position_code")
    public static final SqlColumn<Integer> positionCode = organizer.positionCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8576913+08:00", comments="Source Table: organizer")
    public static final class Organizer extends SqlTable {
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

        public final SqlColumn<Integer> positionCode = column("position_code", JDBCType.INTEGER);

        public Organizer() {
            super("organizer");
        }
    }
}