package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.generator.table.Activity;
import cn.lsy99.api.activity.generator.table.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping("add")
    public void add(@RequestHeader("Token") String jwtToken, @RequestBody Activity activity) {

    }

    @GetMapping("allCategory")
    public List<Category> getAllCategory() {
        return activityService.getAllCategoy();
    }
}
