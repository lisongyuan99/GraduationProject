package cn.lsy99.api.activity.admin;

import cn.lsy99.api.activity.admin.dto.ShopVerifyInfo;
import cn.lsy99.api.activity.exception.exception.WrongPasswordException;
import cn.lsy99.api.activity.generator.UserRole;
import cn.lsy99.api.activity.generator.table.Admin;
import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.generator.table.Shop;
import cn.lsy99.api.activity.util.JwtUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public String login(String name, String password) {
        Optional<Admin> optional = adminRepository.getAdmin(name);
        if (optional.isPresent()) {
            String hashed = optional.get().getPassword();
            if (BCrypt.checkpw(password, hashed)) {
                return JwtUtil.generateToken(0, UserRole.ADMIN.ordinal());
            }
        }
        throw new WrongPasswordException();
    }

    public List<ShopVerifyInfo> getShopsToVerify() {
        List<Shop> shops = adminRepository.getAllShopToVerify();
        List<ShopVerifyInfo> result = new ArrayList<>();
        for (Shop shop : shops) {
            Optional<Seller> seller = adminRepository.getSellerByShopId(shop.getId());
            if (seller.isPresent()) {
                ShopVerifyInfo shopVerifyInfo = ShopVerifyInfo.builder()
                        .boss(seller.get())
                        .shop(shop)
                        .build();
                result.add(shopVerifyInfo);
            }
        }
        return result;
    }

    public int passShop(int shopId){
        return adminRepository.passShop(shopId);
    }

    public int denyShop(int shopId){
        return adminRepository.denyShop(shopId);
    }
}
