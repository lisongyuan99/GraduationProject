package cn.lsy99.api.activity.generator.table;

import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class OrganizerCustomer {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4147266+08:00", comments="Source field: organizer_customer.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.415724+08:00", comments="Source field: organizer_customer.organizer_id")
    private Integer organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.415724+08:00", comments="Source field: organizer_customer.customer_id")
    private Integer customerId;
}