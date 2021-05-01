package cn.lsy99.api.activity.balance;

import cn.lsy99.api.activity.aop.annotation.BossTokenCheck;
import cn.lsy99.api.activity.balance.dto.BalanceInfo;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @BossTokenCheck
    @PostMapping("topUp")
    public boolean topUp(@RequestHeader Map<String, String> headers, @RequestBody double price) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return balanceService.topUp(jwtInfo.getId(), price);
    }

    @BossTokenCheck
    @PostMapping("withdraw")
    public boolean withdraw(@RequestHeader Map<String, String> headers, @RequestBody double price) {
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return balanceService.withdraw(jwtInfo.getId(), price);
    }
}
