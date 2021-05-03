package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class VipDetailDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5779289+08:00", comments="Source Table: vip_detail")
    public static final VipDetail vipDetail = new VipDetail();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5779289+08:00", comments="Source field: vip_detail.id")
    public static final SqlColumn<Integer> id = vipDetail.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5779289+08:00", comments="Source field: vip_detail.pay_time")
    public static final SqlColumn<Date> payTime = vipDetail.payTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5779289+08:00", comments="Source field: vip_detail.add_days")
    public static final SqlColumn<Integer> addDays = vipDetail.addDays;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5779289+08:00", comments="Source field: vip_detail.price")
    public static final SqlColumn<Double> price = vipDetail.price;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5789268+08:00", comments="Source field: vip_detail.shop_id")
    public static final SqlColumn<Integer> shopId = vipDetail.shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5779289+08:00", comments="Source Table: vip_detail")
    public static final class VipDetail extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Date> payTime = column("pay_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> addDays = column("add_days", JDBCType.INTEGER);

        public final SqlColumn<Double> price = column("price", JDBCType.DOUBLE);

        public final SqlColumn<Integer> shopId = column("shop_id", JDBCType.INTEGER);

        public VipDetail() {
            super("vip_detail");
        }
    }
}