package cn.lsy99.api.activity.user;

import cn.lsy99.api.activity.generator.UserRole;
import cn.lsy99.api.activity.generator.mapper.SellerMapper;
import cn.lsy99.api.activity.generator.table.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static cn.lsy99.api.activity.generator.mapper.SellerDynamicSqlSupport.seller;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public class UserRepository {

    @Autowired
    private SellerMapper sellerMapper;

    public Optional<Seller> getById(int id) {
        return sellerMapper.selectByPrimaryKey(id);
    }
    public int bindPhone(int id, String phone){
        Seller record = Seller.builder().id(id).phone(phone).build();
        return sellerMapper.updateByPrimaryKeySelective(record);
    }

    public int modifyInfo(int id,String name, String avatar){
        Seller record = Seller.builder().id(id).nickname(name).avatar(avatar).build();
        return sellerMapper.updateByPrimaryKeySelective(record);
    }

    public int workerAdd(int workerId, int shopId) {
        Seller record = Seller.builder().id(workerId).shopId(shopId).type(UserRole.WORKER_TO_JOIN.ordinal()).build();
        return sellerMapper.updateByPrimaryKeySelective(record);
    }

    public List<Seller> getWorker(int shopId) {
        return sellerMapper.select(c ->
                c.where(seller.shopId, isEqualTo(shopId),
                        and(seller.type, isEqualTo(UserRole.WORKER.ordinal()))));
    }

    public List<Seller> getWorkerToVerify(int shopId) {
        return sellerMapper.select(c ->
                c.where(seller.shopId, isEqualTo(shopId),
                        and(seller.type, isEqualTo(UserRole.WORKER_TO_JOIN.ordinal()))));
    }

    // 移除员工或拒绝员工
    public void removeWorker(int workerId){
        Seller seller = Seller.builder().id(workerId).shopId(null).type(UserRole.EMPTY.ordinal()).build();
        sellerMapper.updateByPrimaryKeySelective(seller);
    }

    // 接受员工
    public void acceptWorker(int workerId){
        Seller seller = Seller.builder().id(workerId).type(UserRole.WORKER.ordinal()).build();
        sellerMapper.updateByPrimaryKeySelective(seller);
    }
}
