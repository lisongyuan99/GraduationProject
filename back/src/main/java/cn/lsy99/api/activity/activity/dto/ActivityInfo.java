package cn.lsy99.api.activity.activity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ActivityInfo {
    private int id;
    private String[] pics;
    private String name;
    private String description;
    private int regionCode;
    private String address;
    private String detail;
    private Date time;
    private long user;
}
