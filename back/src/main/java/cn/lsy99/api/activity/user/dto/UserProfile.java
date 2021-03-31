package cn.lsy99.api.activity.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfile {
    private String name;
    private String motto;
    private String avatar;
    private String phone;
    private String email;
}
