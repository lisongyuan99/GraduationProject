package cn.lsy99.api.activity.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class HomepageInfo {
    private String avatar;
    private String name;
    private Date expireDate;
    private boolean expire;
//    private int activityNum;
//    private int fanNum;
//    private int orderNum;
//    private double balance;
}
