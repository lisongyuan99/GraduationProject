package cn.lsy99.api.activity.organizer.auth.dto;

import cn.lsy99.api.activity.organizer.generator.table.Organizer;
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
