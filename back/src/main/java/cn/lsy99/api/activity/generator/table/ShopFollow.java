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
public class ShopFollow {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.306029+08:00", comments="Source field: shop_follow.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.306029+08:00", comments="Source field: shop_follow.shop_id")
    private Integer shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.306029+08:00", comments="Source field: shop_follow.customer_id")
    private Integer customerId;
}