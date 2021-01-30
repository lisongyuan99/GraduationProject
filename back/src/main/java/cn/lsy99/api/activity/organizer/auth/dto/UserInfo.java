package cn.lsy99.api.activity.organizer.auth.dto;

import lombok.Data;

@Data
public class UserInfo {
    String openId;
    String nickName;
    int gender;
    String language;
    String city;
    String province;
    String country;
    String avatarUrl;
    Watermark watermark;
}
