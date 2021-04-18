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
public class Shop {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8388444+08:00", comments="Source field: shop.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8388444+08:00", comments="Source field: shop.status")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8388444+08:00", comments="Source field: shop.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8388444+08:00", comments="Source field: shop.description")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8388444+08:00", comments="Source field: shop.avatar")
    private String avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8388444+08:00", comments="Source field: shop.position_code")
    private Integer positionCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source field: shop.address")
    private String address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source field: shop.lat")
    private Double lat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source field: shop.pos")
    private Double pos;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8398416+08:00", comments="Source field: shop.pictures")
    private String pictures;
}