package cn.lsy99.api.activity.auth;

import cn.lsy99.api.activity.auth.dto.JsCode2SessionResponse;
import cn.lsy99.api.activity.auth.dto.LoginResult;
import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.generator.table.Shop;
import cn.lsy99.api.activity.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

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
        Optional<Seller> sellerOptional = authRepository.getSeller(openid);
        Seller seller;
        if(sellerOptional.isEmpty()){
            seller = authRepository.newSeller(openid);
        } else {
            seller = sellerOptional.get();
        }
        String token = JwtUtil.generateToken(seller.getId(), seller.getType());
        log.info(seller.toString());

        LoginResult result = LoginResult.builder()
                .id(seller.getId())
                .token(token)
                .name(seller.getNickname())
                .avatar(seller.getAvatar())
                .phone(seller.getPhone())
                .type(seller.getType())
                .build();
        if (seller.getShopId() != null) {
            Optional<Shop> shop = authRepository.getShop(seller.getShopId());
            shop.ifPresent(result::setShop);
        }
        return result;
    }

}
