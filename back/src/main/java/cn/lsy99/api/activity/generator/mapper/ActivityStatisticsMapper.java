package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ActivityStatisticsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.ActivityStatistics;
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
public interface ActivityStatisticsMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    BasicColumn[] selectList = BasicColumn.columnList(activityId, visits, organizerId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ActivityStatistics> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ActivityStatistics> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ActivityStatisticsResult")
    Optional<ActivityStatistics> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ActivityStatisticsResult", value = {
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="visits", property="visits", jdbcType=JdbcType.VARCHAR),
        @Result(column="organizer_id", property="organizerId", jdbcType=JdbcType.INTEGER)
    })
    List<ActivityStatistics> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, activityStatistics, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, activityStatistics, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default int deleteByPrimaryKey(Integer activityId_) {
        return delete(c -> 
            c.where(activityId, isEqualTo(activityId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default int insert(ActivityStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, activityStatistics, c ->
            c.map(activityId).toProperty("activityId")
            .map(visits).toProperty("visits")
            .map(organizerId).toProperty("organizerId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default int insertMultiple(Collection<ActivityStatistics> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, activityStatistics, c ->
            c.map(activityId).toProperty("activityId")
            .map(visits).toProperty("visits")
            .map(organizerId).toProperty("organizerId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default int insertSelective(ActivityStatistics record) {
        return MyBatis3Utils.insert(this::insert, record, activityStatistics, c ->
            c.map(activityId).toPropertyWhenPresent("activityId", record::getActivityId)
            .map(visits).toPropertyWhenPresent("visits", record::getVisits)
            .map(organizerId).toPropertyWhenPresent("organizerId", record::getOrganizerId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default Optional<ActivityStatistics> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, activityStatistics, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default List<ActivityStatistics> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, activityStatistics, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default List<ActivityStatistics> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, activityStatistics, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default Optional<ActivityStatistics> selectByPrimaryKey(Integer activityId_) {
        return selectOne(c ->
            c.where(activityId, isEqualTo(activityId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, activityStatistics, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    static UpdateDSL<UpdateModel> updateAllColumns(ActivityStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(activityId).equalTo(record::getActivityId)
                .set(visits).equalTo(record::getVisits)
                .set(organizerId).equalTo(record::getOrganizerId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ActivityStatistics record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(activityId).equalToWhenPresent(record::getActivityId)
                .set(visits).equalToWhenPresent(record::getVisits)
                .set(organizerId).equalToWhenPresent(record::getOrganizerId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default int updateByPrimaryKey(ActivityStatistics record) {
        return update(c ->
            c.set(visits).equalTo(record::getVisits)
            .set(organizerId).equalTo(record::getOrganizerId)
            .where(activityId, isEqualTo(record::getActivityId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source Table: activity_statistics")
    default int updateByPrimaryKeySelective(ActivityStatistics record) {
        return update(c ->
            c.set(visits).equalToWhenPresent(record::getVisits)
            .set(organizerId).equalToWhenPresent(record::getOrganizerId)
            .where(activityId, isEqualTo(record::getActivityId))
        );
    }
}