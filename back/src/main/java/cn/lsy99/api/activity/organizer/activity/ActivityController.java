package cn.lsy99.api.activity.organizer.activity;

import cn.lsy99.api.activity.organizer.generator.table.Activity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("activity")
public class ActivityController {
    @PostMapping("add")
    public void add(@RequestHeader("Authorization") String jwtToken, @RequestBody Activity activity) {

    }
}
