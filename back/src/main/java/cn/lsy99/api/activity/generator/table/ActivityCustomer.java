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
public class ActivityCustomer {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6137161+08:00", comments="Source field: activity_customer.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6137161+08:00", comments="Source field: activity_customer.activity_id")
    private Integer activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6137161+08:00", comments="Source field: activity_customer.customer_id")
    private Integer customerId;
}