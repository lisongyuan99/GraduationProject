package cn.lsy99.api.activity.organizer.mapper;

import static cn.lsy99.api.activity.organizer.mapper.OrganizerActivityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.organizer.table.OrganizerActivity;
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
public interface OrganizerActivityMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    BasicColumn[] selectList = BasicColumn.columnList(id, organizerId, activityId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<OrganizerActivity> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrganizerActivityResult")
    Optional<OrganizerActivity> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrganizerActivityResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="organizer_id", property="organizerId", jdbcType=JdbcType.INTEGER),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.VARCHAR)
    })
    List<OrganizerActivity> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, organizerActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, organizerActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    default int insert(OrganizerActivity record) {
        return MyBatis3Utils.insert(this::insert, record, organizerActivity, c ->
            c.map(organizerId).toProperty("organizerId")
            .map(activityId).toProperty("activityId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    default int insertSelective(OrganizerActivity record) {
        return MyBatis3Utils.insert(this::insert, record, organizerActivity, c ->
            c.map(organizerId).toPropertyWhenPresent("organizerId", record::getOrganizerId)
            .map(activityId).toPropertyWhenPresent("activityId", record::getActivityId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    default Optional<OrganizerActivity> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, organizerActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    default List<OrganizerActivity> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, organizerActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4799982+08:00", comments="Source Table: organizer_activity")
    default List<OrganizerActivity> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, organizerActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source Table: organizer_activity")
    default Optional<OrganizerActivity> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source Table: organizer_activity")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, organizerActivity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source Table: organizer_activity")
    static UpdateDSL<UpdateModel> updateAllColumns(OrganizerActivity record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(organizerId).equalTo(record::getOrganizerId)
                .set(activityId).equalTo(record::getActivityId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source Table: organizer_activity")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(OrganizerActivity record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(organizerId).equalToWhenPresent(record::getOrganizerId)
                .set(activityId).equalToWhenPresent(record::getActivityId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source Table: organizer_activity")
    default int updateByPrimaryKey(OrganizerActivity record) {
        return update(c ->
            c.set(organizerId).equalTo(record::getOrganizerId)
            .set(activityId).equalTo(record::getActivityId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-11-17T11:15:39.4809954+08:00", comments="Source Table: organizer_activity")
    default int updateByPrimaryKeySelective(OrganizerActivity record) {
        return update(c ->
            c.set(organizerId).equalToWhenPresent(record::getOrganizerId)
            .set(activityId).equalToWhenPresent(record::getActivityId)
            .where(id, isEqualTo(record::getId))
        );
    }
}