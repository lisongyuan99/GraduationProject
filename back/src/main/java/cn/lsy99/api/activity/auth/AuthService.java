package cn.lsy99.api.activity.auth;

import cn.lsy99.api.activity.auth.dto.*;
import cn.lsy99.api.activity.generator.table.Organizer;
import cn.lsy99.api.activity.util.JwtUtil;
import cn.lsy99.api.activity.util.WechatUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    @Transactional
    public LoginResult login(LoginInput input) {
        String code = input.getCode();
        // 请求得到 openid 和 session key
        RestTemplate restTemplate = new RestTemplate();
        // 要拼url 用map是在body里面的
        URI targetUrl = UriComponentsBuilder.fromUriString("https://api.weixin.qq.com/sns/jscode2session")
                .queryParam("appid", appid)
                .queryParam("secret", secret)
                .queryParam("js_code", code)
                .queryParam("grant_type", "authorization_code")
                .build()
                .encode()
                .toUri();
        String response = restTemplate.getForObject(targetUrl, String.class);

        // 解析返回值
        ObjectMapper objectMapper = new ObjectMapper();
        JsCode2SessionResponse jsCode2SessionResponse;
        try {
            jsCode2SessionResponse = objectMapper.readValue(response, JsCode2SessionResponse.class);
        } catch (Exception e) {
            log.info("error");
            return null;
        }
        String openid = jsCode2SessionResponse.getOpenid();
        // String sessionKey = jsCode2SessionResponse.getSession_key(); // 加redis?

        // 找数据库里的id，找不到添加
        Organizer searchResult = authRepository.selectOrganizerByOpenId(openid);
        if (searchResult == null) {
            authRepository.insertOrganizerByOpenId(openid);
        }

        // 从数据库里重新选出来
        Organizer organizer = authRepository.selectOrganizerByOpenId(openid);
        String nickname = organizer.getNickname();
        String avatarUrl = organizer.getAvatar();
        String motto = organizer.getMotto();
        String phone = organizer.getPhoneNum();
        // 如果没有头像和昵称，解密微信的信息，并获取
        if (nickname == null || avatarUrl == null) {
            try {
                String decryptedData = WechatUtil.decrypt(input.getEncryptedData(),
                        jsCode2SessionResponse.getSession_key(), input.getIv());
                UserInfo userInfo = objectMapper.readValue(decryptedData, UserInfo.class);
                if (nickname == null) {
                    nickname = userInfo.getNickName();
                    organizer.setNickname(nickname);
                }
                if (avatarUrl == null) {
                    avatarUrl = userInfo.getAvatarUrl();
                    organizer.setAvatar(avatarUrl);
                }
                //相关信息添加到数据库
                authRepository.updateOrganzier(organizer);
            } catch (Exception e) {
                log.info("error");
            }
        }

        final String token = JwtUtil.generateToken(organizer.getId(), organizer.getType());
        int id = organizer.getId();
        return LoginResult.builder()
                .id(id).token(token).nickname(nickname).avatarUrl(avatarUrl).motto(motto).phone(phone)
                .build();
    }

    public CountsOnMainPage getCounts(int organizerId){
        long activityCount = authRepository.getActivityCount(organizerId);
        long followerCount = authRepository.getFollowerCount(organizerId);
        long orderCount = 0;
        return CountsOnMainPage.builder()
                .activityCount(activityCount).followerCount(followerCount).orderCount(orderCount)
                .build();
    }
}
