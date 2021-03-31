package cn.lsy99.api.activity.generator.table;

import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ActivityCustomer {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5998454+08:00", comments="Source field: activity_customer.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5998454+08:00", comments="Source field: activity_customer.activity_id")
    private Integer activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5998454+08:00", comments="Source field: activity_customer.customer_id")
    private Integer customerId;
}