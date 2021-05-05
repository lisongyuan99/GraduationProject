package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.CustomerVoteDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.CustomerVote;
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
public interface CustomerVoteMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0968299+08:00", comments="Source Table: customer_vote")
    BasicColumn[] selectList = BasicColumn.columnList(id, customerId, activityId, type);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0948334+08:00", comments="Source Table: customer_vote")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0948334+08:00", comments="Source Table: customer_vote")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0948334+08:00", comments="Source Table: customer_vote")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<CustomerVote> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0948334+08:00", comments="Source Table: customer_vote")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<CustomerVote> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0948334+08:00", comments="Source Table: customer_vote")
    default int insertMultiple(MultiRowInsertStatementProvider<CustomerVote> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0948334+08:00", comments="Source Table: customer_vote")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CustomerVoteResult")
    Optional<CustomerVote> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0958309+08:00", comments="Source Table: customer_vote")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CustomerVoteResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT)
    })
    List<CustomerVote> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0958309+08:00", comments="Source Table: customer_vote")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0958309+08:00", comments="Source Table: customer_vote")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, customerVote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0958309+08:00", comments="Source Table: customer_vote")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, customerVote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0958309+08:00", comments="Source Table: customer_vote")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0958309+08:00", comments="Source Table: customer_vote")
    default int insert(CustomerVote record) {
        return MyBatis3Utils.insert(this::insert, record, customerVote, c ->
            c.map(customerId).toProperty("customerId")
            .map(activityId).toProperty("activityId")
            .map(type).toProperty("type")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0968299+08:00", comments="Source Table: customer_vote")
    default int insertMultiple(Collection<CustomerVote> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, customerVote, c ->
            c.map(customerId).toProperty("customerId")
            .map(activityId).toProperty("activityId")
            .map(type).toProperty("type")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0968299+08:00", comments="Source Table: customer_vote")
    default int insertSelective(CustomerVote record) {
        return MyBatis3Utils.insert(this::insert, record, customerVote, c ->
            c.map(customerId).toPropertyWhenPresent("customerId", record::getCustomerId)
            .map(activityId).toPropertyWhenPresent("activityId", record::getActivityId)
            .map(type).toPropertyWhenPresent("type", record::getType)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0968299+08:00", comments="Source Table: customer_vote")
    default Optional<CustomerVote> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, customerVote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0968299+08:00", comments="Source Table: customer_vote")
    default List<CustomerVote> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, customerVote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0968299+08:00", comments="Source Table: customer_vote")
    default List<CustomerVote> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, customerVote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0968299+08:00", comments="Source Table: customer_vote")
    default Optional<CustomerVote> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0968299+08:00", comments="Source Table: customer_vote")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, customerVote, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0978261+08:00", comments="Source Table: customer_vote")
    static UpdateDSL<UpdateModel> updateAllColumns(CustomerVote record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(customerId).equalTo(record::getCustomerId)
                .set(activityId).equalTo(record::getActivityId)
                .set(type).equalTo(record::getType);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0978261+08:00", comments="Source Table: customer_vote")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CustomerVote record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(customerId).equalToWhenPresent(record::getCustomerId)
                .set(activityId).equalToWhenPresent(record::getActivityId)
                .set(type).equalToWhenPresent(record::getType);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0978261+08:00", comments="Source Table: customer_vote")
    default int updateByPrimaryKey(CustomerVote record) {
        return update(c ->
            c.set(customerId).equalTo(record::getCustomerId)
            .set(activityId).equalTo(record::getActivityId)
            .set(type).equalTo(record::getType)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0978261+08:00", comments="Source Table: customer_vote")
    default int updateByPrimaryKeySelective(CustomerVote record) {
        return update(c ->
            c.set(customerId).equalToWhenPresent(record::getCustomerId)
            .set(activityId).equalToWhenPresent(record::getActivityId)
            .set(type).equalToWhenPresent(record::getType)
            .where(id, isEqualTo(record::getId))
        );
    }
}