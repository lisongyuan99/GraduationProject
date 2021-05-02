package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ShopBalanceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.ShopBalance;
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
public interface ShopBalanceMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7444168+08:00", comments="Source Table: shop_balance")
    BasicColumn[] selectList = BasicColumn.columnList(shopId, balance);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ShopBalance> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ShopBalance> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ShopBalanceResult")
    Optional<ShopBalance> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ShopBalanceResult", value = {
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DOUBLE)
    })
    List<ShopBalance> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, shopBalance, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, shopBalance, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    default int deleteByPrimaryKey(Integer shopId_) {
        return delete(c -> 
            c.where(shopId, isEqualTo(shopId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    default int insert(ShopBalance record) {
        return MyBatis3Utils.insert(this::insert, record, shopBalance, c ->
            c.map(shopId).toProperty("shopId")
            .map(balance).toProperty("balance")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    default int insertMultiple(Collection<ShopBalance> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, shopBalance, c ->
            c.map(shopId).toProperty("shopId")
            .map(balance).toProperty("balance")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7434201+08:00", comments="Source Table: shop_balance")
    default int insertSelective(ShopBalance record) {
        return MyBatis3Utils.insert(this::insert, record, shopBalance, c ->
            c.map(shopId).toPropertyWhenPresent("shopId", record::getShopId)
            .map(balance).toPropertyWhenPresent("balance", record::getBalance)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7444168+08:00", comments="Source Table: shop_balance")
    default Optional<ShopBalance> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, shopBalance, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7444168+08:00", comments="Source Table: shop_balance")
    default List<ShopBalance> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, shopBalance, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7444168+08:00", comments="Source Table: shop_balance")
    default List<ShopBalance> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, shopBalance, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7444168+08:00", comments="Source Table: shop_balance")
    default Optional<ShopBalance> selectByPrimaryKey(Integer shopId_) {
        return selectOne(c ->
            c.where(shopId, isEqualTo(shopId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7444168+08:00", comments="Source Table: shop_balance")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, shopBalance, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7444168+08:00", comments="Source Table: shop_balance")
    static UpdateDSL<UpdateModel> updateAllColumns(ShopBalance record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(shopId).equalTo(record::getShopId)
                .set(balance).equalTo(record::getBalance);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7444168+08:00", comments="Source Table: shop_balance")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ShopBalance record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(shopId).equalToWhenPresent(record::getShopId)
                .set(balance).equalToWhenPresent(record::getBalance);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7444168+08:00", comments="Source Table: shop_balance")
    default int updateByPrimaryKey(ShopBalance record) {
        return update(c ->
            c.set(balance).equalTo(record::getBalance)
            .where(shopId, isEqualTo(record::getShopId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7444168+08:00", comments="Source Table: shop_balance")
    default int updateByPrimaryKeySelective(ShopBalance record) {
        return update(c ->
            c.set(balance).equalToWhenPresent(record::getBalance)
            .where(shopId, isEqualTo(record::getShopId))
        );
    }
}