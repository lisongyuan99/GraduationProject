package cn.lsy99.api.activity.organizer.table;

import java.util.Date;
import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Activity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.detail")
    private String detail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.subtitle")
    private String subtitle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.begin_time")
    private Date beginTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.end_time")
    private Date endTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.time_type")
    private Integer timeType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.big_pic")
    private String bigPic;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.small_pic")
    private String smallPic;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.organizer_id")
    private Integer organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.category")
    private Integer category;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.pos_lat")
    private Integer posLat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.pos_lng")
    private Integer posLng;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.pos_detail")
    private Integer posDetail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.update_time")
    private Date updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.6417849+08:00", comments="Source field: activity.users_id")
    private Object usersId;
}