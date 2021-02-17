package cn.lsy99.api.activity.generator.table;

import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ActivityVisits {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source field: activity_visits.activity_id")
    private Integer activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source field: activity_visits.visits")
    private Object visits;
}