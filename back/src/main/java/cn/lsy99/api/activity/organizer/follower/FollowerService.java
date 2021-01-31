package cn.lsy99.api.activity.organizer.follower;

import cn.lsy99.api.activity.organizer.generator.table.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;

    public List<Customer> getAllFollower(int organizerId) {
        return followerRepository.getAllFollower(organizerId);
    }
}
