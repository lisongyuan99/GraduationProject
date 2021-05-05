package cn.lsy99.api.activity.admin;

import cn.lsy99.api.activity.admin.dto.ActivityVerifyInfo;
import cn.lsy99.api.activity.admin.dto.AdminLoginEntity;
import cn.lsy99.api.activity.admin.dto.Id;
import cn.lsy99.api.activity.admin.dto.ShopVerifyInfo;
import cn.lsy99.api.activity.aop.annotation.AdminTokenCheck;
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
    @GetMapping("getShopToVerify")
    public List<ShopVerifyInfo> getAllShopToVerify() {
        return adminService.getShopToVerify();
    }

    @AdminTokenCheck
    @PostMapping("passShop/{id}")
    public int passShop(@PathVariable("id") Integer id) {
        return adminService.passShop(id);
    }

    @AdminTokenCheck
    @PostMapping("denyShop/{id}")
    public int denyShop(@PathVariable("id") Integer id) {
        return adminService.denyShop(id);
    }

    @AdminTokenCheck
    @GetMapping("getActivityToVerify")
    public List<ActivityVerifyInfo> getAllActivityToVerify() {
        return adminService.getActivities();
    }

    @AdminTokenCheck
    @PostMapping("passActivity/{id}")
    public int passActivity(@PathVariable("id") Integer id) {
        return adminService.passActivity(id);
    }

    @AdminTokenCheck
    @PostMapping("denyActivity/{id}")
    public int denyActivity(@PathVariable("id") Integer id) {
        return adminService.denyActivity(id);
    }
}
