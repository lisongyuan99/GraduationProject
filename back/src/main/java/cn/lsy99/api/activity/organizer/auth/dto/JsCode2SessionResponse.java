package cn.lsy99.api.activity.organizer.auth.dto;

import lombok.Data;

@Data
public class JsCode2SessionResponse {
    private String session_key;
    private String openid;
}


