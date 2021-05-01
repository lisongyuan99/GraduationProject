package cn.lsy99.api.activity.generator.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ActivitySuggestionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.7036721+08:00", comments="Source Table: activity_suggestion")
    public static final ActivitySuggestion activitySuggestion = new ActivitySuggestion();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.7036721+08:00", comments="Source field: activity_suggestion.id")
    public static final SqlColumn<Integer> id = activitySuggestion.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.7036721+08:00", comments="Source field: activity_suggestion.activity_id")
    public static final SqlColumn<Integer> activityId = activitySuggestion.activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.7036721+08:00", comments="Source field: activity_suggestion.price")
    public static final SqlColumn<Double> price = activitySuggestion.price;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.7036721+08:00", comments="Source field: activity_suggestion.add_time")
    public static final SqlColumn<Date> addTime = activitySuggestion.addTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.7036721+08:00", comments="Source Table: activity_suggestion")
    public static final class ActivitySuggestion extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> activityId = column("activity_id", JDBCType.INTEGER);

        public final SqlColumn<Double> price = column("price", JDBCType.DOUBLE);

        public final SqlColumn<Date> addTime = column("add_time", JDBCType.TIMESTAMP);

        public ActivitySuggestion() {
            super("activity_suggestion");
        }
    }
}