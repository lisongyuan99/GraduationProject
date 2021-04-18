package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.OrganizerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.Organizer;
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
public interface OrganizerMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8348561+08:00", comments="Source Table: organizer")
    BasicColumn[] selectList = BasicColumn.columnList(id, nickname, avatar, motto, email, phoneNum, wxOpenId, type, positionCode, address, lat, lng);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8328609+08:00", comments="Source Table: organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8328609+08:00", comments="Source Table: organizer")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8328609+08:00", comments="Source Table: organizer")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Organizer> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Organizer> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
    default int insertMultiple(MultiRowInsertStatementProvider<Organizer> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrganizerResult")
    Optional<Organizer> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
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
        @Result(column="position_code", property="positionCode", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.DOUBLE),
        @Result(column="lng", property="lng", jdbcType=JdbcType.DOUBLE)
    })
    List<Organizer> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
    default int insert(Organizer record) {
        return MyBatis3Utils.insert(this::insert, record, organizer, c ->
            c.map(nickname).toProperty("nickname")
            .map(avatar).toProperty("avatar")
            .map(motto).toProperty("motto")
            .map(email).toProperty("email")
            .map(phoneNum).toProperty("phoneNum")
            .map(wxOpenId).toProperty("wxOpenId")
            .map(type).toProperty("type")
            .map(positionCode).toProperty("positionCode")
            .map(address).toProperty("address")
            .map(lat).toProperty("lat")
            .map(lng).toProperty("lng")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
    default int insertMultiple(Collection<Organizer> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, organizer, c ->
            c.map(nickname).toProperty("nickname")
            .map(avatar).toProperty("avatar")
            .map(motto).toProperty("motto")
            .map(email).toProperty("email")
            .map(phoneNum).toProperty("phoneNum")
            .map(wxOpenId).toProperty("wxOpenId")
            .map(type).toProperty("type")
            .map(positionCode).toProperty("positionCode")
            .map(address).toProperty("address")
            .map(lat).toProperty("lat")
            .map(lng).toProperty("lng")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8338693+08:00", comments="Source Table: organizer")
    default int insertSelective(Organizer record) {
        return MyBatis3Utils.insert(this::insert, record, organizer, c ->
            c.map(nickname).toPropertyWhenPresent("nickname", record::getNickname)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(motto).toPropertyWhenPresent("motto", record::getMotto)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(phoneNum).toPropertyWhenPresent("phoneNum", record::getPhoneNum)
            .map(wxOpenId).toPropertyWhenPresent("wxOpenId", record::getWxOpenId)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(positionCode).toPropertyWhenPresent("positionCode", record::getPositionCode)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(lat).toPropertyWhenPresent("lat", record::getLat)
            .map(lng).toPropertyWhenPresent("lng", record::getLng)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8348561+08:00", comments="Source Table: organizer")
    default Optional<Organizer> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8348561+08:00", comments="Source Table: organizer")
    default List<Organizer> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8348561+08:00", comments="Source Table: organizer")
    default List<Organizer> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8348561+08:00", comments="Source Table: organizer")
    default Optional<Organizer> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8378573+08:00", comments="Source Table: organizer")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8378573+08:00", comments="Source Table: organizer")
    static UpdateDSL<UpdateModel> updateAllColumns(Organizer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(nickname).equalTo(record::getNickname)
                .set(avatar).equalTo(record::getAvatar)
                .set(motto).equalTo(record::getMotto)
                .set(email).equalTo(record::getEmail)
                .set(phoneNum).equalTo(record::getPhoneNum)
                .set(wxOpenId).equalTo(record::getWxOpenId)
                .set(type).equalTo(record::getType)
                .set(positionCode).equalTo(record::getPositionCode)
                .set(address).equalTo(record::getAddress)
                .set(lat).equalTo(record::getLat)
                .set(lng).equalTo(record::getLng);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8378573+08:00", comments="Source Table: organizer")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Organizer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(nickname).equalToWhenPresent(record::getNickname)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(motto).equalToWhenPresent(record::getMotto)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(phoneNum).equalToWhenPresent(record::getPhoneNum)
                .set(wxOpenId).equalToWhenPresent(record::getWxOpenId)
                .set(type).equalToWhenPresent(record::getType)
                .set(positionCode).equalToWhenPresent(record::getPositionCode)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(lat).equalToWhenPresent(record::getLat)
                .set(lng).equalToWhenPresent(record::getLng);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8378573+08:00", comments="Source Table: organizer")
    default int updateByPrimaryKey(Organizer record) {
        return update(c ->
            c.set(nickname).equalTo(record::getNickname)
            .set(avatar).equalTo(record::getAvatar)
            .set(motto).equalTo(record::getMotto)
            .set(email).equalTo(record::getEmail)
            .set(phoneNum).equalTo(record::getPhoneNum)
            .set(wxOpenId).equalTo(record::getWxOpenId)
            .set(type).equalTo(record::getType)
            .set(positionCode).equalTo(record::getPositionCode)
            .set(address).equalTo(record::getAddress)
            .set(lat).equalTo(record::getLat)
            .set(lng).equalTo(record::getLng)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8388444+08:00", comments="Source Table: organizer")
    default int updateByPrimaryKeySelective(Organizer record) {
        return update(c ->
            c.set(nickname).equalToWhenPresent(record::getNickname)
            .set(avatar).equalToWhenPresent(record::getAvatar)
            .set(motto).equalToWhenPresent(record::getMotto)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(phoneNum).equalToWhenPresent(record::getPhoneNum)
            .set(wxOpenId).equalToWhenPresent(record::getWxOpenId)
            .set(type).equalToWhenPresent(record::getType)
            .set(positionCode).equalToWhenPresent(record::getPositionCode)
            .set(address).equalToWhenPresent(record::getAddress)
            .set(lat).equalToWhenPresent(record::getLat)
            .set(lng).equalToWhenPresent(record::getLng)
            .where(id, isEqualTo(record::getId))
        );
    }
}