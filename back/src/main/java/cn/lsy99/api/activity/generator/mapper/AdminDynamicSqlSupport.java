package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AdminDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.267135+08:00", comments="Source Table: admin")
    public static final Admin admin = new Admin();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2681292+08:00", comments="Source field: admin.name")
    public static final SqlColumn<String> name = admin.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2681292+08:00", comments="Source field: admin.password")
    public static final SqlColumn<String> password = admin.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2681292+08:00", comments="Source Table: admin")
    public static final class Admin extends SqlTable {
        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public Admin() {
            super("admin");
        }
    }
}