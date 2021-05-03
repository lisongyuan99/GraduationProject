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
public class ShopVip {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5739406+08:00", comments="Source field: shop_vip.shop_id")
    private Integer shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5739406+08:00", comments="Source field: shop_vip.expire_time")
    private Date expireTime;
}