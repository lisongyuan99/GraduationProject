package cn.lsy99.api.activity.activity;

import cn.lsy99.api.activity.generator.table.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    public List<Category> getAllCategoy() {
        return activityRepository.getAllCategory();
    }
}
