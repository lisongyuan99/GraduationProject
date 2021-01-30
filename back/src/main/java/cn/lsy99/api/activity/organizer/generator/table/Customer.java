package cn.lsy99.api.activity.organizer.generator.table;

import java.util.Date;
import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Customer {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8536903+08:00", comments="Source field: customer.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8536903+08:00", comments="Source field: customer.nickname")
    private String nickname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8536903+08:00", comments="Source field: customer.avatar")
    private String avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8536903+08:00", comments="Source field: customer.motto")
    private String motto;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8536903+08:00", comments="Source field: customer.email")
    private String email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8536903+08:00", comments="Source field: customer.phone_num")
    private String phoneNum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8536903+08:00", comments="Source field: customer.wx_open_id")
    private String wxOpenId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8536903+08:00", comments="Source field: customer.type")
    private Integer type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8546908+08:00", comments="Source field: customer.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-30T23:51:21.8546908+08:00", comments="Source field: customer.update_time")
    private Date updateTime;
}