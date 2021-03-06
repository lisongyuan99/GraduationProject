package cn.lsy99.api.activity.follower.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerInfo {
    private int id;
    private String avatar;
    private String name;
    private String motto;
}
