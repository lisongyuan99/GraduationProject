package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ShopFollowDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.ShopFollow;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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
public interface ShopFollowMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7294572+08:00", comments="Source Table: shop_follow")
    BasicColumn[] selectList = BasicColumn.columnList(id, shopId, customerId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7274671+08:00", comments="Source Table: shop_follow")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7274671+08:00", comments="Source Table: shop_follow")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7274671+08:00", comments="Source Table: shop_follow")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<ShopFollow> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7274671+08:00", comments="Source Table: shop_follow")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ShopFollow> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7284598+08:00", comments="Source Table: shop_follow")
    default int insertMultiple(MultiRowInsertStatementProvider<ShopFollow> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7284598+08:00", comments="Source Table: shop_follow")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ShopFollowResult")
    Optional<ShopFollow> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7284598+08:00", comments="Source Table: shop_follow")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ShopFollowResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER)
    })
    List<ShopFollow> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7284598+08:00", comments="Source Table: shop_follow")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7284598+08:00", comments="Source Table: shop_follow")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, shopFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7284598+08:00", comments="Source Table: shop_follow")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, shopFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7284598+08:00", comments="Source Table: shop_follow")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7284598+08:00", comments="Source Table: shop_follow")
    default int insert(ShopFollow record) {
        return MyBatis3Utils.insert(this::insert, record, shopFollow, c ->
            c.map(shopId).toProperty("shopId")
            .map(customerId).toProperty("customerId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7284598+08:00", comments="Source Table: shop_follow")
    default int insertMultiple(Collection<ShopFollow> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, shopFollow, c ->
            c.map(shopId).toProperty("shopId")
            .map(customerId).toProperty("customerId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7284598+08:00", comments="Source Table: shop_follow")
    default int insertSelective(ShopFollow record) {
        return MyBatis3Utils.insert(this::insert, record, shopFollow, c ->
            c.map(shopId).toPropertyWhenPresent("shopId", record::getShopId)
            .map(customerId).toPropertyWhenPresent("customerId", record::getCustomerId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7294572+08:00", comments="Source Table: shop_follow")
    default Optional<ShopFollow> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, shopFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7294572+08:00", comments="Source Table: shop_follow")
    default List<ShopFollow> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, shopFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7294572+08:00", comments="Source Table: shop_follow")
    default List<ShopFollow> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, shopFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7294572+08:00", comments="Source Table: shop_follow")
    default Optional<ShopFollow> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7294572+08:00", comments="Source Table: shop_follow")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, shopFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7294572+08:00", comments="Source Table: shop_follow")
    static UpdateDSL<UpdateModel> updateAllColumns(ShopFollow record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(shopId).equalTo(record::getShopId)
                .set(customerId).equalTo(record::getCustomerId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7294572+08:00", comments="Source Table: shop_follow")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ShopFollow record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(shopId).equalToWhenPresent(record::getShopId)
                .set(customerId).equalToWhenPresent(record::getCustomerId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7294572+08:00", comments="Source Table: shop_follow")
    default int updateByPrimaryKey(ShopFollow record) {
        return update(c ->
            c.set(shopId).equalTo(record::getShopId)
            .set(customerId).equalTo(record::getCustomerId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7294572+08:00", comments="Source Table: shop_follow")
    default int updateByPrimaryKeySelective(ShopFollow record) {
        return update(c ->
            c.set(shopId).equalToWhenPresent(record::getShopId)
            .set(customerId).equalToWhenPresent(record::getCustomerId)
            .where(id, isEqualTo(record::getId))
        );
    }
}