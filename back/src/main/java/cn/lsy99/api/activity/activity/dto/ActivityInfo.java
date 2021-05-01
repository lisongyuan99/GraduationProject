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
    private Date time;
    private String description;
    private String detail;

    private int regionCode;
    private String address;
    private double lat;
    private double lng;

    private long followUserNum;
    private int viewUserNum;
    private long joinUserNum;
    private long up;
    private long down;
    private long rest;

    private boolean free;
    private double price;
    private double ori;

    private int orgId;
    private String orgAvatar;
    private String orgName;
    private String orgMotto;

    private double suggestionAmount;
}
