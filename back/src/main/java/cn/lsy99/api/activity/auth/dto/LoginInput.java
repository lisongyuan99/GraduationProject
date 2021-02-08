package cn.lsy99.api.activity.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginInput {
    private String code;
    private String signature;
    private String iv;
    private String encryptedData;
}
