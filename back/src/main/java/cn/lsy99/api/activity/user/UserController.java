package cn.lsy99.api.activity.user;

import cn.lsy99.api.activity.aop.annotation.OrgTokenCheck;
import cn.lsy99.api.activity.user.dto.PhoneNumCode;
import cn.lsy99.api.activity.user.dto.UserProfileInput;
import cn.lsy99.api.activity.user.dto.UserProfile;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Value("${http.token.header}")
    private String tokenHeader;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserService userService;


    private static final String PREFIX = "phone.verify:";
    private final SecureRandom secureRandom = new SecureRandom();
    private final Pattern pattern = Pattern.compile("^1[3-9]\\d{9}$");

    // 发送验证码
    @OrgTokenCheck
    @PostMapping("getPhoneCode")
    public boolean getPhoneCode(@RequestBody String phoneNum) {
        if (phoneNum != null && pattern.matcher(phoneNum).matches()) {
            String key = PREFIX + phoneNum;
            int code = secureRandom.nextInt(1000000);
            // TODO 发送验证码
            stringRedisTemplate.opsForValue().set(key, String.valueOf(code), 30, TimeUnit.MINUTES);
            return true;
        } else {
            // 异常处理
            return false;
        }

    }

    // 确认手机号
    @OrgTokenCheck
    @PostMapping("verifyPhoneCode")
    public boolean getPhoneCode(@RequestHeader Map<String, String> headers, @RequestBody PhoneNumCode input) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int id = jwtInfo.getId();
        if (input.getPhoneNum() != null && input.getCode() != null && pattern.matcher(input.getPhoneNum()).matches()) {
            String key = PREFIX + input.getPhoneNum();
            String value = stringRedisTemplate.opsForValue().get(key);
            if (value == null) {
                // 手机号不存在
                return false;
            } else if (value.equals(input.getCode())) {
                // 绑定手机号
                return userService.bindPhone(id, input.getPhoneNum());
            } else {
                // 验证码不正确
                return false;
            }
        } else {
            // 异常处理 输入错误
            return false;
        }
    }

    // 获取用户信息
    @OrgTokenCheck
    @GetMapping("getProfile")
    public UserProfile getUserProfile(@RequestHeader Map<String, String> headers) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int id = jwtInfo.getId();
        return userService.getUserProfile(id);
    }

    // 更改用户信息
    @OrgTokenCheck
    @PostMapping("updateProfile")
    public boolean updateUserProfile(@RequestHeader Map<String, String> headers,
                                     @RequestBody UserProfileInput input) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int id = jwtInfo.getId();
        log.info(input.toString());
        if(input.getName() == null || input.getName().equals("")){
            return false;
        } else {
            return userService.updateUserProfile(id, input);
        }

    }
}
