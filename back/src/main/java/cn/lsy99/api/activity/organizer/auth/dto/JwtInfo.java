package cn.lsy99.api.activity.organizer.auth.dto;

import cn.lsy99.api.activity.organizer.generator.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtInfo {
    private int id;
    private UserRole role;
}
