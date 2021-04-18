package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ShopDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.Shop;
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
public interface ShopMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    BasicColumn[] selectList = BasicColumn.columnList(id, status, name, description, avatar, positionCode, address, lat, pos, pictures);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source Table: shop")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source Table: shop")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source Table: shop")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Shop> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source Table: shop")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Shop> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source Table: shop")
    default int insertMultiple(MultiRowInsertStatementProvider<Shop> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source Table: shop")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ShopResult")
    Optional<Shop> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8408514+08:00", comments="Source Table: shop")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ShopResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="position_code", property="positionCode", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.DOUBLE),
        @Result(column="pos", property="pos", jdbcType=JdbcType.DOUBLE),
        @Result(column="pictures", property="pictures", jdbcType=JdbcType.VARCHAR)
    })
    List<Shop> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, shop, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, shop, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default int insert(Shop record) {
        return MyBatis3Utils.insert(this::insert, record, shop, c ->
            c.map(status).toProperty("status")
            .map(name).toProperty("name")
            .map(description).toProperty("description")
            .map(avatar).toProperty("avatar")
            .map(positionCode).toProperty("positionCode")
            .map(address).toProperty("address")
            .map(lat).toProperty("lat")
            .map(pos).toProperty("pos")
            .map(pictures).toProperty("pictures")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default int insertMultiple(Collection<Shop> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, shop, c ->
            c.map(status).toProperty("status")
            .map(name).toProperty("name")
            .map(description).toProperty("description")
            .map(avatar).toProperty("avatar")
            .map(positionCode).toProperty("positionCode")
            .map(address).toProperty("address")
            .map(lat).toProperty("lat")
            .map(pos).toProperty("pos")
            .map(pictures).toProperty("pictures")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default int insertSelective(Shop record) {
        return MyBatis3Utils.insert(this::insert, record, shop, c ->
            c.map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(description).toPropertyWhenPresent("description", record::getDescription)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(positionCode).toPropertyWhenPresent("positionCode", record::getPositionCode)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(lat).toPropertyWhenPresent("lat", record::getLat)
            .map(pos).toPropertyWhenPresent("pos", record::getPos)
            .map(pictures).toPropertyWhenPresent("pictures", record::getPictures)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default Optional<Shop> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, shop, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default List<Shop> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, shop, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default List<Shop> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, shop, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default Optional<Shop> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, shop, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    static UpdateDSL<UpdateModel> updateAllColumns(Shop record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(status).equalTo(record::getStatus)
                .set(name).equalTo(record::getName)
                .set(description).equalTo(record::getDescription)
                .set(avatar).equalTo(record::getAvatar)
                .set(positionCode).equalTo(record::getPositionCode)
                .set(address).equalTo(record::getAddress)
                .set(lat).equalTo(record::getLat)
                .set(pos).equalTo(record::getPos)
                .set(pictures).equalTo(record::getPictures);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.841837+08:00", comments="Source Table: shop")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Shop record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(status).equalToWhenPresent(record::getStatus)
                .set(name).equalToWhenPresent(record::getName)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(positionCode).equalToWhenPresent(record::getPositionCode)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(lat).equalToWhenPresent(record::getLat)
                .set(pos).equalToWhenPresent(record::getPos)
                .set(pictures).equalToWhenPresent(record::getPictures);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8428379+08:00", comments="Source Table: shop")
    default int updateByPrimaryKey(Shop record) {
        return update(c ->
            c.set(status).equalTo(record::getStatus)
            .set(name).equalTo(record::getName)
            .set(description).equalTo(record::getDescription)
            .set(avatar).equalTo(record::getAvatar)
            .set(positionCode).equalTo(record::getPositionCode)
            .set(address).equalTo(record::getAddress)
            .set(lat).equalTo(record::getLat)
            .set(pos).equalTo(record::getPos)
            .set(pictures).equalTo(record::getPictures)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-17T07:58:35.8428379+08:00", comments="Source Table: shop")
    default int updateByPrimaryKeySelective(Shop record) {
        return update(c ->
            c.set(status).equalToWhenPresent(record::getStatus)
            .set(name).equalToWhenPresent(record::getName)
            .set(description).equalToWhenPresent(record::getDescription)
            .set(avatar).equalToWhenPresent(record::getAvatar)
            .set(positionCode).equalToWhenPresent(record::getPositionCode)
            .set(address).equalToWhenPresent(record::getAddress)
            .set(lat).equalToWhenPresent(record::getLat)
            .set(pos).equalToWhenPresent(record::getPos)
            .set(pictures).equalToWhenPresent(record::getPictures)
            .where(id, isEqualTo(record::getId))
        );
    }
}