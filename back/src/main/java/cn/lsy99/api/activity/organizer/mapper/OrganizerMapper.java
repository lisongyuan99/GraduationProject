package cn.lsy99.api.activity.organizer.mapper;

import static cn.lsy99.api.activity.organizer.mapper.OrganizerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.organizer.table.Organizer;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
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
public interface OrganizerMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4839883+08:00", comments="Source Table: organizer")
    BasicColumn[] selectList = BasicColumn.columnList(id, username, name, password, email, phoneAreaCode, phoneNum, wxUnionId, role, createTime, updateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Organizer> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrganizerResult")
    Optional<Organizer> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrganizerResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_area_code", property="phoneAreaCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_num", property="phoneNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="wx_union_id", property="wxUnionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Organizer> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    default int insert(Organizer record) {
        return MyBatis3Utils.insert(this::insert, record, organizer, c ->
            c.map(username).toProperty("username")
            .map(name).toProperty("name")
            .map(password).toProperty("password")
            .map(email).toProperty("email")
            .map(phoneAreaCode).toProperty("phoneAreaCode")
            .map(phoneNum).toProperty("phoneNum")
            .map(wxUnionId).toProperty("wxUnionId")
            .map(role).toProperty("role")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4829903+08:00", comments="Source Table: organizer")
    default int insertSelective(Organizer record) {
        return MyBatis3Utils.insert(this::insert, record, organizer, c ->
            c.map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(phoneAreaCode).toPropertyWhenPresent("phoneAreaCode", record::getPhoneAreaCode)
            .map(phoneNum).toPropertyWhenPresent("phoneNum", record::getPhoneNum)
            .map(wxUnionId).toPropertyWhenPresent("wxUnionId", record::getWxUnionId)
            .map(role).toPropertyWhenPresent("role", record::getRole)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4839883+08:00", comments="Source Table: organizer")
    default Optional<Organizer> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4839883+08:00", comments="Source Table: organizer")
    default List<Organizer> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4839883+08:00", comments="Source Table: organizer")
    default List<Organizer> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4839883+08:00", comments="Source Table: organizer")
    default Optional<Organizer> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4839883+08:00", comments="Source Table: organizer")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4839883+08:00", comments="Source Table: organizer")
    static UpdateDSL<UpdateModel> updateAllColumns(Organizer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(username).equalTo(record::getUsername)
                .set(name).equalTo(record::getName)
                .set(password).equalTo(record::getPassword)
                .set(email).equalTo(record::getEmail)
                .set(phoneAreaCode).equalTo(record::getPhoneAreaCode)
                .set(phoneNum).equalTo(record::getPhoneNum)
                .set(wxUnionId).equalTo(record::getWxUnionId)
                .set(role).equalTo(record::getRole)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4839883+08:00", comments="Source Table: organizer")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Organizer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(username).equalToWhenPresent(record::getUsername)
                .set(name).equalToWhenPresent(record::getName)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(phoneAreaCode).equalToWhenPresent(record::getPhoneAreaCode)
                .set(phoneNum).equalToWhenPresent(record::getPhoneNum)
                .set(wxUnionId).equalToWhenPresent(record::getWxUnionId)
                .set(role).equalToWhenPresent(record::getRole)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4839883+08:00", comments="Source Table: organizer")
    default int updateByPrimaryKey(Organizer record) {
        return update(c ->
            c.set(username).equalTo(record::getUsername)
            .set(name).equalTo(record::getName)
            .set(password).equalTo(record::getPassword)
            .set(email).equalTo(record::getEmail)
            .set(phoneAreaCode).equalTo(record::getPhoneAreaCode)
            .set(phoneNum).equalTo(record::getPhoneNum)
            .set(wxUnionId).equalTo(record::getWxUnionId)
            .set(role).equalTo(record::getRole)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4839883+08:00", comments="Source Table: organizer")
    default int updateByPrimaryKeySelective(Organizer record) {
        return update(c ->
            c.set(username).equalToWhenPresent(record::getUsername)
            .set(name).equalToWhenPresent(record::getName)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(phoneAreaCode).equalToWhenPresent(record::getPhoneAreaCode)
            .set(phoneNum).equalToWhenPresent(record::getPhoneNum)
            .set(wxUnionId).equalToWhenPresent(record::getWxUnionId)
            .set(role).equalToWhenPresent(record::getRole)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}