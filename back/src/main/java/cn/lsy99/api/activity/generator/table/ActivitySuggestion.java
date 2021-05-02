package cn.lsy99.api.activity.generator.table;

import java.util.Date;
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
public class ActivitySuggestion {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7454144+08:00", comments="Source field: activity_suggestion.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7454144+08:00", comments="Source field: activity_suggestion.activity_id")
    private Integer activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7454144+08:00", comments="Source field: activity_suggestion.price")
    private Double price;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7454144+08:00", comments="Source field: activity_suggestion.add_time")
    private Date addTime;
}