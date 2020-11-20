package cn.lsy99.api.activity.organizer.mapper;

import static cn.lsy99.api.activity.organizer.mapper.UserActivityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.organizer.table.UserActivity;
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
public interface UserActivityMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, activityId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4770121+08:00", comments="Source Table: user_activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4770121+08:00", comments="Source Table: user_activity")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4770121+08:00", comments="Source Table: user_activity")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<UserActivity> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4770121+08:00", comments="Source Table: user_activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserActivityResult")
    Optional<UserActivity> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4770121+08:00", comments="Source Table: user_activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserActivityResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER)
    })
    List<UserActivity> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    default int insert(UserActivity record) {
        return MyBatis3Utils.insert(this::insert, record, userActivity, c ->
            c.map(userId).toProperty("userId")
            .map(activityId).toProperty("activityId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    default int insertSelective(UserActivity record) {
        return MyBatis3Utils.insert(this::insert, record, userActivity, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(activityId).toPropertyWhenPresent("activityId", record::getActivityId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    default Optional<UserActivity> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    default List<UserActivity> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    default List<UserActivity> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    default Optional<UserActivity> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4780035+08:00", comments="Source Table: user_activity")
    static UpdateDSL<UpdateModel> updateAllColumns(UserActivity record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(activityId).equalTo(record::getActivityId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4790015+08:00", comments="Source Table: user_activity")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserActivity record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(activityId).equalToWhenPresent(record::getActivityId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4790015+08:00", comments="Source Table: user_activity")
    default int updateByPrimaryKey(UserActivity record) {
        return update(c ->
            c.set(userId).equalTo(record::getUserId)
            .set(activityId).equalTo(record::getActivityId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4790015+08:00", comments="Source Table: user_activity")
    default int updateByPrimaryKeySelective(UserActivity record) {
        return update(c ->
            c.set(userId).equalToWhenPresent(record::getUserId)
            .set(activityId).equalToWhenPresent(record::getActivityId)
            .where(id, isEqualTo(record::getId))
        );
    }
}