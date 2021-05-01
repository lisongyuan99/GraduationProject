package cn.lsy99.api.activity.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {
    private String name;
    private String avatar;
    private String phone;
}
