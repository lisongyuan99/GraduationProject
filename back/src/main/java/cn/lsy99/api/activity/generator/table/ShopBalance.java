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
public class ShopBalance {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5819191+08:00", comments="Source field: shop_balance.shop_id")
    private Integer shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5829269+08:00", comments="Source field: shop_balance.balance")
    private Double balance;
}