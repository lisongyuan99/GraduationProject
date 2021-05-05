package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.CommentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.Comment;
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
public interface CommentMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1486897+08:00", comments="Source Table: comment")
    BasicColumn[] selectList = BasicColumn.columnList(id, customerId, activityId, text, orderId, publishTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1466955+08:00", comments="Source Table: comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1466955+08:00", comments="Source Table: comment")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Comment> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Comment> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    default int insertMultiple(MultiRowInsertStatementProvider<Comment> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CommentResult")
    Optional<Comment> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CommentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER),
        @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Comment> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    default int insert(Comment record) {
        return MyBatis3Utils.insert(this::insert, record, comment, c ->
            c.map(customerId).toProperty("customerId")
            .map(activityId).toProperty("activityId")
            .map(text).toProperty("text")
            .map(orderId).toProperty("orderId")
            .map(publishTime).toProperty("publishTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    default int insertMultiple(Collection<Comment> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, comment, c ->
            c.map(customerId).toProperty("customerId")
            .map(activityId).toProperty("activityId")
            .map(text).toProperty("text")
            .map(orderId).toProperty("orderId")
            .map(publishTime).toProperty("publishTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1476946+08:00", comments="Source Table: comment")
    default int insertSelective(Comment record) {
        return MyBatis3Utils.insert(this::insert, record, comment, c ->
            c.map(customerId).toPropertyWhenPresent("customerId", record::getCustomerId)
            .map(activityId).toPropertyWhenPresent("activityId", record::getActivityId)
            .map(text).toPropertyWhenPresent("text", record::getText)
            .map(orderId).toPropertyWhenPresent("orderId", record::getOrderId)
            .map(publishTime).toPropertyWhenPresent("publishTime", record::getPublishTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1486897+08:00", comments="Source Table: comment")
    default Optional<Comment> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1486897+08:00", comments="Source Table: comment")
    default List<Comment> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1486897+08:00", comments="Source Table: comment")
    default List<Comment> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1486897+08:00", comments="Source Table: comment")
    default Optional<Comment> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1486897+08:00", comments="Source Table: comment")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, comment, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1486897+08:00", comments="Source Table: comment")
    static UpdateDSL<UpdateModel> updateAllColumns(Comment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(customerId).equalTo(record::getCustomerId)
                .set(activityId).equalTo(record::getActivityId)
                .set(text).equalTo(record::getText)
                .set(orderId).equalTo(record::getOrderId)
                .set(publishTime).equalTo(record::getPublishTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1486897+08:00", comments="Source Table: comment")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Comment record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(customerId).equalToWhenPresent(record::getCustomerId)
                .set(activityId).equalToWhenPresent(record::getActivityId)
                .set(text).equalToWhenPresent(record::getText)
                .set(orderId).equalToWhenPresent(record::getOrderId)
                .set(publishTime).equalToWhenPresent(record::getPublishTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1486897+08:00", comments="Source Table: comment")
    default int updateByPrimaryKey(Comment record) {
        return update(c ->
            c.set(customerId).equalTo(record::getCustomerId)
            .set(activityId).equalTo(record::getActivityId)
            .set(text).equalTo(record::getText)
            .set(orderId).equalTo(record::getOrderId)
            .set(publishTime).equalTo(record::getPublishTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.1486897+08:00", comments="Source Table: comment")
    default int updateByPrimaryKeySelective(Comment record) {
        return update(c ->
            c.set(customerId).equalToWhenPresent(record::getCustomerId)
            .set(activityId).equalToWhenPresent(record::getActivityId)
            .set(text).equalToWhenPresent(record::getText)
            .set(orderId).equalToWhenPresent(record::getOrderId)
            .set(publishTime).equalToWhenPresent(record::getPublishTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}