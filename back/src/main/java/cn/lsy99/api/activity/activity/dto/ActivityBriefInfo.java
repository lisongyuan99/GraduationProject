package cn.lsy99.api.activity.activity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ActivityBriefInfo {
    private int id;
    private String pic;
    private String name;
    private int regionCode;
    private Date date;
}