package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.CustomerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.Customer;
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
public interface CustomerMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    BasicColumn[] selectList = BasicColumn.columnList(id, nickname, avatar, motto, email, phoneNum, wxOpenId, type, createTime, updateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4037571+08:00", comments="Source Table: customer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4037571+08:00", comments="Source Table: customer")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4037571+08:00", comments="Source Table: customer")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Customer> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Customer> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    default int insertMultiple(MultiRowInsertStatementProvider<Customer> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CustomerResult")
    Optional<Customer> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CustomerResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="motto", property="motto", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_num", property="phoneNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="wx_open_id", property="wxOpenId", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Customer> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, customer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, customer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    default int insert(Customer record) {
        return MyBatis3Utils.insert(this::insert, record, customer, c ->
            c.map(nickname).toProperty("nickname")
            .map(avatar).toProperty("avatar")
            .map(motto).toProperty("motto")
            .map(email).toProperty("email")
            .map(phoneNum).toProperty("phoneNum")
            .map(wxOpenId).toProperty("wxOpenId")
            .map(type).toProperty("type")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    default int insertMultiple(Collection<Customer> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, customer, c ->
            c.map(nickname).toProperty("nickname")
            .map(avatar).toProperty("avatar")
            .map(motto).toProperty("motto")
            .map(email).toProperty("email")
            .map(phoneNum).toProperty("phoneNum")
            .map(wxOpenId).toProperty("wxOpenId")
            .map(type).toProperty("type")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    default int insertSelective(Customer record) {
        return MyBatis3Utils.insert(this::insert, record, customer, c ->
            c.map(nickname).toPropertyWhenPresent("nickname", record::getNickname)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(motto).toPropertyWhenPresent("motto", record::getMotto)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(phoneNum).toPropertyWhenPresent("phoneNum", record::getPhoneNum)
            .map(wxOpenId).toPropertyWhenPresent("wxOpenId", record::getWxOpenId)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4047538+08:00", comments="Source Table: customer")
    default Optional<Customer> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, customer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4057506+08:00", comments="Source Table: customer")
    default List<Customer> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, customer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4057506+08:00", comments="Source Table: customer")
    default List<Customer> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, customer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4057506+08:00", comments="Source Table: customer")
    default Optional<Customer> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4057506+08:00", comments="Source Table: customer")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, customer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4057506+08:00", comments="Source Table: customer")
    static UpdateDSL<UpdateModel> updateAllColumns(Customer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(nickname).equalTo(record::getNickname)
                .set(avatar).equalTo(record::getAvatar)
                .set(motto).equalTo(record::getMotto)
                .set(email).equalTo(record::getEmail)
                .set(phoneNum).equalTo(record::getPhoneNum)
                .set(wxOpenId).equalTo(record::getWxOpenId)
                .set(type).equalTo(record::getType)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4057506+08:00", comments="Source Table: customer")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Customer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(nickname).equalToWhenPresent(record::getNickname)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(motto).equalToWhenPresent(record::getMotto)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(phoneNum).equalToWhenPresent(record::getPhoneNum)
                .set(wxOpenId).equalToWhenPresent(record::getWxOpenId)
                .set(type).equalToWhenPresent(record::getType)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4057506+08:00", comments="Source Table: customer")
    default int updateByPrimaryKey(Customer record) {
        return update(c ->
            c.set(nickname).equalTo(record::getNickname)
            .set(avatar).equalTo(record::getAvatar)
            .set(motto).equalTo(record::getMotto)
            .set(email).equalTo(record::getEmail)
            .set(phoneNum).equalTo(record::getPhoneNum)
            .set(wxOpenId).equalTo(record::getWxOpenId)
            .set(type).equalTo(record::getType)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4057506+08:00", comments="Source Table: customer")
    default int updateByPrimaryKeySelective(Customer record) {
        return update(c ->
            c.set(nickname).equalToWhenPresent(record::getNickname)
            .set(avatar).equalToWhenPresent(record::getAvatar)
            .set(motto).equalToWhenPresent(record::getMotto)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(phoneNum).equalToWhenPresent(record::getPhoneNum)
            .set(wxOpenId).equalToWhenPresent(record::getWxOpenId)
            .set(type).equalToWhenPresent(record::getType)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}