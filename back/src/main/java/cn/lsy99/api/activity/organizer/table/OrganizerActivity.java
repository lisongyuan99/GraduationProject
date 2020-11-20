package cn.lsy99.api.activity.organizer.table;

import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class OrganizerActivity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4790015+08:00", comments="Source field: organizer_activity.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4790015+08:00", comments="Source field: organizer_activity.organizer_id")
    private Integer organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4790015+08:00", comments="Source field: organizer_activity.activity_id")
    private String activityId;
}