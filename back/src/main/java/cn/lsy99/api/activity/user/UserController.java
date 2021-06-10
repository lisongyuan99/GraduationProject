package cn.lsy99.api.activity.user;

import cn.lsy99.api.activity.aop.annotation.BossTokenCheck;
import cn.lsy99.api.activity.aop.annotation.SellerTokenCheck;
import cn.lsy99.api.activity.aop.annotation.TokenCheck;
import cn.lsy99.api.activity.user.dto.*;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;
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
    @SellerTokenCheck
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
    @SellerTokenCheck
    @PostMapping("verifyPhoneCode")
    public int getPhoneCode(@RequestHeader Map<String, String> headers, @RequestBody PhoneNumCode input) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int id = jwtInfo.getId();
        if (input.getPhoneNum() != null && input.getCode() != null && pattern.matcher(input.getPhoneNum()).matches()) {
            String key = PREFIX + input.getPhoneNum();
            String value = stringRedisTemplate.opsForValue().get(key);
            if (value == null) {
                // 手机号不存在
                return 0;
            } else if (value.equals(input.getCode())) {
                // 绑定手机号
                stringRedisTemplate.delete(key);
                return userService.bindPhone(id, input.getPhoneNum());
            } else {
                // 验证码不正确
                return 0;
            }
        } else {
            // 异常处理 输入错误
            return 0;
        }
    }

    // 修改信息
    @TokenCheck
    @PostMapping("modifyInfo")
    public int modifyInfo(@RequestHeader Map<String, String> headers, @RequestBody UserInfoInput input) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int id = jwtInfo.getId();
        return userService.modifyInfo(id, input.getName(), input.getAvatar());
    }

    // 获取用户信息
    @SellerTokenCheck
    @GetMapping("getInfo")
    public UserInfo getInfo(@RequestHeader Map<String, String> headers){
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(headers.get(tokenHeader));
        return userService.getUserInfo(jwtInfo.getId());
    }
    // 获取信息, 显示在主页上
    @SellerTokenCheck
    @GetMapping("getHomepageInfo")
    public HomepageInfo getHomepageInfo(@RequestHeader Map<String, String> headers){
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(headers.get(tokenHeader));
        return userService.getHomepageInfo(jwtInfo.getId());
    }

    // 加入店铺
    // @SellerTokenCheck
    @PostMapping("workerAdd")
    public int workerAdd(@RequestHeader Map<String, String> headers, @RequestBody int shopId){
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int id = jwtInfo.getId();
        return userService.workerAdd(id, shopId);
    }

    // 获取员工
    @BossTokenCheck
    @GetMapping("getWorker")
    public List<WorkerInfo> getWorker (@RequestHeader Map<String, String> headers){
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int id = jwtInfo.getId();
        return userService.getWorker(id);
    }

    // 获取等待确认员工
    @BossTokenCheck
    @GetMapping("getWorkerVerify")
    public List<WorkerInfo> getWorkerVerify (@RequestHeader Map<String, String> headers){
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int id = jwtInfo.getId();
        return userService.getWorkerToVerify(id);
    }

    // 通过员工
    @BossTokenCheck
    @PostMapping("passWorker")
    public boolean passWorker(@RequestHeader Map<String, String> headers, @RequestBody int workerId){
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int id = jwtInfo.getId();
        return userService.acceptWorker(id, workerId);
    }

    // 移除员工
    @BossTokenCheck
    @PostMapping("removeWorker")
    public boolean removeWorker(@RequestHeader Map<String, String> headers, @RequestBody int workerId){
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        int id = jwtInfo.getId();
        return userService.removeWorker(id, workerId);
    }
}
