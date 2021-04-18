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
public class OrganizerFollow {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-13T19:17:30.7434857+08:00", comments="Source field: organizer_follow.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-13T19:17:30.7434857+08:00", comments="Source field: organizer_follow.organizer_id")
    private Integer organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-13T19:17:30.7434857+08:00", comments="Source field: organizer_follow.customer_id")
    private Integer customerId;
}