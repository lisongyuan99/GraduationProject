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
public class Seller {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.nickname")
    private String nickname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.avatar")
    private String avatar;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.phone")
    private String phone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.wx_open_id")
    private String wxOpenId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.type")
    private Integer type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source field: seller.shop_id")
    private Integer shopId;
}