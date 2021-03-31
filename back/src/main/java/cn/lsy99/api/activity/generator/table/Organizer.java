package cn.lsy99.api.activity.generator.table;

import java.util.Date;
import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Organizer {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5928646+08:00", comments="Source field: organizer.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5928646+08:00", comments="Source field: organizer.nickname")
    private String nickname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5938608+08:00", comments="Source field: organizer.avatar")
    private String avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5938608+08:00", comments="Source field: organizer.motto")
    private String motto;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5938608+08:00", comments="Source field: organizer.email")
    private String email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5938608+08:00", comments="Source field: organizer.phone_num")
    private String phoneNum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5938608+08:00", comments="Source field: organizer.wx_open_id")
    private String wxOpenId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5938608+08:00", comments="Source field: organizer.type")
    private Integer type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5938608+08:00", comments="Source field: organizer.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5938608+08:00", comments="Source field: organizer.update_time")
    private Date updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5938608+08:00", comments="Source field: organizer.position_code")
    private Integer positionCode;
}