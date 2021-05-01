package cn.lsy99.api.activity.user;

import cn.lsy99.api.activity.exception.exception.NoShopException;
import cn.lsy99.api.activity.generator.UserRole;
import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.user.dto.HomepageInfo;
import cn.lsy99.api.activity.user.dto.UserInfo;
import cn.lsy99.api.activity.user.dto.WorkerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // 绑定电话
    public int bindPhone(int id, String phone) {
        return userRepository.bindPhone(id, phone);
    }

    // 修改信息
    public int modifyInfo(int id, String name, String avatar) {
        return userRepository.modifyInfo(id, name, avatar);
    }

    //  商店添加用户
    public int workerAdd(int workerId, int shopId) {
        Optional<Seller> result = userRepository.getById(workerId);
        if (result.isPresent() && result.get().getType() == UserRole.EMPTY.ordinal()) {
            return userRepository.workerAdd(workerId, shopId);
        } else {
            return 0;
        }
    }

    // 获取员工
    public List<WorkerInfo> getWorker (int bossId){
        Optional<Seller> seller = userRepository.getById(bossId);
        List<WorkerInfo> result = new ArrayList<>();
        if (seller.isPresent() && seller.get().getShopId() != null) {
            List<Seller> sellerList = userRepository.getWorker(seller.get().getShopId());
            for (Seller s : sellerList) {
                result.add(WorkerInfo.builder()
                        .id(s.getId())
                        .name(s.getNickname())
                        .avatar(s.getAvatar())
                        .phone(s.getPhone())
                        .build());
            }
        }
        return result;
    }

    // 获取等待认证员工
    public List<WorkerInfo> getWorkerToVerify (int bossId){
        Optional<Seller> seller = userRepository.getById(bossId);
        List<WorkerInfo> result = new ArrayList<>();
        if (seller.isPresent() && seller.get().getShopId() != null) {
            List<Seller> sellerList = userRepository.getWorkerToVerify(seller.get().getShopId());
            for (Seller s : sellerList) {
                result.add(WorkerInfo.builder()
                        .id(s.getId())
                        .name(s.getNickname())
                        .avatar(s.getAvatar())
                        .phone(s.getPhone()).build());
            }
        }
        return result;
    }

    public boolean removeWorker(int bossId, int workerId){
        Optional<Seller> boss = userRepository.getById(bossId);
        Optional<Seller> worker = userRepository.getById(workerId);
        if (boss.isPresent() && worker.isPresent()) {
            if (boss.get().getShopId().equals(worker.get().getShopId())) {
                if(boss.get().getType() == UserRole.BOSS.ordinal()){
                    userRepository.removeWorker(workerId);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean acceptWorker(int bossId, int workerId){
        Optional<Seller> boss = userRepository.getById(bossId);
        Optional<Seller> worker = userRepository.getById(workerId);
        if (boss.isPresent() && worker.isPresent()) {
            if (boss.get().getShopId().equals(worker.get().getShopId())) {
                if(boss.get().getType() == UserRole.BOSS.ordinal()){
                    userRepository.acceptWorker(workerId);
                    return true;
                }
            }
        }
        return false;
    }

    public UserInfo getUserInfo(int id) {
        Optional<Seller> seller = userRepository.getById(id);
        return seller.map(value -> UserInfo.builder()
                .avatar(value.getAvatar())
                .phone(value.getPhone())
                .name(value.getNickname())
                .build()).orElse(null);
    }

    public HomepageInfo getHomepageInfo(int id){
        Optional<Seller> seller = userRepository.getById(id);
        if (seller.isEmpty()) {
            throw new NoShopException();
        }
        Date expireTime = userRepository.getExpireTime(seller.get().getShopId());
        return HomepageInfo.builder()
                .name(seller.get().getNickname())
                .expireDate(expireTime)
                .expire(new Date().compareTo(expireTime) > 0)
                .avatar(seller.get().getAvatar())
                .build();
    }
}