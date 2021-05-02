package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CustomerVoteDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7025294+08:00", comments="Source Table: customer_vote")
    public static final CustomerVote customerVote = new CustomerVote();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7025294+08:00", comments="Source field: customer_vote.id")
    public static final SqlColumn<Integer> id = customerVote.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7035337+08:00", comments="Source field: customer_vote.customer_id")
    public static final SqlColumn<Integer> customerId = customerVote.customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7035337+08:00", comments="Source field: customer_vote.activity_id")
    public static final SqlColumn<Integer> activityId = customerVote.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7035337+08:00", comments="Source field: customer_vote.type")
    public static final SqlColumn<Boolean> type = customerVote.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7025294+08:00", comments="Source Table: customer_vote")
    public static final class CustomerVote extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> customerId = column("customer_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> activityId = column("activity_id", JDBCType.INTEGER);

        public final SqlColumn<Boolean> type = column("type", JDBCType.BIT);

        public CustomerVote() {
            super("customer_vote");
        }
    }
}