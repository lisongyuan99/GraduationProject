package cn.lsy99.api.activity;

import cn.lsy99.api.activity.generator.mapper.ActivityCountMapper;
import cn.lsy99.api.activity.generator.table.ActivityCount;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@Slf4j
public class DaoTest {
    @Resource
    ActivityCountMapper activityCountMapper;

    @Test
    public void insert() {
        ActivityCount activityCount = ActivityCount.builder()
                .activityId(123)
                .count(10)
                .build();
        activityCountMapper.insertSelective(activityCount);
    }

}
