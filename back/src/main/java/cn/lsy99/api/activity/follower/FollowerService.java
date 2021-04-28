package cn.lsy99.api.activity.follower;

import cn.lsy99.api.activity.follower.dto.CustomerInfo;
import cn.lsy99.api.activity.generator.table.Customer;
import cn.lsy99.api.activity.generator.table.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;

    public List<CustomerInfo> getAllFollower(int bossId) {
        List<CustomerInfo> result = new ArrayList<>();
        Optional<Seller> seller = followerRepository.getSeller(bossId);
        if (seller.isPresent()) {
            List<Customer> customers = followerRepository.getAllFollower(seller.get().getShopId());
            for (Customer customer : customers) {
                result.add(CustomerInfo.builder()
                        .id(customer.getId())
                        .avatar(customer.getAvatar())
                        .name(customer.getNickname())
                        .motto(customer.getMotto())
                        .build());
            }
        }
        return result;
    }

    public boolean removeFollower(int bossId, int followerId) {
        Optional<Seller> seller = followerRepository.getSeller(bossId);
        return seller.filter(value -> followerRepository.removeFollower(value.getShopId(), followerId)).isPresent();
    }
}
