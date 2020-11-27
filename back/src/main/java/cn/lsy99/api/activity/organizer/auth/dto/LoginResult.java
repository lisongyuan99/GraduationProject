package cn.lsy99.api.activity.organizer.auth.dto;

import cn.lsy99.api.activity.organizer.table.Organizer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResult {
    private Organizer organizer;
    private String token;
}
