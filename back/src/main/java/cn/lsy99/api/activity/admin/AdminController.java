package cn.lsy99.api.activity.admin;

import cn.lsy99.api.activity.admin.dto.AdminLoginEntity;
import cn.lsy99.api.activity.admin.dto.ShopId;
import cn.lsy99.api.activity.admin.dto.ShopVerifyInfo;
import cn.lsy99.api.activity.aop.annotation.AdminTokenCheck;
import cn.lsy99.api.activity.generator.table.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("test")
    public String test() {
        return "success";
    }

    @PostMapping("login")
    public String login(@RequestBody AdminLoginEntity adminLoginEntity) {
        log.info(adminLoginEntity.toString());
        return adminService.login(adminLoginEntity.getName(), adminLoginEntity.getPassword());
    }

    @AdminTokenCheck
    @GetMapping("getShopsToVerify")
    public List<ShopVerifyInfo> getAllShopToVerify() {
        return adminService.getShopsToVerify();
    }

    @AdminTokenCheck
    @PostMapping("passShop")
    public int passShop(@RequestBody ShopId id) {
        return adminService.passShop(id.getShopId());
    }

    @AdminTokenCheck
    @PostMapping("denyShop")
    public int denyShop(@RequestBody ShopId id) {
        return adminService.denyShop(id.getShopId());
    }
}
