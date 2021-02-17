package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ActivityVisitsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.ActivityVisits;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
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
public interface ActivityVisitsMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    BasicColumn[] selectList = BasicColumn.columnList(activityId, visits);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ActivityVisits> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    @Insert({
        "${insertStatement}"
    })
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ActivityVisits> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default int insertMultiple(MultiRowInsertStatementProvider<ActivityVisits> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ActivityVisitsResult")
    Optional<ActivityVisits> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ActivityVisitsResult", value = {
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="visits", property="visits", jdbcType=JdbcType.ARRAY)
    })
    List<ActivityVisits> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, activityVisits, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, activityVisits, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default int deleteByPrimaryKey(Integer activityId_) {
        return delete(c -> 
            c.where(activityId, isEqualTo(activityId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default int insert(ActivityVisits record) {
        return MyBatis3Utils.insert(this::insert, record, activityVisits, c ->
            c.map(activityId).toProperty("activityId")
            .map(visits).toProperty("visits")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default int insertMultiple(Collection<ActivityVisits> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, activityVisits, c ->
            c.map(activityId).toProperty("activityId")
            .map(visits).toProperty("visits")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default int insertSelective(ActivityVisits record) {
        return MyBatis3Utils.insert(this::insert, record, activityVisits, c ->
            c.map(activityId).toPropertyWhenPresent("activityId", record::getActivityId)
            .map(visits).toPropertyWhenPresent("visits", record::getVisits)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default Optional<ActivityVisits> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, activityVisits, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default List<ActivityVisits> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, activityVisits, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default List<ActivityVisits> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, activityVisits, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default Optional<ActivityVisits> selectByPrimaryKey(Integer activityId_) {
        return selectOne(c ->
            c.where(activityId, isEqualTo(activityId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, activityVisits, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    static UpdateDSL<UpdateModel> updateAllColumns(ActivityVisits record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(activityId).equalTo(record::getActivityId)
                .set(visits).equalTo(record::getVisits);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ActivityVisits record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(activityId).equalToWhenPresent(record::getActivityId)
                .set(visits).equalToWhenPresent(record::getVisits);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default int updateByPrimaryKey(ActivityVisits record) {
        return update(c ->
            c.set(visits).equalTo(record::getVisits)
            .where(activityId, isEqualTo(record::getActivityId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.5105011+08:00", comments="Source Table: activity_visits")
    default int updateByPrimaryKeySelective(ActivityVisits record) {
        return update(c ->
            c.set(visits).equalToWhenPresent(record::getVisits)
            .where(activityId, isEqualTo(record::getActivityId))
        );
    }
}