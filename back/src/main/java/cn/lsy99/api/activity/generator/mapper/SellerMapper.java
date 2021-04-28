package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.SellerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.Seller;
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
public interface SellerMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    BasicColumn[] selectList = BasicColumn.columnList(id, nickname, avatar, phone, wxOpenId, type, shopId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Seller> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Seller> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default int insertMultiple(MultiRowInsertStatementProvider<Seller> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SellerResult")
    Optional<Seller> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SellerResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="wx_open_id", property="wxOpenId", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER)
    })
    List<Seller> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, seller, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, seller, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default int insert(Seller record) {
        return MyBatis3Utils.insert(this::insert, record, seller, c ->
            c.map(nickname).toProperty("nickname")
            .map(avatar).toProperty("avatar")
            .map(phone).toProperty("phone")
            .map(wxOpenId).toProperty("wxOpenId")
            .map(type).toProperty("type")
            .map(shopId).toProperty("shopId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default int insertMultiple(Collection<Seller> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, seller, c ->
            c.map(nickname).toProperty("nickname")
            .map(avatar).toProperty("avatar")
            .map(phone).toProperty("phone")
            .map(wxOpenId).toProperty("wxOpenId")
            .map(type).toProperty("type")
            .map(shopId).toProperty("shopId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default int insertSelective(Seller record) {
        return MyBatis3Utils.insert(this::insert, record, seller, c ->
            c.map(nickname).toPropertyWhenPresent("nickname", record::getNickname)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(phone).toPropertyWhenPresent("phone", record::getPhone)
            .map(wxOpenId).toPropertyWhenPresent("wxOpenId", record::getWxOpenId)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(shopId).toPropertyWhenPresent("shopId", record::getShopId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default Optional<Seller> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, seller, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default List<Seller> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, seller, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default List<Seller> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, seller, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default Optional<Seller> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, seller, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    static UpdateDSL<UpdateModel> updateAllColumns(Seller record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(nickname).equalTo(record::getNickname)
                .set(avatar).equalTo(record::getAvatar)
                .set(phone).equalTo(record::getPhone)
                .set(wxOpenId).equalTo(record::getWxOpenId)
                .set(type).equalTo(record::getType)
                .set(shopId).equalTo(record::getShopId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Seller record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(nickname).equalToWhenPresent(record::getNickname)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(phone).equalToWhenPresent(record::getPhone)
                .set(wxOpenId).equalToWhenPresent(record::getWxOpenId)
                .set(type).equalToWhenPresent(record::getType)
                .set(shopId).equalToWhenPresent(record::getShopId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default int updateByPrimaryKey(Seller record) {
        return update(c ->
            c.set(nickname).equalTo(record::getNickname)
            .set(avatar).equalTo(record::getAvatar)
            .set(phone).equalTo(record::getPhone)
            .set(wxOpenId).equalTo(record::getWxOpenId)
            .set(type).equalTo(record::getType)
            .set(shopId).equalTo(record::getShopId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8977332+08:00", comments="Source Table: seller")
    default int updateByPrimaryKeySelective(Seller record) {
        return update(c ->
            c.set(nickname).equalToWhenPresent(record::getNickname)
            .set(avatar).equalToWhenPresent(record::getAvatar)
            .set(phone).equalToWhenPresent(record::getPhone)
            .set(wxOpenId).equalToWhenPresent(record::getWxOpenId)
            .set(type).equalToWhenPresent(record::getType)
            .set(shopId).equalToWhenPresent(record::getShopId)
            .where(id, isEqualTo(record::getId))
        );
    }
}