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
public class ShopBill {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1327323+08:00", comments="Source field: shop_bill.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1327323+08:00", comments="Source field: shop_bill.shop_id")
    private Integer shopId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1327323+08:00", comments="Source field: shop_bill.bill_time")
    private Date billTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.13373+08:00", comments="Source field: shop_bill.amount")
    private Double amount;
}