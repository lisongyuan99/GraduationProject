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
public class Activity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.detail")
    private String detail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.subtitle")
    private String subtitle;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.begin_time")
    private Date beginTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.end_time")
    private Date endTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.time_type")
    private Integer timeType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.organizer_id")
    private Integer organizerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.category")
    private Integer category;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.pos_lat")
    private Double posLat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.pos_lng")
    private Double posLng;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.update_time")
    private Date updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.position_code")
    private Integer positionCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.position_detail")
    private String positionDetail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.prize")
    private Double prize;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.popularity")
    private Double popularity;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.1787339+08:00", comments="Source field: activity.pics")
    private String pics;
}