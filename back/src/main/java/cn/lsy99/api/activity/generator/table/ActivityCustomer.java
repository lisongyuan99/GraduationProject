package cn.lsy99.api.activity.generator.table;

import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ActivityCustomer {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4127321+08:00", comments="Source field: activity_customer.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4127321+08:00", comments="Source field: activity_customer.activity_id")
    private Integer activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4127321+08:00", comments="Source field: activity_customer.customer_id")
    private Integer customerId;
}