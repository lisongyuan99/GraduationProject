package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.OrganizerCustomerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.OrganizerCustomer;
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
public interface OrganizerCustomerMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    BasicColumn[] selectList = BasicColumn.columnList(id, organizerId, customerId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.415724+08:00", comments="Source Table: organizer_customer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.415724+08:00", comments="Source Table: organizer_customer")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.415724+08:00", comments="Source Table: organizer_customer")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<OrganizerCustomer> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.415724+08:00", comments="Source Table: organizer_customer")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<OrganizerCustomer> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.415724+08:00", comments="Source Table: organizer_customer")
    default int insertMultiple(MultiRowInsertStatementProvider<OrganizerCustomer> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.415724+08:00", comments="Source Table: organizer_customer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrganizerCustomerResult")
    Optional<OrganizerCustomer> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.415724+08:00", comments="Source Table: organizer_customer")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrganizerCustomerResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="organizer_id", property="organizerId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER)
    })
    List<OrganizerCustomer> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.415724+08:00", comments="Source Table: organizer_customer")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, organizerCustomer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, organizerCustomer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default int insert(OrganizerCustomer record) {
        return MyBatis3Utils.insert(this::insert, record, organizerCustomer, c ->
            c.map(organizerId).toProperty("organizerId")
            .map(customerId).toProperty("customerId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default int insertMultiple(Collection<OrganizerCustomer> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, organizerCustomer, c ->
            c.map(organizerId).toProperty("organizerId")
            .map(customerId).toProperty("customerId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default int insertSelective(OrganizerCustomer record) {
        return MyBatis3Utils.insert(this::insert, record, organizerCustomer, c ->
            c.map(organizerId).toPropertyWhenPresent("organizerId", record::getOrganizerId)
            .map(customerId).toPropertyWhenPresent("customerId", record::getCustomerId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default Optional<OrganizerCustomer> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, organizerCustomer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default List<OrganizerCustomer> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, organizerCustomer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default List<OrganizerCustomer> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, organizerCustomer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default Optional<OrganizerCustomer> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, organizerCustomer, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    static UpdateDSL<UpdateModel> updateAllColumns(OrganizerCustomer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(organizerId).equalTo(record::getOrganizerId)
                .set(customerId).equalTo(record::getCustomerId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(OrganizerCustomer record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(organizerId).equalToWhenPresent(record::getOrganizerId)
                .set(customerId).equalToWhenPresent(record::getCustomerId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4167213+08:00", comments="Source Table: organizer_customer")
    default int updateByPrimaryKey(OrganizerCustomer record) {
        return update(c ->
            c.set(organizerId).equalTo(record::getOrganizerId)
            .set(customerId).equalTo(record::getCustomerId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-01T11:04:41.4177186+08:00", comments="Source Table: organizer_customer")
    default int updateByPrimaryKeySelective(OrganizerCustomer record) {
        return update(c ->
            c.set(organizerId).equalToWhenPresent(record::getOrganizerId)
            .set(customerId).equalToWhenPresent(record::getCustomerId)
            .where(id, isEqualTo(record::getId))
        );
    }
}