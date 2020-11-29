package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.auth.dto.JsCode2SessionResponse;
import cn.lsy99.api.activity.organizer.auth.dto.LoginResult;
import cn.lsy99.api.activity.organizer.table.Organizer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@Service
@Slf4j
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Qualifier("findUser")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;


    public LoginResult login(String code) {
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
//            log.info(jsCode2SessionResponse.getOpenid());
//            log.info(jsCode2SessionResponse.getSession_key());
        } catch (Exception e) {
            log.info("error");
            return null;
        }
        String openid = jsCode2SessionResponse.getOpenid();
        // String sessionKey = jsCode2SessionResponse.getSession_key(); // 加redis?

        // 找数据库里的id，找不到添加
        Organizer searchResult = authRepository.selectOrganizerByOpenId(openid);
        if (searchResult == null) {
            searchResult = authRepository.insertOrganizerByOpenId(openid);
        }
        // log.info(searchResult.toString());

        UserForAuth userDetails = (UserForAuth) userDetailsService.loadUserByUsername(openid);
        final String token = jwtUtil.generateToken(userDetails);
        return LoginResult.builder().token(token).organizer(searchResult).build();


//        String result = JWTUtil.decrypt(encryptedData, jsCode2SessionResponse.getSession_key(), iv, "UTF-8");
//        log.info(result);

//        // 认证用户，认证失败抛出异常，由JwtAuthError的commence类返回401
//        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
//        final Authentication authentication = authenticationManager.authenticate(upToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // 如果认证通过，返回jwt
//        final UserForAuth userDetails = (UserForAuth) userDetailsService.loadUserByUsername(username);
//        final String token = jwtUtil.generateToken(userDetails);
//        // log.info(token);
//
//        Organizer organizer = authRepository.getOrganizerWithUsername(username).get(0);
//        organizer.setPassword(null);
//        return LoginOutput.builder().token(token).organizer(organizer).build();
    }
}
