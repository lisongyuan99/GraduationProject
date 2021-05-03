package cn.lsy99.api.activity.order.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ActivityInfo {
    private String name;
    private String picture;
    private Date time;
    private int regionCode;
    private String address;
}
