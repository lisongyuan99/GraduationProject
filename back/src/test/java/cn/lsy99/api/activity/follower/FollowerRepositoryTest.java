package cn.lsy99.api.activity.follower;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FollowerRepositoryTest {
    @Autowired
    FollowerRepository followerRepository;

    @Test
    public void test() {
        System.out.println(followerRepository.removeFollower(1, 2));
    }


}