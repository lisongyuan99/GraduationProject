package cn.lsy99.api.activity.organizer.table;

import java.util.Date;
import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Organizer {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source field: organizer.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source field: organizer.username")
    private String username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source field: organizer.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source field: organizer.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source field: organizer.email")
    private String email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.phone_area_code")
    private String phoneAreaCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.phone_num")
    private String phoneNum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.wx_union_id")
    private String wxUnionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.role")
    private String role;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4819928+08:00", comments="Source field: organizer.update_time")
    private Date updateTime;
}