package cn.lsy99.api.activity.generator.mapper;

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
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4087427+08:00", comments="Source Table: organizer")
    BasicColumn[] selectList = BasicColumn.columnList(OrganizerDynamicSqlSupport.id, OrganizerDynamicSqlSupport.nickname, OrganizerDynamicSqlSupport.avatar, OrganizerDynamicSqlSupport.motto, OrganizerDynamicSqlSupport.email, OrganizerDynamicSqlSupport.phoneNum, OrganizerDynamicSqlSupport.wxOpenId, OrganizerDynamicSqlSupport.type, OrganizerDynamicSqlSupport.createTime, OrganizerDynamicSqlSupport.updateTime, OrganizerDynamicSqlSupport.positionCode);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4077454+08:00", comments="Source Table: organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4077454+08:00", comments="Source Table: organizer")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4077454+08:00", comments="Source Table: organizer")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Organizer> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4077454+08:00", comments="Source Table: organizer")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Organizer> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4077454+08:00", comments="Source Table: organizer")
    default int insertMultiple(MultiRowInsertStatementProvider<Organizer> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4077454+08:00", comments="Source Table: organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrganizerResult")
    Optional<Organizer> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4077454+08:00", comments="Source Table: organizer")
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
        @Result(column="position_code", property="positionCode", jdbcType=JdbcType.INTEGER)
    })
    List<Organizer> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4087427+08:00", comments="Source Table: organizer")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4087427+08:00", comments="Source Table: organizer")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, OrganizerDynamicSqlSupport.organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4087427+08:00", comments="Source Table: organizer")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, OrganizerDynamicSqlSupport.organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4087427+08:00", comments="Source Table: organizer")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(OrganizerDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4087427+08:00", comments="Source Table: organizer")
    default int insert(Organizer record) {
        return MyBatis3Utils.insert(this::insert, record, OrganizerDynamicSqlSupport.organizer, c ->
            c.map(OrganizerDynamicSqlSupport.nickname).toProperty("nickname")
            .map(OrganizerDynamicSqlSupport.avatar).toProperty("avatar")
            .map(OrganizerDynamicSqlSupport.motto).toProperty("motto")
            .map(OrganizerDynamicSqlSupport.email).toProperty("email")
            .map(OrganizerDynamicSqlSupport.phoneNum).toProperty("phoneNum")
            .map(OrganizerDynamicSqlSupport.wxOpenId).toProperty("wxOpenId")
            .map(OrganizerDynamicSqlSupport.type).toProperty("type")
            .map(OrganizerDynamicSqlSupport.createTime).toProperty("createTime")
            .map(OrganizerDynamicSqlSupport.updateTime).toProperty("updateTime")
            .map(OrganizerDynamicSqlSupport.positionCode).toProperty("positionCode")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4087427+08:00", comments="Source Table: organizer")
    default int insertMultiple(Collection<Organizer> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, OrganizerDynamicSqlSupport.organizer, c ->
            c.map(OrganizerDynamicSqlSupport.nickname).toProperty("nickname")
            .map(OrganizerDynamicSqlSupport.avatar).toProperty("avatar")
            .map(OrganizerDynamicSqlSupport.motto).toProperty("motto")
            .map(OrganizerDynamicSqlSupport.email).toProperty("email")
            .map(OrganizerDynamicSqlSupport.phoneNum).toProperty("phoneNum")
            .map(OrganizerDynamicSqlSupport.wxOpenId).toProperty("wxOpenId")
            .map(OrganizerDynamicSqlSupport.type).toProperty("type")
            .map(OrganizerDynamicSqlSupport.createTime).toProperty("createTime")
            .map(OrganizerDynamicSqlSupport.updateTime).toProperty("updateTime")
            .map(OrganizerDynamicSqlSupport.positionCode).toProperty("positionCode")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4087427+08:00", comments="Source Table: organizer")
    default int insertSelective(Organizer record) {
        return MyBatis3Utils.insert(this::insert, record, OrganizerDynamicSqlSupport.organizer, c ->
            c.map(OrganizerDynamicSqlSupport.nickname).toPropertyWhenPresent("nickname", record::getNickname)
            .map(OrganizerDynamicSqlSupport.avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(OrganizerDynamicSqlSupport.motto).toPropertyWhenPresent("motto", record::getMotto)
            .map(OrganizerDynamicSqlSupport.email).toPropertyWhenPresent("email", record::getEmail)
            .map(OrganizerDynamicSqlSupport.phoneNum).toPropertyWhenPresent("phoneNum", record::getPhoneNum)
            .map(OrganizerDynamicSqlSupport.wxOpenId).toPropertyWhenPresent("wxOpenId", record::getWxOpenId)
            .map(OrganizerDynamicSqlSupport.type).toPropertyWhenPresent("type", record::getType)
            .map(OrganizerDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(OrganizerDynamicSqlSupport.updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(OrganizerDynamicSqlSupport.positionCode).toPropertyWhenPresent("positionCode", record::getPositionCode)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4087427+08:00", comments="Source Table: organizer")
    default Optional<Organizer> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, OrganizerDynamicSqlSupport.organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4097462+08:00", comments="Source Table: organizer")
    default List<Organizer> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, OrganizerDynamicSqlSupport.organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4097462+08:00", comments="Source Table: organizer")
    default List<Organizer> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, OrganizerDynamicSqlSupport.organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4097462+08:00", comments="Source Table: organizer")
    default Optional<Organizer> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(OrganizerDynamicSqlSupport.id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4097462+08:00", comments="Source Table: organizer")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, OrganizerDynamicSqlSupport.organizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4097462+08:00", comments="Source Table: organizer")
    static UpdateDSL<UpdateModel> updateAllColumns(Organizer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(OrganizerDynamicSqlSupport.nickname).equalTo(record::getNickname)
                .set(OrganizerDynamicSqlSupport.avatar).equalTo(record::getAvatar)
                .set(OrganizerDynamicSqlSupport.motto).equalTo(record::getMotto)
                .set(OrganizerDynamicSqlSupport.email).equalTo(record::getEmail)
                .set(OrganizerDynamicSqlSupport.phoneNum).equalTo(record::getPhoneNum)
                .set(OrganizerDynamicSqlSupport.wxOpenId).equalTo(record::getWxOpenId)
                .set(OrganizerDynamicSqlSupport.type).equalTo(record::getType)
                .set(OrganizerDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(OrganizerDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
                .set(OrganizerDynamicSqlSupport.positionCode).equalTo(record::getPositionCode);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4097462+08:00", comments="Source Table: organizer")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Organizer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(OrganizerDynamicSqlSupport.nickname).equalToWhenPresent(record::getNickname)
                .set(OrganizerDynamicSqlSupport.avatar).equalToWhenPresent(record::getAvatar)
                .set(OrganizerDynamicSqlSupport.motto).equalToWhenPresent(record::getMotto)
                .set(OrganizerDynamicSqlSupport.email).equalToWhenPresent(record::getEmail)
                .set(OrganizerDynamicSqlSupport.phoneNum).equalToWhenPresent(record::getPhoneNum)
                .set(OrganizerDynamicSqlSupport.wxOpenId).equalToWhenPresent(record::getWxOpenId)
                .set(OrganizerDynamicSqlSupport.type).equalToWhenPresent(record::getType)
                .set(OrganizerDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(OrganizerDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(OrganizerDynamicSqlSupport.positionCode).equalToWhenPresent(record::getPositionCode);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4097462+08:00", comments="Source Table: organizer")
    default int updateByPrimaryKey(Organizer record) {
        return update(c ->
            c.set(OrganizerDynamicSqlSupport.nickname).equalTo(record::getNickname)
            .set(OrganizerDynamicSqlSupport.avatar).equalTo(record::getAvatar)
            .set(OrganizerDynamicSqlSupport.motto).equalTo(record::getMotto)
            .set(OrganizerDynamicSqlSupport.email).equalTo(record::getEmail)
            .set(OrganizerDynamicSqlSupport.phoneNum).equalTo(record::getPhoneNum)
            .set(OrganizerDynamicSqlSupport.wxOpenId).equalTo(record::getWxOpenId)
            .set(OrganizerDynamicSqlSupport.type).equalTo(record::getType)
            .set(OrganizerDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
            .set(OrganizerDynamicSqlSupport.updateTime).equalTo(record::getUpdateTime)
            .set(OrganizerDynamicSqlSupport.positionCode).equalTo(record::getPositionCode)
            .where(OrganizerDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4097462+08:00", comments="Source Table: organizer")
    default int updateByPrimaryKeySelective(Organizer record) {
        return update(c ->
            c.set(OrganizerDynamicSqlSupport.nickname).equalToWhenPresent(record::getNickname)
            .set(OrganizerDynamicSqlSupport.avatar).equalToWhenPresent(record::getAvatar)
            .set(OrganizerDynamicSqlSupport.motto).equalToWhenPresent(record::getMotto)
            .set(OrganizerDynamicSqlSupport.email).equalToWhenPresent(record::getEmail)
            .set(OrganizerDynamicSqlSupport.phoneNum).equalToWhenPresent(record::getPhoneNum)
            .set(OrganizerDynamicSqlSupport.wxOpenId).equalToWhenPresent(record::getWxOpenId)
            .set(OrganizerDynamicSqlSupport.type).equalToWhenPresent(record::getType)
            .set(OrganizerDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
            .set(OrganizerDynamicSqlSupport.updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(OrganizerDynamicSqlSupport.positionCode).equalToWhenPresent(record::getPositionCode)
            .where(OrganizerDynamicSqlSupport.id, isEqualTo(record::getId))
        );
    }
}