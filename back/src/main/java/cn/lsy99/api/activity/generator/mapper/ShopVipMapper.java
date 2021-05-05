package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ShopVipDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.ShopVip;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ShopVipMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.127747+08:00", comments="Source Table: shop_vip")
    BasicColumn[] selectList = BasicColumn.columnList(shopId, expireTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1267494+08:00", comments="Source Table: shop_vip")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1267494+08:00", comments="Source Table: shop_vip")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1267494+08:00", comments="Source Table: shop_vip")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ShopVip> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1267494+08:00", comments="Source Table: shop_vip")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ShopVip> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1267494+08:00", comments="Source Table: shop_vip")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ShopVipResult")
    Optional<ShopVip> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1267494+08:00", comments="Source Table: shop_vip")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ShopVipResult", value = {
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ShopVip> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.127747+08:00", comments="Source Table: shop_vip")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.127747+08:00", comments="Source Table: shop_vip")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, shopVip, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.127747+08:00", comments="Source Table: shop_vip")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, shopVip, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.127747+08:00", comments="Source Table: shop_vip")
    default int deleteByPrimaryKey(Integer shopId_) {
        return delete(c -> 
            c.where(shopId, isEqualTo(shopId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.127747+08:00", comments="Source Table: shop_vip")
    default int insert(ShopVip record) {
        return MyBatis3Utils.insert(this::insert, record, shopVip, c ->
            c.map(shopId).toProperty("shopId")
            .map(expireTime).toProperty("expireTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.127747+08:00", comments="Source Table: shop_vip")
    default int insertMultiple(Collection<ShopVip> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, shopVip, c ->
            c.map(shopId).toProperty("shopId")
            .map(expireTime).toProperty("expireTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.127747+08:00", comments="Source Table: shop_vip")
    default int insertSelective(ShopVip record) {
        return MyBatis3Utils.insert(this::insert, record, shopVip, c ->
            c.map(shopId).toPropertyWhenPresent("shopId", record::getShopId)
            .map(expireTime).toPropertyWhenPresent("expireTime", record::getExpireTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.127747+08:00", comments="Source Table: shop_vip")
    default Optional<ShopVip> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, shopVip, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.127747+08:00", comments="Source Table: shop_vip")
    default List<ShopVip> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, shopVip, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1287477+08:00", comments="Source Table: shop_vip")
    default List<ShopVip> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, shopVip, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1287477+08:00", comments="Source Table: shop_vip")
    default Optional<ShopVip> selectByPrimaryKey(Integer shopId_) {
        return selectOne(c ->
            c.where(shopId, isEqualTo(shopId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1287477+08:00", comments="Source Table: shop_vip")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, shopVip, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1287477+08:00", comments="Source Table: shop_vip")
    static UpdateDSL<UpdateModel> updateAllColumns(ShopVip record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(shopId).equalTo(record::getShopId)
                .set(expireTime).equalTo(record::getExpireTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1287477+08:00", comments="Source Table: shop_vip")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ShopVip record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(shopId).equalToWhenPresent(record::getShopId)
                .set(expireTime).equalToWhenPresent(record::getExpireTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1287477+08:00", comments="Source Table: shop_vip")
    default int updateByPrimaryKey(ShopVip record) {
        return update(c ->
            c.set(expireTime).equalTo(record::getExpireTime)
            .where(shopId, isEqualTo(record::getShopId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1287477+08:00", comments="Source Table: shop_vip")
    default int updateByPrimaryKeySelective(ShopVip record) {
        return update(c ->
            c.set(expireTime).equalToWhenPresent(record::getExpireTime)
            .where(shopId, isEqualTo(record::getShopId))
        );
    }
}