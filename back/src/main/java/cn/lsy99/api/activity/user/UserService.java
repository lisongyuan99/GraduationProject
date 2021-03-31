package cn.lsy99.api.activity.user;

import cn.lsy99.api.activity.generator.table.Organizer;
import cn.lsy99.api.activity.user.dto.UserProfile;
import cn.lsy99.api.activity.user.dto.UserProfileInput;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // 绑定电话
    public boolean bindPhone(int id, String phone) {
        Organizer organizer = Organizer.builder()
                .id(id)
                .phoneNum(phone)
                .build();
        int result = userRepository.bindPhone(organizer);
        log.info(String.valueOf(result));
        return result == 1;
    }

    // 获取用户信息
    public UserProfile getUserProfile(int id) {
        Optional<Organizer> optionalOrganizer = userRepository.getUserProfile(id);
        if (optionalOrganizer.isPresent()) {
            Organizer organizer = optionalOrganizer.get();
            return UserProfile.builder()
                    .name(organizer.getNickname())
                    .motto(organizer.getMotto())
                    .avatar(organizer.getAvatar())
                    .phone(organizer.getPhoneNum())
                    .email(organizer.getEmail())
                    .build();
        } else {
            return null;
        }
    }

    // 更新用户信息
    public boolean updateUserProfile(int id, UserProfileInput input) {
        Organizer organizer = Organizer.builder()
                .id(id)
                .nickname(input.getName())
                .motto(input.getMotto())
                .email(input.getEmail())
                .avatar(input.getAvatar())
                .build();
        return userRepository.updateUserProfile(organizer) == 1;
    }
}
