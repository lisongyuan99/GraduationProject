package cn.lsy99.api.activity.shop;

import cn.lsy99.api.activity.aop.annotation.BossTokenCheck;
import cn.lsy99.api.activity.aop.annotation.TokenCheck;
import cn.lsy99.api.activity.shop.dto.ShopModifyEntity;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("shop")
public class ShopController {

    @Value("${http.token.header}")
    private String tokenHeader;

    @Autowired
    private ShopService shopService;

    @TokenCheck
    @PostMapping("new")
    // 新建商铺
    public int newShop(@RequestHeader Map<String, String> headers, @RequestBody ShopModifyEntity input){
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        // log.info(input.toString());
        return shopService.newShop(jwtInfo.getId(), input);
    }

    @BossTokenCheck
    @GetMapping("getShopModifyInfo")
    public ShopModifyEntity getShopModifyInfo(@RequestHeader Map<String, String> headers) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return shopService.getShopInfo(jwtInfo.getId());
    }

    @BossTokenCheck
    @PostMapping("modify")
    public int modify(@RequestHeader Map<String, String> headers, @RequestBody ShopModifyEntity input) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return shopService.modify(jwtInfo.getId(), input);
    }
}
