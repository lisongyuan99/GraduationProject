package cn.lsy99.api.activity.user.dto;

import lombok.Data;

@Data
public class UserProfileInput {
    private String name;
    private String motto;
    private String avatar;
    private String email;
}
