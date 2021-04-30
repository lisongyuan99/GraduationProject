package cn.lsy99.api.activity.shop;

import cn.lsy99.api.activity.generator.ShopStatus;
import cn.lsy99.api.activity.generator.UserRole;
import cn.lsy99.api.activity.generator.table.Seller;
import cn.lsy99.api.activity.generator.table.Shop;
import cn.lsy99.api.activity.shop.dto.ShopModifyEntity;
import cn.lsy99.api.activity.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    @Transactional
    // 新建商店
    public int newShop(int id, ShopModifyEntity shopModifyEntity) {
        Shop shop = Shop.builder()
                .name(shopModifyEntity.getName())
                .description(shopModifyEntity.getDescription())
                .licnese(shopModifyEntity.getLicense())
                .avatar(shopModifyEntity.getAvatar())
                .pictures(ArrayUtil.StringArrayToString(shopModifyEntity.getPicture()))
                .regionCode(shopModifyEntity.getRegionCode())
                .address(shopModifyEntity.getAddress())
                .lat(shopModifyEntity.getLat())
                .lng(shopModifyEntity.getLng())
                .status(ShopStatus.NOT_VERIFY.ordinal())
                .build();
        shopRepository.changeBossStatus(id, UserRole.BOSS);
        int shopId = shopRepository.newShop(shop);
        shopRepository.initBalance(shopId);
        shopRepository.initVip(shopId);
        return shopRepository.sellerUpdateShopId(id, shopId);
//        Optional<Shop> oldShop = shopRepository.getShopByBossId(id);
//        if (oldShop.isPresent()) {
//            shop.setId(oldShop.get().getId());
//            shopRepository.updateShop(shop);
//            return oldShop.get().getId();
//        } else {
//            int shopId = shopRepository.newShop(shop);
//            return shopRepository.sellerUpdateShopId(id, shopId);
//        }
    }

    public ShopModifyEntity getShopInfo(int bossId) {
        Optional<Shop> shop = shopRepository.getShopByBossId(bossId);
        return shop.map(value -> ShopModifyEntity.builder()
                .id(value.getId())
                .name(value.getName())
                .description(value.getDescription())
                .avatar(value.getAvatar())
                .license(value.getLicnese())
                .picture(ArrayUtil.StringToStringArray(value.getPictures()))
                .regionCode(value.getRegionCode())
                .address(value.getAddress())
                .lat(value.getLat())
                .lng(value.getLng())
                .build()).orElse(null);
    }

    public int modify(int bossId, ShopModifyEntity shopModifyEntity) {
        Optional<Shop> shopOptional = shopRepository.getShopByBossId(bossId);
        if (shopOptional.isPresent()) {
            Shop shop = Shop.builder().id(shopOptional.get().getId())
                    .name(shopModifyEntity.getName())
                    .description(shopModifyEntity.getDescription())
                    .licnese(shopModifyEntity.getLicense())
                    .avatar(shopModifyEntity.getAvatar())
                    .pictures(ArrayUtil.StringArrayToString(shopModifyEntity.getPicture()))
                    .regionCode(shopModifyEntity.getRegionCode())
                    .address(shopModifyEntity.getAddress())
                    .lat(shopModifyEntity.getLat())
                    .lng(shopModifyEntity.getLng())
                    .build();
            return shopRepository.updateShop(shop);
        }
        return 0;
    }
}
