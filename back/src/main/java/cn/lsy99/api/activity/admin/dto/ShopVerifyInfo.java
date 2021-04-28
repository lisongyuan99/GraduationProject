package cn.lsy99.api.activity.admin.dto;

import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.generator.table.Shop;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopVerifyInfo {
    private Shop shop;
    private Seller boss;
}
