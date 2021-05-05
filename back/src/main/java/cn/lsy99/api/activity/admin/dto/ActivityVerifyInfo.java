package cn.lsy99.api.activity.admin.dto;

import cn.lsy99.api.activity.generator.table.Activity;
import cn.lsy99.api.activity.generator.table.Shop;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivityVerifyInfo {
    private Activity activity;
    private Shop shop;
}
