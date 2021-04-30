package cn.lsy99.api.activity.activity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private int regionCode;
    private String address;
    private double lat;
    private double lng;
}
