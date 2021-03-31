package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TestTableDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source Table: test_table")
    public static final TestTable testTable = new TestTable();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.id")
    public static final SqlColumn<Integer> id = testTable.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.lat")
    public static final SqlColumn<Double> lat = testTable.lat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.lng")
    public static final SqlColumn<Double> lng = testTable.lng;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.position")
    public static final SqlColumn<Object> position = testTable.position;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.ids")
    public static final SqlColumn<Object> ids = testTable.ids;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.strings")
    public static final SqlColumn<String[]> strings = testTable.strings;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source Table: test_table")
    public static final class TestTable extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Double> lat = column("lat", JDBCType.DOUBLE);

        public final SqlColumn<Double> lng = column("lng", JDBCType.DOUBLE);

        public final SqlColumn<Object> position = column("position", JDBCType.OTHER);

        public final SqlColumn<Object> ids = column("ids", JDBCType.ARRAY);

        public final SqlColumn<String[]> strings = column("strings", JDBCType.ARRAY, "cn.lsy99.api.activity.generator.handler.ArrayTypeHandler");

        public TestTable() {
            super("test_table");
        }
    }
}