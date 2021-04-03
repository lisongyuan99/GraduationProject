package cn.lsy99.api.activity.auth;

import cn.lsy99.api.activity.auth.dto.*;
import cn.lsy99.api.activity.generator.table.ActivityStatistics;
import cn.lsy99.api.activity.generator.table.Organizer;
import cn.lsy99.api.activity.util.ArrayUtil;
import cn.lsy99.api.activity.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@Slf4j
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    private final static int RETURN_DAYS = 7;

    @Transactional
    public LoginResult login(String loginCode) {
        // 请求得到 openid 和 session key
        RestTemplate restTemplate = new RestTemplate();
        // 要拼url 用map是在body里面的
        URI targetUrl = UriComponentsBuilder.fromUriString("https://api.weixin.qq.com/sns/jscode2session")
                .queryParam("appid", appid)
                .queryParam("secret", secret)
                .queryParam("js_code", loginCode)
                .queryParam("grant_type", "authorization_code")
                .build()
                .encode()
                .toUri();
        String response = restTemplate.getForObject(targetUrl, String.class);
        log.info(response);
        // 解析返回值
        ObjectMapper objectMapper = new ObjectMapper();
        JsCode2SessionResponse jsCode2SessionResponse;
        try {
            jsCode2SessionResponse = objectMapper.readValue(response, JsCode2SessionResponse.class);
        } catch (Exception e) {
            log.info("WechatLoginError");
            log.info(response);
            return null;
        }
        String openid = jsCode2SessionResponse.getOpenid();
        // String sessionKey = jsCode2SessionResponse.getSession_key(); // 加redis?

        // 找数据库里的id，找不到添加
        Organizer organizer = authRepository.selectOrganizerByOpenId(openid);
        if (organizer == null) {
            organizer = authRepository.insertOrganizerByOpenId(openid);
        }

        // 生成Token 返回基本信息
        final String token = JwtUtil.generateToken(organizer.getId(), organizer.getType());
        int id = organizer.getId();
        return LoginResult.builder()
                .id(id)
                .token(token)
                .nickName(organizer.getNickname())
                .avatarUrl(organizer.getAvatar())
                .motto(organizer.getMotto())
                .phone(organizer.getPhoneNum())
                .build();
    }

    public boolean setWechatUserInfo(int id, WechatUserInfo wechatUserInfo) {
        return authRepository.setWechatUserInfo(id, wechatUserInfo);
    }

    public DataOnMainPage getCounts(int organizerId) {
        long activityCount = authRepository.getActivityCount(organizerId);
        long followerCount = authRepository.getFollowerCount(organizerId);
        double balance = 0;
        List<ActivityStatistics> data = authRepository.getVisits(organizerId);
        int[] count = new int[RETURN_DAYS];
        for (ActivityStatistics activityStatistics : data) {
            String[] visit = ArrayUtil.StringToStringArray(activityStatistics.getVisits());
            int visitLastIndex = visit.length - 1;
            for (int i = 0; i < RETURN_DAYS; i++) {
                if (visitLastIndex - i < 0) {
                    break;
                } else {
                    count[RETURN_DAYS - i - 1] += Integer.parseInt(visit[visitLastIndex - i]);
                }
            }
        }
        return DataOnMainPage.builder()
                .activityCount(activityCount)
                .followerCount(followerCount)
                .balance(balance)
                .data(count)
                .build();
    }
}
