package cn.lsy99.api.activity.organizer.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserOrganizerDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    public static final UserOrganizer userOrganizer = new UserOrganizer();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: user_organizer.id")
    public static final SqlColumn<Integer> id = userOrganizer.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: user_organizer.user_id")
    public static final SqlColumn<Integer> userId = userOrganizer.userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source field: user_organizer.organizer_id")
    public static final SqlColumn<String> organizerId = userOrganizer.organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    public static final class UserOrganizer extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> userId = column("user_id", JDBCType.INTEGER);

        public final SqlColumn<String> organizerId = column("organizer_id", JDBCType.VARCHAR);

        public UserOrganizer() {
            super("user_organizer");
        }
    }
}