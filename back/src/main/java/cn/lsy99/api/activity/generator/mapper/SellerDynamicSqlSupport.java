package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SellerDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    public static final Seller seller = new Seller();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.id")
    public static final SqlColumn<Integer> id = seller.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.nickname")
    public static final SqlColumn<String> nickname = seller.nickname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.avatar")
    public static final SqlColumn<String> avatar = seller.avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.phone")
    public static final SqlColumn<String> phone = seller.phone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.wx_open_id")
    public static final SqlColumn<String> wxOpenId = seller.wxOpenId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.type")
    public static final SqlColumn<Integer> type = seller.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.shop_id")
    public static final SqlColumn<Integer> shopId = seller.shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    public static final class Seller extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> nickname = column("nickname", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<String> phone = column("phone", JDBCType.VARCHAR);

        public final SqlColumn<String> wxOpenId = column("wx_open_id", JDBCType.VARCHAR);

        public final SqlColumn<Integer> type = column("type", JDBCType.INTEGER);

        public final SqlColumn<Integer> shopId = column("shop_id", JDBCType.INTEGER);

        public Seller() {
            super("seller");
        }
    }
}