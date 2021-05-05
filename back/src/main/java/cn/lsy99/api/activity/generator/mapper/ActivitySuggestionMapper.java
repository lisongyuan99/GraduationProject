package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ActivitySuggestionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.ActivitySuggestion;
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
public interface ActivitySuggestionMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1447002+08:00", comments="Source Table: activity_suggestion")
    BasicColumn[] selectList = BasicColumn.columnList(id, activityId, price, addTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1397137+08:00", comments="Source Table: activity_suggestion")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1397137+08:00", comments="Source Table: activity_suggestion")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1397137+08:00", comments="Source Table: activity_suggestion")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<ActivitySuggestion> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1397137+08:00", comments="Source Table: activity_suggestion")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<ActivitySuggestion> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1397137+08:00", comments="Source Table: activity_suggestion")
    default int insertMultiple(MultiRowInsertStatementProvider<ActivitySuggestion> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.143704+08:00", comments="Source Table: activity_suggestion")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ActivitySuggestionResult")
    Optional<ActivitySuggestion> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.143704+08:00", comments="Source Table: activity_suggestion")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ActivitySuggestionResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ActivitySuggestion> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.143704+08:00", comments="Source Table: activity_suggestion")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.143704+08:00", comments="Source Table: activity_suggestion")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, activitySuggestion, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.143704+08:00", comments="Source Table: activity_suggestion")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, activitySuggestion, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.143704+08:00", comments="Source Table: activity_suggestion")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.143704+08:00", comments="Source Table: activity_suggestion")
    default int insert(ActivitySuggestion record) {
        return MyBatis3Utils.insert(this::insert, record, activitySuggestion, c ->
            c.map(activityId).toProperty("activityId")
            .map(price).toProperty("price")
            .map(addTime).toProperty("addTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1447002+08:00", comments="Source Table: activity_suggestion")
    default int insertMultiple(Collection<ActivitySuggestion> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, activitySuggestion, c ->
            c.map(activityId).toProperty("activityId")
            .map(price).toProperty("price")
            .map(addTime).toProperty("addTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1447002+08:00", comments="Source Table: activity_suggestion")
    default int insertSelective(ActivitySuggestion record) {
        return MyBatis3Utils.insert(this::insert, record, activitySuggestion, c ->
            c.map(activityId).toPropertyWhenPresent("activityId", record::getActivityId)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(addTime).toPropertyWhenPresent("addTime", record::getAddTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1447002+08:00", comments="Source Table: activity_suggestion")
    default Optional<ActivitySuggestion> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, activitySuggestion, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1447002+08:00", comments="Source Table: activity_suggestion")
    default List<ActivitySuggestion> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, activitySuggestion, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1447002+08:00", comments="Source Table: activity_suggestion")
    default List<ActivitySuggestion> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, activitySuggestion, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1447002+08:00", comments="Source Table: activity_suggestion")
    default Optional<ActivitySuggestion> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1447002+08:00", comments="Source Table: activity_suggestion")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, activitySuggestion, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1447002+08:00", comments="Source Table: activity_suggestion")
    static UpdateDSL<UpdateModel> updateAllColumns(ActivitySuggestion record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(activityId).equalTo(record::getActivityId)
                .set(price).equalTo(record::getPrice)
                .set(addTime).equalTo(record::getAddTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1447002+08:00", comments="Source Table: activity_suggestion")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ActivitySuggestion record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(activityId).equalToWhenPresent(record::getActivityId)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(addTime).equalToWhenPresent(record::getAddTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1456977+08:00", comments="Source Table: activity_suggestion")
    default int updateByPrimaryKey(ActivitySuggestion record) {
        return update(c ->
            c.set(activityId).equalTo(record::getActivityId)
            .set(price).equalTo(record::getPrice)
            .set(addTime).equalTo(record::getAddTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1456977+08:00", comments="Source Table: activity_suggestion")
    default int updateByPrimaryKeySelective(ActivitySuggestion record) {
        return update(c ->
            c.set(activityId).equalToWhenPresent(record::getActivityId)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(addTime).equalToWhenPresent(record::getAddTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}