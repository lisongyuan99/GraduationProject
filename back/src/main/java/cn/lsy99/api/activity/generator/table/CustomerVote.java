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
public class CustomerVote {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.552993+08:00", comments="Source field: customer_vote.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.552993+08:00", comments="Source field: customer_vote.customer_id")
    private Integer customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.552993+08:00", comments="Source field: customer_vote.activity_id")
    private Integer activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.552993+08:00", comments="Source field: customer_vote.type")
    private Boolean type;
}