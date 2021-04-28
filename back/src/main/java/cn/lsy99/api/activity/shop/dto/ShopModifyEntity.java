package cn.lsy99.api.activity.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopModifyEntity {
    private int id;
    private String name;
    private String description;
    private String avatar;
    private String license;
    private String[] picture;
    private int regionCode;
    private String address;
    private double lat;
    private double lng;
}
