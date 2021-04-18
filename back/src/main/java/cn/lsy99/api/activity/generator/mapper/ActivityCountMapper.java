package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ActivityCountDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.ActivityCount;
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
public interface ActivityCountMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    BasicColumn[] selectList = BasicColumn.columnList(activityId, count);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8089243+08:00", comments="Source Table: activity_count")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8089243+08:00", comments="Source Table: activity_count")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8089243+08:00", comments="Source Table: activity_count")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ActivityCount> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8089243+08:00", comments="Source Table: activity_count")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ActivityCount> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ActivityCountResult")
    Optional<ActivityCount> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ActivityCountResult", value = {
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER)
    })
    List<ActivityCount> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, activityCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, activityCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    default int deleteByPrimaryKey(Integer activityId_) {
        return delete(c -> 
            c.where(activityId, isEqualTo(activityId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    default int insert(ActivityCount record) {
        return MyBatis3Utils.insert(this::insert, record, activityCount, c ->
            c.map(activityId).toProperty("activityId")
            .map(count).toProperty("count")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    default int insertMultiple(Collection<ActivityCount> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, activityCount, c ->
            c.map(activityId).toProperty("activityId")
            .map(count).toProperty("count")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    default int insertSelective(ActivityCount record) {
        return MyBatis3Utils.insert(this::insert, record, activityCount, c ->
            c.map(activityId).toPropertyWhenPresent("activityId", record::getActivityId)
            .map(count).toPropertyWhenPresent("count", record::getCount)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    default Optional<ActivityCount> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, activityCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8129138+08:00", comments="Source Table: activity_count")
    default List<ActivityCount> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, activityCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source Table: activity_count")
    default List<ActivityCount> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, activityCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source Table: activity_count")
    default Optional<ActivityCount> selectByPrimaryKey(Integer activityId_) {
        return selectOne(c ->
            c.where(activityId, isEqualTo(activityId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source Table: activity_count")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, activityCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source Table: activity_count")
    static UpdateDSL<UpdateModel> updateAllColumns(ActivityCount record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(activityId).equalTo(record::getActivityId)
                .set(count).equalTo(record::getCount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source Table: activity_count")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ActivityCount record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(activityId).equalToWhenPresent(record::getActivityId)
                .set(count).equalToWhenPresent(record::getCount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source Table: activity_count")
    default int updateByPrimaryKey(ActivityCount record) {
        return update(c ->
            c.set(count).equalTo(record::getCount)
            .where(activityId, isEqualTo(record::getActivityId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8139108+08:00", comments="Source Table: activity_count")
    default int updateByPrimaryKeySelective(ActivityCount record) {
        return update(c ->
            c.set(count).equalToWhenPresent(record::getCount)
            .where(activityId, isEqualTo(record::getActivityId))
        );
    }
}