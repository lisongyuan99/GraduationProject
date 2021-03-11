package cn.lsy99.api.activity.auth.dto;

import lombok.Data;

@Data
public class WechatUserInfo {
    private String avatarUrl;
    private String city;
    private String country;
    private String gender;
    private String language;
    private String nickName;
    private String province;
}
