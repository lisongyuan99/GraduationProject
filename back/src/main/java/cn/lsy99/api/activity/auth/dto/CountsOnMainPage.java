package cn.lsy99.api.activity.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountsOnMainPage {
    private long activityCount;
    private long followerCount;
    private long orderCount;
}
