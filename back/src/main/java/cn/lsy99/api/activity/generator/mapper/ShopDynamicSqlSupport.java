package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ShopDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source Table: shop")
    public static final Shop shop = new Shop();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source field: shop.id")
    public static final SqlColumn<Integer> id = shop.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source field: shop.status")
    public static final SqlColumn<Integer> status = shop.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source field: shop.name")
    public static final SqlColumn<String> name = shop.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source field: shop.description")
    public static final SqlColumn<String> description = shop.description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source field: shop.avatar")
    public static final SqlColumn<String> avatar = shop.avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source field: shop.position_code")
    public static final SqlColumn<Integer> positionCode = shop.positionCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source field: shop.address")
    public static final SqlColumn<String> address = shop.address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source field: shop.lat")
    public static final SqlColumn<Double> lat = shop.lat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source field: shop.pos")
    public static final SqlColumn<Double> pos = shop.pos;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source field: shop.pictures")
    public static final SqlColumn<String> pictures = shop.pictures;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source Table: shop")
    public static final class Shop extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<Integer> positionCode = column("position_code", JDBCType.INTEGER);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<Double> lat = column("lat", JDBCType.DOUBLE);

        public final SqlColumn<Double> pos = column("pos", JDBCType.DOUBLE);

        public final SqlColumn<String> pictures = column("pictures", JDBCType.VARCHAR);

        public Shop() {
            super("shop");
        }
    }
}