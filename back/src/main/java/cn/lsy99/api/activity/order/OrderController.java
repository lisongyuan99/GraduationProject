package cn.lsy99.api.activity.order;

import cn.lsy99.api.activity.aop.annotation.BossTokenCheck;
import cn.lsy99.api.activity.aop.annotation.TokenCheck;
import cn.lsy99.api.activity.order.dto.OrderForShow;
import cn.lsy99.api.activity.shop.dto.ShopModifyEntity;
import cn.lsy99.api.activity.util.JwtInfo;
import cn.lsy99.api.activity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {
    @Value("${http.token.header}")
    private String tokenHeader;
    @Autowired
    private OrderService orderService;

    @BossTokenCheck
    @GetMapping("getAll")
    public List<OrderForShow> getAllOrder(@RequestHeader Map<String, String> headers){
        String token = headers.get(tokenHeader);
        JwtInfo jwtInfo = JwtUtil.getInfoFromToken(token);
        return orderService.getByBossId(jwtInfo.getId());
    }

    @TokenCheck
    @PostMapping("getByActivity")
    public List<OrderForShow> getAllOrder(@RequestBody int id){
        return orderService.getByActivity(id);
    }

    @TokenCheck
    @PostMapping("getById")
    public OrderForShow getById(@RequestBody int id){
        return orderService.getByOrderId(id);
    }
}
