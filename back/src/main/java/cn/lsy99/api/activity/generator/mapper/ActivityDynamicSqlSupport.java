package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ActivityDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5150946+08:00", comments="Source Table: activity")
    public static final Activity activity = new Activity();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5150946+08:00", comments="Source field: activity.id")
    public static final SqlColumn<Integer> id = activity.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5150946+08:00", comments="Source field: activity.title")
    public static final SqlColumn<String> title = activity.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.detail")
    public static final SqlColumn<String> detail = activity.detail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.subtitle")
    public static final SqlColumn<String> subtitle = activity.subtitle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.begin_time")
    public static final SqlColumn<Date> beginTime = activity.beginTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.shop_id")
    public static final SqlColumn<Integer> shopId = activity.shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.category_id")
    public static final SqlColumn<Integer> categoryId = activity.categoryId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.pos_lat")
    public static final SqlColumn<Double> posLat = activity.posLat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.pos_lng")
    public static final SqlColumn<Double> posLng = activity.posLng;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.position_code")
    public static final SqlColumn<Integer> positionCode = activity.positionCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.position_detail")
    public static final SqlColumn<String> positionDetail = activity.positionDetail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.pics")
    public static final SqlColumn<String> pics = activity.pics;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.status")
    public static final SqlColumn<Integer> status = activity.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.price")
    public static final SqlColumn<Double> price = activity.price;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.price_ori")
    public static final SqlColumn<Double> priceOri = activity.priceOri;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.free")
    public static final SqlColumn<Boolean> free = activity.free;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.sum")
    public static final SqlColumn<Integer> sum = activity.sum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5160921+08:00", comments="Source field: activity.used")
    public static final SqlColumn<Integer> used = activity.used;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5150946+08:00", comments="Source Table: activity")
    public static final class Activity extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> detail = column("detail", JDBCType.VARCHAR);

        public final SqlColumn<String> subtitle = column("subtitle", JDBCType.VARCHAR);

        public final SqlColumn<Date> beginTime = column("begin_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> shopId = column("shop_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> categoryId = column("category_id", JDBCType.INTEGER);

        public final SqlColumn<Double> posLat = column("pos_lat", JDBCType.DOUBLE);

        public final SqlColumn<Double> posLng = column("pos_lng", JDBCType.DOUBLE);

        public final SqlColumn<Integer> positionCode = column("position_code", JDBCType.INTEGER);

        public final SqlColumn<String> positionDetail = column("position_detail", JDBCType.VARCHAR);

        public final SqlColumn<String> pics = column("pics", JDBCType.VARCHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<Double> price = column("price", JDBCType.DOUBLE);

        public final SqlColumn<Double> priceOri = column("price_ori", JDBCType.DOUBLE);

        public final SqlColumn<Boolean> free = column("free", JDBCType.BIT);

        public final SqlColumn<Integer> sum = column("sum", JDBCType.INTEGER);

        public final SqlColumn<Integer> used = column("used", JDBCType.INTEGER);

        public Activity() {
            super("activity");
        }
    }
}