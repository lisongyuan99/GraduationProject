package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.CartDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.Cart;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
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
public interface CartMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    BasicColumn[] selectList = BasicColumn.columnList(customerId, details);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8169027+08:00", comments="Source Table: cart")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8169027+08:00", comments="Source Table: cart")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8169027+08:00", comments="Source Table: cart")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Cart> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8169027+08:00", comments="Source Table: cart")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Cart> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8169027+08:00", comments="Source Table: cart")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CartResult")
    Optional<Cart> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8169027+08:00", comments="Source Table: cart")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CartResult", value = {
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="details", property="details", jdbcType=JdbcType.OTHER)
    })
    List<Cart> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default int deleteByPrimaryKey(Integer customerId_) {
        return delete(c -> 
            c.where(customerId, isEqualTo(customerId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default int insert(Cart record) {
        return MyBatis3Utils.insert(this::insert, record, cart, c ->
            c.map(customerId).toProperty("customerId")
            .map(details).toProperty("details")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default int insertMultiple(Collection<Cart> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, cart, c ->
            c.map(customerId).toProperty("customerId")
            .map(details).toProperty("details")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default int insertSelective(Cart record) {
        return MyBatis3Utils.insert(this::insert, record, cart, c ->
            c.map(customerId).toPropertyWhenPresent("customerId", record::getCustomerId)
            .map(details).toPropertyWhenPresent("details", record::getDetails)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default Optional<Cart> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default List<Cart> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default List<Cart> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default Optional<Cart> selectByPrimaryKey(Integer customerId_) {
        return selectOne(c ->
            c.where(customerId, isEqualTo(customerId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, cart, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    static UpdateDSL<UpdateModel> updateAllColumns(Cart record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(customerId).equalTo(record::getCustomerId)
                .set(details).equalTo(record::getDetails);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Cart record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(customerId).equalToWhenPresent(record::getCustomerId)
                .set(details).equalToWhenPresent(record::getDetails);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8179004+08:00", comments="Source Table: cart")
    default int updateByPrimaryKey(Cart record) {
        return update(c ->
            c.set(details).equalTo(record::getDetails)
            .where(customerId, isEqualTo(record::getCustomerId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8188973+08:00", comments="Source Table: cart")
    default int updateByPrimaryKeySelective(Cart record) {
        return update(c ->
            c.set(details).equalToWhenPresent(record::getDetails)
            .where(customerId, isEqualTo(record::getCustomerId))
        );
    }
}