package cn.lsy99.api.activity.generator.mapper;

import static cn.lsy99.api.activity.generator.mapper.ActivityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.lsy99.api.activity.generator.table.Activity;
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
public interface ActivityMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5320493+08:00", comments="Source Table: activity")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, detail, subtitle, beginTime, shopId, categoryId, posLat, posLng, positionCode, positionDetail, pics, status, price, priceOri, free, sum, used);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5170894+08:00", comments="Source Table: activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5180864+08:00", comments="Source Table: activity")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5180864+08:00", comments="Source Table: activity")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Activity> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5200809+08:00", comments="Source Table: activity")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Activity> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5210789+08:00", comments="Source Table: activity")
    default int insertMultiple(MultiRowInsertStatementProvider<Activity> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5240711+08:00", comments="Source Table: activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ActivityResult")
    Optional<Activity> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5250726+08:00", comments="Source Table: activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ActivityResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="subtitle", property="subtitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="pos_lat", property="posLat", jdbcType=JdbcType.DOUBLE),
        @Result(column="pos_lng", property="posLng", jdbcType=JdbcType.DOUBLE),
        @Result(column="position_code", property="positionCode", jdbcType=JdbcType.INTEGER),
        @Result(column="position_detail", property="positionDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="pics", property="pics", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="price_ori", property="priceOri", jdbcType=JdbcType.DOUBLE),
        @Result(column="free", property="free", jdbcType=JdbcType.BIT),
        @Result(column="sum", property="sum", jdbcType=JdbcType.INTEGER),
        @Result(column="used", property="used", jdbcType=JdbcType.INTEGER)
    })
    List<Activity> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5260985+08:00", comments="Source Table: activity")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5270623+08:00", comments="Source Table: activity")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5270623+08:00", comments="Source Table: activity")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5270623+08:00", comments="Source Table: activity")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5280599+08:00", comments="Source Table: activity")
    default int insert(Activity record) {
        return MyBatis3Utils.insert(this::insert, record, activity, c ->
            c.map(title).toProperty("title")
            .map(detail).toProperty("detail")
            .map(subtitle).toProperty("subtitle")
            .map(beginTime).toProperty("beginTime")
            .map(shopId).toProperty("shopId")
            .map(categoryId).toProperty("categoryId")
            .map(posLat).toProperty("posLat")
            .map(posLng).toProperty("posLng")
            .map(positionCode).toProperty("positionCode")
            .map(positionDetail).toProperty("positionDetail")
            .map(pics).toProperty("pics")
            .map(status).toProperty("status")
            .map(price).toProperty("price")
            .map(priceOri).toProperty("priceOri")
            .map(free).toProperty("free")
            .map(sum).toProperty("sum")
            .map(used).toProperty("used")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5290582+08:00", comments="Source Table: activity")
    default int insertMultiple(Collection<Activity> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, activity, c ->
            c.map(title).toProperty("title")
            .map(detail).toProperty("detail")
            .map(subtitle).toProperty("subtitle")
            .map(beginTime).toProperty("beginTime")
            .map(shopId).toProperty("shopId")
            .map(categoryId).toProperty("categoryId")
            .map(posLat).toProperty("posLat")
            .map(posLng).toProperty("posLng")
            .map(positionCode).toProperty("positionCode")
            .map(positionDetail).toProperty("positionDetail")
            .map(pics).toProperty("pics")
            .map(status).toProperty("status")
            .map(price).toProperty("price")
            .map(priceOri).toProperty("priceOri")
            .map(free).toProperty("free")
            .map(sum).toProperty("sum")
            .map(used).toProperty("used")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5290582+08:00", comments="Source Table: activity")
    default int insertSelective(Activity record) {
        return MyBatis3Utils.insert(this::insert, record, activity, c ->
            c.map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(detail).toPropertyWhenPresent("detail", record::getDetail)
            .map(subtitle).toPropertyWhenPresent("subtitle", record::getSubtitle)
            .map(beginTime).toPropertyWhenPresent("beginTime", record::getBeginTime)
            .map(shopId).toPropertyWhenPresent("shopId", record::getShopId)
            .map(categoryId).toPropertyWhenPresent("categoryId", record::getCategoryId)
            .map(posLat).toPropertyWhenPresent("posLat", record::getPosLat)
            .map(posLng).toPropertyWhenPresent("posLng", record::getPosLng)
            .map(positionCode).toPropertyWhenPresent("positionCode", record::getPositionCode)
            .map(positionDetail).toPropertyWhenPresent("positionDetail", record::getPositionDetail)
            .map(pics).toPropertyWhenPresent("pics", record::getPics)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(price).toPropertyWhenPresent("price", record::getPrice)
            .map(priceOri).toPropertyWhenPresent("priceOri", record::getPriceOri)
            .map(free).toPropertyWhenPresent("free", record::getFree)
            .map(sum).toPropertyWhenPresent("sum", record::getSum)
            .map(used).toPropertyWhenPresent("used", record::getUsed)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5320493+08:00", comments="Source Table: activity")
    default Optional<Activity> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5330461+08:00", comments="Source Table: activity")
    default List<Activity> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5330461+08:00", comments="Source Table: activity")
    default List<Activity> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5330461+08:00", comments="Source Table: activity")
    default Optional<Activity> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5340441+08:00", comments="Source Table: activity")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5340441+08:00", comments="Source Table: activity")
    static UpdateDSL<UpdateModel> updateAllColumns(Activity record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(title).equalTo(record::getTitle)
                .set(detail).equalTo(record::getDetail)
                .set(subtitle).equalTo(record::getSubtitle)
                .set(beginTime).equalTo(record::getBeginTime)
                .set(shopId).equalTo(record::getShopId)
                .set(categoryId).equalTo(record::getCategoryId)
                .set(posLat).equalTo(record::getPosLat)
                .set(posLng).equalTo(record::getPosLng)
                .set(positionCode).equalTo(record::getPositionCode)
                .set(positionDetail).equalTo(record::getPositionDetail)
                .set(pics).equalTo(record::getPics)
                .set(status).equalTo(record::getStatus)
                .set(price).equalTo(record::getPrice)
                .set(priceOri).equalTo(record::getPriceOri)
                .set(free).equalTo(record::getFree)
                .set(sum).equalTo(record::getSum)
                .set(used).equalTo(record::getUsed);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5350411+08:00", comments="Source Table: activity")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Activity record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(title).equalToWhenPresent(record::getTitle)
                .set(detail).equalToWhenPresent(record::getDetail)
                .set(subtitle).equalToWhenPresent(record::getSubtitle)
                .set(beginTime).equalToWhenPresent(record::getBeginTime)
                .set(shopId).equalToWhenPresent(record::getShopId)
                .set(categoryId).equalToWhenPresent(record::getCategoryId)
                .set(posLat).equalToWhenPresent(record::getPosLat)
                .set(posLng).equalToWhenPresent(record::getPosLng)
                .set(positionCode).equalToWhenPresent(record::getPositionCode)
                .set(positionDetail).equalToWhenPresent(record::getPositionDetail)
                .set(pics).equalToWhenPresent(record::getPics)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(price).equalToWhenPresent(record::getPrice)
                .set(priceOri).equalToWhenPresent(record::getPriceOri)
                .set(free).equalToWhenPresent(record::getFree)
                .set(sum).equalToWhenPresent(record::getSum)
                .set(used).equalToWhenPresent(record::getUsed);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5350411+08:00", comments="Source Table: activity")
    default int updateByPrimaryKey(Activity record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(detail).equalTo(record::getDetail)
            .set(subtitle).equalTo(record::getSubtitle)
            .set(beginTime).equalTo(record::getBeginTime)
            .set(shopId).equalTo(record::getShopId)
            .set(categoryId).equalTo(record::getCategoryId)
            .set(posLat).equalTo(record::getPosLat)
            .set(posLng).equalTo(record::getPosLng)
            .set(positionCode).equalTo(record::getPositionCode)
            .set(positionDetail).equalTo(record::getPositionDetail)
            .set(pics).equalTo(record::getPics)
            .set(status).equalTo(record::getStatus)
            .set(price).equalTo(record::getPrice)
            .set(priceOri).equalTo(record::getPriceOri)
            .set(free).equalTo(record::getFree)
            .set(sum).equalTo(record::getSum)
            .set(used).equalTo(record::getUsed)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-03T22:12:58.5360406+08:00", comments="Source Table: activity")
    default int updateByPrimaryKeySelective(Activity record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(detail).equalToWhenPresent(record::getDetail)
            .set(subtitle).equalToWhenPresent(record::getSubtitle)
            .set(beginTime).equalToWhenPresent(record::getBeginTime)
            .set(shopId).equalToWhenPresent(record::getShopId)
            .set(categoryId).equalToWhenPresent(record::getCategoryId)
            .set(posLat).equalToWhenPresent(record::getPosLat)
            .set(posLng).equalToWhenPresent(record::getPosLng)
            .set(positionCode).equalToWhenPresent(record::getPositionCode)
            .set(positionDetail).equalToWhenPresent(record::getPositionDetail)
            .set(pics).equalToWhenPresent(record::getPics)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(price).equalToWhenPresent(record::getPrice)
            .set(priceOri).equalToWhenPresent(record::getPriceOri)
            .set(free).equalToWhenPresent(record::getFree)
            .set(sum).equalToWhenPresent(record::getSum)
            .set(used).equalToWhenPresent(record::getUsed)
            .where(id, isEqualTo(record::getId))
        );
    }
}