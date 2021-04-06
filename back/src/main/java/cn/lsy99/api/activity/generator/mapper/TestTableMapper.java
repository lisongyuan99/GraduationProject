package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.TestTableDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.handler.ArrayTypeHandler;
import cn.lsy99.api.activity.generator.table.TestTable;
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
public interface TestTableMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    BasicColumn[] selectList = BasicColumn.columnList(id, lat, lng, position, ids, strings);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6216951+08:00", comments="Source Table: test_table")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6216951+08:00", comments="Source Table: test_table")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<TestTable> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<TestTable> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    default int insertMultiple(MultiRowInsertStatementProvider<TestTable> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TestTableResult")
    Optional<TestTable> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TestTableResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="lat", property="lat", jdbcType=JdbcType.DOUBLE),
        @Result(column="lng", property="lng", jdbcType=JdbcType.DOUBLE),
        @Result(column="position", property="position", jdbcType=JdbcType.OTHER),
        @Result(column="ids", property="ids", jdbcType=JdbcType.ARRAY),
        @Result(column="strings", property="strings", typeHandler=ArrayTypeHandler.class, jdbcType=JdbcType.ARRAY)
    })
    List<TestTable> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, testTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, testTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    default int insert(TestTable record) {
        return MyBatis3Utils.insert(this::insert, record, testTable, c ->
            c.map(lat).toProperty("lat")
            .map(lng).toProperty("lng")
            .map(position).toProperty("position")
            .map(ids).toProperty("ids")
            .map(strings).toProperty("strings")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    default int insertMultiple(Collection<TestTable> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, testTable, c ->
            c.map(lat).toProperty("lat")
            .map(lng).toProperty("lng")
            .map(position).toProperty("position")
            .map(ids).toProperty("ids")
            .map(strings).toProperty("strings")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    default int insertSelective(TestTable record) {
        return MyBatis3Utils.insert(this::insert, record, testTable, c ->
            c.map(lat).toPropertyWhenPresent("lat", record::getLat)
            .map(lng).toPropertyWhenPresent("lng", record::getLng)
            .map(position).toPropertyWhenPresent("position", record::getPosition)
            .map(ids).toPropertyWhenPresent("ids", record::getIds)
            .map(strings).toPropertyWhenPresent("strings", record::getStrings)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    default Optional<TestTable> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, testTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6226925+08:00", comments="Source Table: test_table")
    default List<TestTable> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, testTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6236895+08:00", comments="Source Table: test_table")
    default List<TestTable> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, testTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6236895+08:00", comments="Source Table: test_table")
    default Optional<TestTable> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6236895+08:00", comments="Source Table: test_table")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, testTable, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6236895+08:00", comments="Source Table: test_table")
    static UpdateDSL<UpdateModel> updateAllColumns(TestTable record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(lat).equalTo(record::getLat)
                .set(lng).equalTo(record::getLng)
                .set(position).equalTo(record::getPosition)
                .set(ids).equalTo(record::getIds)
                .set(strings).equalTo(record::getStrings);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6236895+08:00", comments="Source Table: test_table")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TestTable record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(lat).equalToWhenPresent(record::getLat)
                .set(lng).equalToWhenPresent(record::getLng)
                .set(position).equalToWhenPresent(record::getPosition)
                .set(ids).equalToWhenPresent(record::getIds)
                .set(strings).equalToWhenPresent(record::getStrings);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6236895+08:00", comments="Source Table: test_table")
    default int updateByPrimaryKey(TestTable record) {
        return update(c ->
            c.set(lat).equalTo(record::getLat)
            .set(lng).equalTo(record::getLng)
            .set(position).equalTo(record::getPosition)
            .set(ids).equalTo(record::getIds)
            .set(strings).equalTo(record::getStrings)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6236895+08:00", comments="Source Table: test_table")
    default int updateByPrimaryKeySelective(TestTable record) {
        return update(c ->
            c.set(lat).equalToWhenPresent(record::getLat)
            .set(lng).equalToWhenPresent(record::getLng)
            .set(position).equalToWhenPresent(record::getPosition)
            .set(ids).equalToWhenPresent(record::getIds)
            .set(strings).equalToWhenPresent(record::getStrings)
            .where(id, isEqualTo(record::getId))
        );
    }
}