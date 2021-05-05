package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.AdminDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.Admin;
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
public interface AdminMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0768851+08:00", comments="Source Table: admin")
    BasicColumn[] selectList = BasicColumn.columnList(name, password);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0748865+08:00", comments="Source Table: admin")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0758895+08:00", comments="Source Table: admin")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0758895+08:00", comments="Source Table: admin")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.name")
    int insert(InsertStatementProvider<Admin> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0758895+08:00", comments="Source Table: admin")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.name")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Admin> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0758895+08:00", comments="Source Table: admin")
    default int insertMultiple(MultiRowInsertStatementProvider<Admin> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0758895+08:00", comments="Source Table: admin")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AdminResult")
    Optional<Admin> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0758895+08:00", comments="Source Table: admin")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AdminResult", value = {
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR)
    })
    List<Admin> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0758895+08:00", comments="Source Table: admin")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0758895+08:00", comments="Source Table: admin")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0758895+08:00", comments="Source Table: admin")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0768851+08:00", comments="Source Table: admin")
    default int deleteByPrimaryKey(String name_) {
        return delete(c -> 
            c.where(name, isEqualTo(name_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0768851+08:00", comments="Source Table: admin")
    default int insert(Admin record) {
        return MyBatis3Utils.insert(this::insert, record, admin, c ->
            c.map(password).toProperty("password")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0768851+08:00", comments="Source Table: admin")
    default int insertMultiple(Collection<Admin> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, admin, c ->
            c.map(password).toProperty("password")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0768851+08:00", comments="Source Table: admin")
    default int insertSelective(Admin record) {
        return MyBatis3Utils.insert(this::insert, record, admin, c ->
            c.map(password).toPropertyWhenPresent("password", record::getPassword)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0768851+08:00", comments="Source Table: admin")
    default Optional<Admin> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0768851+08:00", comments="Source Table: admin")
    default List<Admin> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0768851+08:00", comments="Source Table: admin")
    default List<Admin> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0768851+08:00", comments="Source Table: admin")
    default Optional<Admin> selectByPrimaryKey(String name_) {
        return selectOne(c ->
            c.where(name, isEqualTo(name_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0768851+08:00", comments="Source Table: admin")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, admin, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0778785+08:00", comments="Source Table: admin")
    static UpdateDSL<UpdateModel> updateAllColumns(Admin record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(password).equalTo(record::getPassword);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0778785+08:00", comments="Source Table: admin")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Admin record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(password).equalToWhenPresent(record::getPassword);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0778785+08:00", comments="Source Table: admin")
    default int updateByPrimaryKey(Admin record) {
        return update(c ->
            c.set(password).equalTo(record::getPassword)
            .where(name, isEqualTo(record::getName))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-05T22:09:55.0778785+08:00", comments="Source Table: admin")
    default int updateByPrimaryKeySelective(Admin record) {
        return update(c ->
            c.set(password).equalToWhenPresent(record::getPassword)
            .where(name, isEqualTo(record::getName))
        );
    }
}