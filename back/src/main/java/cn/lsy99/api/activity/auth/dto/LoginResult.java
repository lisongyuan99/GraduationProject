package cn.lsy99.api.activity.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResult {
    private int id;
    private String token;
    private String nickname;
    private String motto;
    private String avatarUrl;
}
