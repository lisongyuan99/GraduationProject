package cn.lsy99.api.activity.generator.table;

import javax.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ActivityStatistics {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source field: activity_statistics.activity_id")
    private Integer activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source field: activity_statistics.visits")
    private String visits;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source field: activity_statistics.organizer_id")
    private Integer organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source field: activity_statistics.visit_sum")
    private Integer visitSum;
}