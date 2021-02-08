package cn.lsy99.api.activity.generator.table;

import java.util.Date;
import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Activity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3728486+08:00", comments="Source field: activity.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3748336+08:00", comments="Source field: activity.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3748336+08:00", comments="Source field: activity.detail")
    private String detail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3748336+08:00", comments="Source field: activity.subtitle")
    private String subtitle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.375831+08:00", comments="Source field: activity.begin_time")
    private Date beginTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.375831+08:00", comments="Source field: activity.end_time")
    private Date endTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.375831+08:00", comments="Source field: activity.time_type")
    private Integer timeType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.375831+08:00", comments="Source field: activity.big_pic")
    private String bigPic;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.376829+08:00", comments="Source field: activity.small_pic")
    private String smallPic;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.376829+08:00", comments="Source field: activity.organizer_id")
    private Integer organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3778267+08:00", comments="Source field: activity.category")
    private Integer category;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3778267+08:00", comments="Source field: activity.pos_lat")
    private Double posLat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3778267+08:00", comments="Source field: activity.pos_lng")
    private Double posLng;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3778267+08:00", comments="Source field: activity.pos_detail")
    private String posDetail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3788261+08:00", comments="Source field: activity.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3788261+08:00", comments="Source field: activity.update_time")
    private Date updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3788261+08:00", comments="Source field: activity.position_code")
    private Integer positionCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.3788261+08:00", comments="Source field: activity.position_detail")
    private String positionDetail;
}