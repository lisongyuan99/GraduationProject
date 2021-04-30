package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.VipDetailDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.VipDetail;
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
public interface VipDetailMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3199938+08:00", comments="Source Table: vip_detail")
    BasicColumn[] selectList = BasicColumn.columnList(id, payTime, addDays, price, shopId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3179963+08:00", comments="Source Table: vip_detail")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<VipDetail> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<VipDetail> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    default int insertMultiple(MultiRowInsertStatementProvider<VipDetail> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("VipDetailResult")
    Optional<VipDetail> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="VipDetailResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="add_days", property="addDays", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER)
    })
    List<VipDetail> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, vipDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, vipDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3189938+08:00", comments="Source Table: vip_detail")
    default int insert(VipDetail record) {
        return MyBatis3Utils.insert(this::insert, record, vipDetail, c ->
            c.map(payTime).toProperty("payTime")
            .map(addDays).toProperty("addDays")
            .map(price).toProperty("price")
            .map(shopId).toProperty("shopId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3199938+08:00", comments="Source Table: vip_detail")
    default int insertMultiple(Collection<VipDetail> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, vipDetail, c ->
            c.map(payTime).toProperty("payTime")
            .map(addDays).toProperty("addDays")
            .map(price).toProperty("price")
            .map(shopId).toProperty("shopId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3199938+08:00", comments="Source Table: vip_detail")
    default int insertSelective(VipDetail record) {
        return MyBatis3Utils.insert(this::insert, record, vipDetail, c ->
            c.map(payTime).toPropertyWhenPresent("payTime", record::getPayTime)
            .map(addDays).toPropertyWhenPresent("addDays", record::getAddDays)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(shopId).toPropertyWhenPresent("shopId", record::getShopId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3199938+08:00", comments="Source Table: vip_detail")
    default Optional<VipDetail> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, vipDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3199938+08:00", comments="Source Table: vip_detail")
    default List<VipDetail> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, vipDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3199938+08:00", comments="Source Table: vip_detail")
    default List<VipDetail> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, vipDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3199938+08:00", comments="Source Table: vip_detail")
    default Optional<VipDetail> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3199938+08:00", comments="Source Table: vip_detail")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, vipDetail, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3199938+08:00", comments="Source Table: vip_detail")
    static UpdateDSL<UpdateModel> updateAllColumns(VipDetail record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(payTime).equalTo(record::getPayTime)
                .set(addDays).equalTo(record::getAddDays)
                .set(price).equalTo(record::getPrice)
                .set(shopId).equalTo(record::getShopId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3199938+08:00", comments="Source Table: vip_detail")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(VipDetail record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(payTime).equalToWhenPresent(record::getPayTime)
                .set(addDays).equalToWhenPresent(record::getAddDays)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(shopId).equalToWhenPresent(record::getShopId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3209882+08:00", comments="Source Table: vip_detail")
    default int updateByPrimaryKey(VipDetail record) {
        return update(c ->
            c.set(payTime).equalTo(record::getPayTime)
            .set(addDays).equalTo(record::getAddDays)
            .set(price).equalTo(record::getPrice)
            .set(shopId).equalTo(record::getShopId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.3209882+08:00", comments="Source Table: vip_detail")
    default int updateByPrimaryKeySelective(VipDetail record) {
        return update(c ->
            c.set(payTime).equalToWhenPresent(record::getPayTime)
            .set(addDays).equalToWhenPresent(record::getAddDays)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(shopId).equalToWhenPresent(record::getShopId)
            .where(id, isEqualTo(record::getId))
        );
    }
}