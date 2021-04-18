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
public class ActivityCount {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8089243+08:00", comments="Source field: activity_count.activity_id")
    private Integer activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8089243+08:00", comments="Source field: activity_count.count")
    private Integer count;
}