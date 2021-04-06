package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.CategoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.Category;
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
public interface CategoryMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    BasicColumn[] selectList = BasicColumn.columnList(id, name);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6117214+08:00", comments="Source Table: category")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6117214+08:00", comments="Source Table: category")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6117214+08:00", comments="Source Table: category")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Category> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Category> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default int insertMultiple(MultiRowInsertStatementProvider<Category> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CategoryResult")
    Optional<Category> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CategoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Category> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, category, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, category, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default int insert(Category record) {
        return MyBatis3Utils.insert(this::insert, record, category, c ->
            c.map(name).toProperty("name")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default int insertMultiple(Collection<Category> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, category, c ->
            c.map(name).toProperty("name")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default int insertSelective(Category record) {
        return MyBatis3Utils.insert(this::insert, record, category, c ->
            c.map(name).toPropertyWhenPresent("name", record::getName)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default Optional<Category> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, category, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default List<Category> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, category, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default List<Category> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, category, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6127187+08:00", comments="Source Table: category")
    default Optional<Category> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6137161+08:00", comments="Source Table: category")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, category, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6137161+08:00", comments="Source Table: category")
    static UpdateDSL<UpdateModel> updateAllColumns(Category record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(record::getName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6137161+08:00", comments="Source Table: category")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Category record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(record::getName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6137161+08:00", comments="Source Table: category")
    default int updateByPrimaryKey(Category record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-06T16:14:28.6137161+08:00", comments="Source Table: category")
    default int updateByPrimaryKeySelective(Category record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .where(id, isEqualTo(record::getId))
        );
    }
}