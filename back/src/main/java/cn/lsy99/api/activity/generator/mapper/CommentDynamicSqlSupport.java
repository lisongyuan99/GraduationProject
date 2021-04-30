package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CommentDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2731156+08:00", comments="Source Table: comment")
    public static final Comment comment = new Comment();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2731156+08:00", comments="Source field: comment.id")
    public static final SqlColumn<Integer> id = comment.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2731156+08:00", comments="Source field: comment.customer_id")
    public static final SqlColumn<Integer> customerId = comment.customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2731156+08:00", comments="Source field: comment.activity_id")
    public static final SqlColumn<Integer> activityId = comment.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2731156+08:00", comments="Source field: comment.text")
    public static final SqlColumn<String> text = comment.text;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2731156+08:00", comments="Source Table: comment")
    public static final class Comment extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> customerId = column("customer_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> activityId = column("activity_id", JDBCType.INTEGER);

        public final SqlColumn<String> text = column("text", JDBCType.VARCHAR);

        public Comment() {
            super("comment");
        }
    }
}