package cn.lsy99.api.activity.balance;

import cn.lsy99.api.activity.aop.annotation.BossTokenCheck;
import cn.lsy99.api.activity.balance.dto.BalanceInfo;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("balance")
public class BalanceController {
    @Autowired
    private BalanceService balanceService;
    @Value("${http.token.header}")
    private String tokenHeader;

    @BossTokenCheck
    @GetMapping("getInfo")
    public BalanceInfo getInfo(@RequestHeader Map<String, String> headers) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return balanceService.getBalanceInfo(jwtInfo.getId());
    }
}
