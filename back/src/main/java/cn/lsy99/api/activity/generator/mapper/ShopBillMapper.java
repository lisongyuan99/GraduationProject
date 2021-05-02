package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ShopBillDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.ShopBill;
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
public interface ShopBillMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    BasicColumn[] selectList = BasicColumn.columnList(id, shopId, billTime, amount);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7404278+08:00", comments="Source Table: shop_bill")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7404278+08:00", comments="Source Table: shop_bill")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7404278+08:00", comments="Source Table: shop_bill")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<ShopBill> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7404278+08:00", comments="Source Table: shop_bill")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ShopBill> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    default int insertMultiple(MultiRowInsertStatementProvider<ShopBill> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ShopBillResult")
    Optional<ShopBill> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ShopBillResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_time", property="billTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE)
    })
    List<ShopBill> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, shopBill, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, shopBill, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    default int insert(ShopBill record) {
        return MyBatis3Utils.insert(this::insert, record, shopBill, c ->
            c.map(shopId).toProperty("shopId")
            .map(billTime).toProperty("billTime")
            .map(amount).toProperty("amount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    default int insertMultiple(Collection<ShopBill> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, shopBill, c ->
            c.map(shopId).toProperty("shopId")
            .map(billTime).toProperty("billTime")
            .map(amount).toProperty("amount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    default int insertSelective(ShopBill record) {
        return MyBatis3Utils.insert(this::insert, record, shopBill, c ->
            c.map(shopId).toPropertyWhenPresent("shopId", record::getShopId)
            .map(billTime).toPropertyWhenPresent("billTime", record::getBillTime)
            .map(amount).toPropertyWhenPresent("amount", record::getAmount)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7414312+08:00", comments="Source Table: shop_bill")
    default Optional<ShopBill> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, shopBill, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7424222+08:00", comments="Source Table: shop_bill")
    default List<ShopBill> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, shopBill, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7424222+08:00", comments="Source Table: shop_bill")
    default List<ShopBill> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, shopBill, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7424222+08:00", comments="Source Table: shop_bill")
    default Optional<ShopBill> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7424222+08:00", comments="Source Table: shop_bill")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, shopBill, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7424222+08:00", comments="Source Table: shop_bill")
    static UpdateDSL<UpdateModel> updateAllColumns(ShopBill record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(shopId).equalTo(record::getShopId)
                .set(billTime).equalTo(record::getBillTime)
                .set(amount).equalTo(record::getAmount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7424222+08:00", comments="Source Table: shop_bill")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ShopBill record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(shopId).equalToWhenPresent(record::getShopId)
                .set(billTime).equalToWhenPresent(record::getBillTime)
                .set(amount).equalToWhenPresent(record::getAmount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7424222+08:00", comments="Source Table: shop_bill")
    default int updateByPrimaryKey(ShopBill record) {
        return update(c ->
            c.set(shopId).equalTo(record::getShopId)
            .set(billTime).equalTo(record::getBillTime)
            .set(amount).equalTo(record::getAmount)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.7424222+08:00", comments="Source Table: shop_bill")
    default int updateByPrimaryKeySelective(ShopBill record) {
        return update(c ->
            c.set(shopId).equalToWhenPresent(record::getShopId)
            .set(billTime).equalToWhenPresent(record::getBillTime)
            .set(amount).equalToWhenPresent(record::getAmount)
            .where(id, isEqualTo(record::getId))
        );
    }
}