package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ActivityFollowDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.ActivityFollow;
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
public interface ActivityFollowMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2661344+08:00", comments="Source Table: activity_follow")
    BasicColumn[] selectList = BasicColumn.columnList(id, activityId, customerId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<ActivityFollow> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ActivityFollow> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    default int insertMultiple(MultiRowInsertStatementProvider<ActivityFollow> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ActivityFollowResult")
    Optional<ActivityFollow> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ActivityFollowResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER)
    })
    List<ActivityFollow> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, activityFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, activityFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.265137+08:00", comments="Source Table: activity_follow")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2661344+08:00", comments="Source Table: activity_follow")
    default int insert(ActivityFollow record) {
        return MyBatis3Utils.insert(this::insert, record, activityFollow, c ->
            c.map(activityId).toProperty("activityId")
            .map(customerId).toProperty("customerId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2661344+08:00", comments="Source Table: activity_follow")
    default int insertMultiple(Collection<ActivityFollow> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, activityFollow, c ->
            c.map(activityId).toProperty("activityId")
            .map(customerId).toProperty("customerId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2661344+08:00", comments="Source Table: activity_follow")
    default int insertSelective(ActivityFollow record) {
        return MyBatis3Utils.insert(this::insert, record, activityFollow, c ->
            c.map(activityId).toPropertyWhenPresent("activityId", record::getActivityId)
            .map(customerId).toPropertyWhenPresent("customerId", record::getCustomerId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2661344+08:00", comments="Source Table: activity_follow")
    default Optional<ActivityFollow> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, activityFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2661344+08:00", comments="Source Table: activity_follow")
    default List<ActivityFollow> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, activityFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2661344+08:00", comments="Source Table: activity_follow")
    default List<ActivityFollow> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, activityFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2661344+08:00", comments="Source Table: activity_follow")
    default Optional<ActivityFollow> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2661344+08:00", comments="Source Table: activity_follow")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, activityFollow, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.2661344+08:00", comments="Source Table: activity_follow")
    static UpdateDSL<UpdateModel> updateAllColumns(ActivityFollow record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(activityId).equalTo(record::getActivityId)
                .set(customerId).equalTo(record::getCustomerId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.267135+08:00", comments="Source Table: activity_follow")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ActivityFollow record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(activityId).equalToWhenPresent(record::getActivityId)
                .set(customerId).equalToWhenPresent(record::getCustomerId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.267135+08:00", comments="Source Table: activity_follow")
    default int updateByPrimaryKey(ActivityFollow record) {
        return update(c ->
            c.set(activityId).equalTo(record::getActivityId)
            .set(customerId).equalTo(record::getCustomerId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-30T19:11:00.267135+08:00", comments="Source Table: activity_follow")
    default int updateByPrimaryKeySelective(ActivityFollow record) {
        return update(c ->
            c.set(activityId).equalToWhenPresent(record::getActivityId)
            .set(customerId).equalToWhenPresent(record::getCustomerId)
            .where(id, isEqualTo(record::getId))
        );
    }
}