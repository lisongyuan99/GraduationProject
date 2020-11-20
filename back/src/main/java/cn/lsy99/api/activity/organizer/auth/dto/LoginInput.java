package cn.lsy99.api.activity.organizer.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginInput {
    private String username;
    private String password;
}
