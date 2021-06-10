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
public class Comment {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-10T16:16:02.7756274+08:00", comments="Source field: comment.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-10T16:16:02.7761663+08:00", comments="Source field: comment.customer_id")
    private Integer customerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-10T16:16:02.7761663+08:00", comments="Source field: comment.activity_id")
    private Integer activityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-10T16:16:02.7761663+08:00", comments="Source field: comment.text")
    private String text;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-10T16:16:02.7761663+08:00", comments="Source field: comment.order_id")
    private Integer orderId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-10T16:16:02.7761663+08:00", comments="Source field: comment.publish_time")
    private Date publishTime;
}