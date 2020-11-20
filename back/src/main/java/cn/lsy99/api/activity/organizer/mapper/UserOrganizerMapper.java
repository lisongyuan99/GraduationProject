package cn.lsy99.api.activity.organizer.mapper;

import static cn.lsy99.api.activity.organizer.mapper.UserOrganizerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.organizer.table.UserOrganizer;
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
public interface UserOrganizerMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, organizerId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<UserOrganizer> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserOrganizerResult")
    Optional<UserOrganizer> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserOrganizerResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="organizer_id", property="organizerId", jdbcType=JdbcType.VARCHAR)
    })
    List<UserOrganizer> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userOrganizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userOrganizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default int insert(UserOrganizer record) {
        return MyBatis3Utils.insert(this::insert, record, userOrganizer, c ->
            c.map(userId).toProperty("userId")
            .map(organizerId).toProperty("organizerId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default int insertSelective(UserOrganizer record) {
        return MyBatis3Utils.insert(this::insert, record, userOrganizer, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(organizerId).toPropertyWhenPresent("organizerId", record::getOrganizerId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default Optional<UserOrganizer> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userOrganizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default List<UserOrganizer> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userOrganizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default List<UserOrganizer> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userOrganizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default Optional<UserOrganizer> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userOrganizer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    static UpdateDSL<UpdateModel> updateAllColumns(UserOrganizer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(organizerId).equalTo(record::getOrganizerId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserOrganizer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(organizerId).equalToWhenPresent(record::getOrganizerId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default int updateByPrimaryKey(UserOrganizer record) {
        return update(c ->
            c.set(userId).equalTo(record::getUserId)
            .set(organizerId).equalTo(record::getOrganizerId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4588387+08:00", comments="Source Table: user_organizer")
    default int updateByPrimaryKeySelective(UserOrganizer record) {
        return update(c ->
            c.set(userId).equalToWhenPresent(record::getUserId)
            .set(organizerId).equalToWhenPresent(record::getOrganizerId)
            .where(id, isEqualTo(record::getId))
        );
    }
}