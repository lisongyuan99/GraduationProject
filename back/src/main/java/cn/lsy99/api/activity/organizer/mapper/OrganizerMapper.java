package cn.lsy99.api.activity.organizer.mapper;

import static cn.lsy99.api.activity.organizer.mapper.OrganizerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.organizer.table.Organizer;
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
public interface OrganizerMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    BasicColumn[] selectList = BasicColumn.columnList(id, nickname, avatar, motto, email, phoneNum, wxOpenId, type, createTime, updateTime, fansId, activitiesId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Organizer> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Organizer> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrganizerResult")
    Optional<Organizer> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrganizerResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="motto", property="motto", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_num", property="phoneNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="wx_open_id", property="wxOpenId", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="fans_id", property="fansId", jdbcType=JdbcType.ARRAY),
        @Result(column="activities_id", property="activitiesId", jdbcType=JdbcType.ARRAY)
    })
    List<Organizer> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default int insert(Organizer record) {
        return MyBatis3Utils.insert(this::insert, record, organizer, c ->
            c.map(id).toProperty("id")
            .map(nickname).toProperty("nickname")
            .map(avatar).toProperty("avatar")
            .map(motto).toProperty("motto")
            .map(email).toProperty("email")
            .map(phoneNum).toProperty("phoneNum")
            .map(wxOpenId).toProperty("wxOpenId")
            .map(type).toProperty("type")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(fansId).toProperty("fansId")
            .map(activitiesId).toProperty("activitiesId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default int insertMultiple(Collection<Organizer> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, organizer, c ->
            c.map(id).toProperty("id")
            .map(nickname).toProperty("nickname")
            .map(avatar).toProperty("avatar")
            .map(motto).toProperty("motto")
            .map(email).toProperty("email")
            .map(phoneNum).toProperty("phoneNum")
            .map(wxOpenId).toProperty("wxOpenId")
            .map(type).toProperty("type")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(fansId).toProperty("fansId")
            .map(activitiesId).toProperty("activitiesId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default int insertSelective(Organizer record) {
        return MyBatis3Utils.insert(this::insert, record, organizer, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(nickname).toPropertyWhenPresent("nickname", record::getNickname)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(motto).toPropertyWhenPresent("motto", record::getMotto)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(phoneNum).toPropertyWhenPresent("phoneNum", record::getPhoneNum)
            .map(wxOpenId).toPropertyWhenPresent("wxOpenId", record::getWxOpenId)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(fansId).toPropertyWhenPresent("fansId", record::getFansId)
            .map(activitiesId).toPropertyWhenPresent("activitiesId", record::getActivitiesId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default Optional<Organizer> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default List<Organizer> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default List<Organizer> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default Optional<Organizer> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    static UpdateDSL<UpdateModel> updateAllColumns(Organizer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(nickname).equalTo(record::getNickname)
                .set(avatar).equalTo(record::getAvatar)
                .set(motto).equalTo(record::getMotto)
                .set(email).equalTo(record::getEmail)
                .set(phoneNum).equalTo(record::getPhoneNum)
                .set(wxOpenId).equalTo(record::getWxOpenId)
                .set(type).equalTo(record::getType)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(fansId).equalTo(record::getFansId)
                .set(activitiesId).equalTo(record::getActivitiesId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Organizer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(nickname).equalToWhenPresent(record::getNickname)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(motto).equalToWhenPresent(record::getMotto)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(phoneNum).equalToWhenPresent(record::getPhoneNum)
                .set(wxOpenId).equalToWhenPresent(record::getWxOpenId)
                .set(type).equalToWhenPresent(record::getType)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(fansId).equalToWhenPresent(record::getFansId)
                .set(activitiesId).equalToWhenPresent(record::getActivitiesId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default int updateByPrimaryKey(Organizer record) {
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
            .set(fansId).equalTo(record::getFansId)
            .set(activitiesId).equalTo(record::getActivitiesId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-20T18:01:03.673027+08:00", comments="Source Table: organizer")
    default int updateByPrimaryKeySelective(Organizer record) {
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
            .set(fansId).equalToWhenPresent(record::getFansId)
            .set(activitiesId).equalToWhenPresent(record::getActivitiesId)
            .where(id, isEqualTo(record::getId))
        );
    }
}