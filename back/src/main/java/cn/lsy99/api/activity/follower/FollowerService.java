package cn.lsy99.api.activity.follower;

import cn.lsy99.api.activity.follower.dto.CustomerInfo;
import cn.lsy99.api.activity.generator.table.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;

    public List<CustomerInfo> getAllFollower(int organizerId) {
        List<Customer> customers = followerRepository.getAllFollower(organizerId);
        List<CustomerInfo> result = new ArrayList<>();
        for (Customer customer : customers) {
            result.add(CustomerInfo.builder()
                    .id(customer.getId())
                    .avatar(customer.getAvatar())
                    .name(customer.getNickname())
                    .motto(customer.getMotto())
                    .build());
        }
        return result;
    }

    public boolean removeFollower(int organizerId, int followerId) {
        return followerRepository.removeFollower(organizerId, followerId);
    }
}
