package cn.lsy99.api.activity.organizer.activity.dto;

import cn.lsy99.api.activity.organizer.table.Activity;
import lombok.Data;

@Data
public class ActivityWithToken {
    private String token;
    private Activity activity;
}
