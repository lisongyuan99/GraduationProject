package cn.lsy99.api.activity.util;

import cn.lsy99.api.activity.generator.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtInfo {
    private int id;
    private UserRole role;
}
