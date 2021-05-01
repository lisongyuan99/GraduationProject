package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.OrderInfoDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.OrderInfo;
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
public interface OrderInfoMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    BasicColumn[] selectList = BasicColumn.columnList(id, customerId, status, price, createTime, payTime, refundTime, count, activityId, useTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<OrderInfo> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<OrderInfo> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default int insertMultiple(MultiRowInsertStatementProvider<OrderInfo> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrderInfoResult")
    Optional<OrderInfo> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrderInfoResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER),
        @Result(column="use_time", property="useTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderInfo> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default int insert(OrderInfo record) {
        return MyBatis3Utils.insert(this::insert, record, orderInfo, c ->
            c.map(customerId).toProperty("customerId")
            .map(status).toProperty("status")
            .map(price).toProperty("price")
            .map(createTime).toProperty("createTime")
            .map(payTime).toProperty("payTime")
            .map(refundTime).toProperty("refundTime")
            .map(count).toProperty("count")
            .map(activityId).toProperty("activityId")
            .map(useTime).toProperty("useTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default int insertMultiple(Collection<OrderInfo> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, orderInfo, c ->
            c.map(customerId).toProperty("customerId")
            .map(status).toProperty("status")
            .map(price).toProperty("price")
            .map(createTime).toProperty("createTime")
            .map(payTime).toProperty("payTime")
            .map(refundTime).toProperty("refundTime")
            .map(count).toProperty("count")
            .map(activityId).toProperty("activityId")
            .map(useTime).toProperty("useTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default int insertSelective(OrderInfo record) {
        return MyBatis3Utils.insert(this::insert, record, orderInfo, c ->
            c.map(customerId).toPropertyWhenPresent("customerId", record::getCustomerId)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(payTime).toPropertyWhenPresent("payTime", record::getPayTime)
            .map(refundTime).toPropertyWhenPresent("refundTime", record::getRefundTime)
            .map(count).toPropertyWhenPresent("count", record::getCount)
            .map(activityId).toPropertyWhenPresent("activityId", record::getActivityId)
            .map(useTime).toPropertyWhenPresent("useTime", record::getUseTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default Optional<OrderInfo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default List<OrderInfo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default List<OrderInfo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default Optional<OrderInfo> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, orderInfo, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    static UpdateDSL<UpdateModel> updateAllColumns(OrderInfo record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(customerId).equalTo(record::getCustomerId)
                .set(status).equalTo(record::getStatus)
                .set(price).equalTo(record::getPrice)
                .set(createTime).equalTo(record::getCreateTime)
                .set(payTime).equalTo(record::getPayTime)
                .set(refundTime).equalTo(record::getRefundTime)
                .set(count).equalTo(record::getCount)
                .set(activityId).equalTo(record::getActivityId)
                .set(useTime).equalTo(record::getUseTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(OrderInfo record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(customerId).equalToWhenPresent(record::getCustomerId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(payTime).equalToWhenPresent(record::getPayTime)
                .set(refundTime).equalToWhenPresent(record::getRefundTime)
                .set(count).equalToWhenPresent(record::getCount)
                .set(activityId).equalToWhenPresent(record::getActivityId)
                .set(useTime).equalToWhenPresent(record::getUseTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default int updateByPrimaryKey(OrderInfo record) {
        return update(c ->
            c.set(customerId).equalTo(record::getCustomerId)
            .set(status).equalTo(record::getStatus)
            .set(price).equalTo(record::getPrice)
            .set(createTime).equalTo(record::getCreateTime)
            .set(payTime).equalTo(record::getPayTime)
            .set(refundTime).equalTo(record::getRefundTime)
            .set(count).equalTo(record::getCount)
            .set(activityId).equalTo(record::getActivityId)
            .set(useTime).equalTo(record::getUseTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-01T21:34:26.6724282+08:00", comments="Source Table: order_info")
    default int updateByPrimaryKeySelective(OrderInfo record) {
        return update(c ->
            c.set(customerId).equalToWhenPresent(record::getCustomerId)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(payTime).equalToWhenPresent(record::getPayTime)
            .set(refundTime).equalToWhenPresent(record::getRefundTime)
            .set(count).equalToWhenPresent(record::getCount)
            .set(activityId).equalToWhenPresent(record::getActivityId)
            .set(useTime).equalToWhenPresent(record::getUseTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}