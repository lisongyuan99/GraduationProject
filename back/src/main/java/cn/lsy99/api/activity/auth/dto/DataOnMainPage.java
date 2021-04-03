package cn.lsy99.api.activity.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataOnMainPage {
    private long activityCount;
    private long followerCount;
    private double balance;
    private int[] data;
}
