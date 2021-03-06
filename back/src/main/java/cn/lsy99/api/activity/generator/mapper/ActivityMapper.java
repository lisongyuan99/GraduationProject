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
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, detail, subtitle, beginTime, endTime, timeType, bigPic, smallPic, organizerId, category, posLat, posLng, posDetail, createTime, updateTime, positionCode, positionDetail);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.479252+08:00", comments="Source Table: activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.479252+08:00", comments="Source Table: activity")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.479252+08:00", comments="Source Table: activity")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Activity> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    @Insert({
        "${insertStatement}"
    })
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Activity> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default int insertMultiple(MultiRowInsertStatementProvider<Activity> multipleInsertStatement) {
        return insertMultiple(multipleInsertStatement.getInsertStatement(), multipleInsertStatement.getRecords());
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ActivityResult")
    Optional<Activity> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ActivityResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="subtitle", property="subtitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="time_type", property="timeType", jdbcType=JdbcType.INTEGER),
        @Result(column="big_pic", property="bigPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="small_pic", property="smallPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="organizer_id", property="organizerId", jdbcType=JdbcType.INTEGER),
        @Result(column="category", property="category", jdbcType=JdbcType.INTEGER),
        @Result(column="pos_lat", property="posLat", jdbcType=JdbcType.DOUBLE),
        @Result(column="pos_lng", property="posLng", jdbcType=JdbcType.DOUBLE),
        @Result(column="pos_detail", property="posDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="position_code", property="positionCode", jdbcType=JdbcType.INTEGER),
        @Result(column="position_detail", property="positionDetail", jdbcType=JdbcType.VARCHAR)
    })
    List<Activity> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default int insert(Activity record) {
        return MyBatis3Utils.insert(this::insert, record, activity, c ->
            c.map(title).toProperty("title")
            .map(detail).toProperty("detail")
            .map(subtitle).toProperty("subtitle")
            .map(beginTime).toProperty("beginTime")
            .map(endTime).toProperty("endTime")
            .map(timeType).toProperty("timeType")
            .map(bigPic).toProperty("bigPic")
            .map(smallPic).toProperty("smallPic")
            .map(organizerId).toProperty("organizerId")
            .map(category).toProperty("category")
            .map(posLat).toProperty("posLat")
            .map(posLng).toProperty("posLng")
            .map(posDetail).toProperty("posDetail")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(positionCode).toProperty("positionCode")
            .map(positionDetail).toProperty("positionDetail")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default int insertMultiple(Collection<Activity> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, activity, c ->
            c.map(title).toProperty("title")
            .map(detail).toProperty("detail")
            .map(subtitle).toProperty("subtitle")
            .map(beginTime).toProperty("beginTime")
            .map(endTime).toProperty("endTime")
            .map(timeType).toProperty("timeType")
            .map(bigPic).toProperty("bigPic")
            .map(smallPic).toProperty("smallPic")
            .map(organizerId).toProperty("organizerId")
            .map(category).toProperty("category")
            .map(posLat).toProperty("posLat")
            .map(posLng).toProperty("posLng")
            .map(posDetail).toProperty("posDetail")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(positionCode).toProperty("positionCode")
            .map(positionDetail).toProperty("positionDetail")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default int insertSelective(Activity record) {
        return MyBatis3Utils.insert(this::insert, record, activity, c ->
            c.map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(detail).toPropertyWhenPresent("detail", record::getDetail)
            .map(subtitle).toPropertyWhenPresent("subtitle", record::getSubtitle)
            .map(beginTime).toPropertyWhenPresent("beginTime", record::getBeginTime)
            .map(endTime).toPropertyWhenPresent("endTime", record::getEndTime)
            .map(timeType).toPropertyWhenPresent("timeType", record::getTimeType)
            .map(bigPic).toPropertyWhenPresent("bigPic", record::getBigPic)
            .map(smallPic).toPropertyWhenPresent("smallPic", record::getSmallPic)
            .map(organizerId).toPropertyWhenPresent("organizerId", record::getOrganizerId)
            .map(category).toPropertyWhenPresent("category", record::getCategory)
            .map(posLat).toPropertyWhenPresent("posLat", record::getPosLat)
            .map(posLng).toPropertyWhenPresent("posLng", record::getPosLng)
            .map(posDetail).toPropertyWhenPresent("posDetail", record::getPosDetail)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(positionCode).toPropertyWhenPresent("positionCode", record::getPositionCode)
            .map(positionDetail).toPropertyWhenPresent("positionDetail", record::getPositionDetail)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default Optional<Activity> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default List<Activity> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default List<Activity> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default Optional<Activity> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, activity, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    static UpdateDSL<UpdateModel> updateAllColumns(Activity record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(title).equalTo(record::getTitle)
                .set(detail).equalTo(record::getDetail)
                .set(subtitle).equalTo(record::getSubtitle)
                .set(beginTime).equalTo(record::getBeginTime)
                .set(endTime).equalTo(record::getEndTime)
                .set(timeType).equalTo(record::getTimeType)
                .set(bigPic).equalTo(record::getBigPic)
                .set(smallPic).equalTo(record::getSmallPic)
                .set(organizerId).equalTo(record::getOrganizerId)
                .set(category).equalTo(record::getCategory)
                .set(posLat).equalTo(record::getPosLat)
                .set(posLng).equalTo(record::getPosLng)
                .set(posDetail).equalTo(record::getPosDetail)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(positionCode).equalTo(record::getPositionCode)
                .set(positionDetail).equalTo(record::getPositionDetail);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Activity record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(title).equalToWhenPresent(record::getTitle)
                .set(detail).equalToWhenPresent(record::getDetail)
                .set(subtitle).equalToWhenPresent(record::getSubtitle)
                .set(beginTime).equalToWhenPresent(record::getBeginTime)
                .set(endTime).equalToWhenPresent(record::getEndTime)
                .set(timeType).equalToWhenPresent(record::getTimeType)
                .set(bigPic).equalToWhenPresent(record::getBigPic)
                .set(smallPic).equalToWhenPresent(record::getSmallPic)
                .set(organizerId).equalToWhenPresent(record::getOrganizerId)
                .set(category).equalToWhenPresent(record::getCategory)
                .set(posLat).equalToWhenPresent(record::getPosLat)
                .set(posLng).equalToWhenPresent(record::getPosLng)
                .set(posDetail).equalToWhenPresent(record::getPosDetail)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(positionCode).equalToWhenPresent(record::getPositionCode)
                .set(positionDetail).equalToWhenPresent(record::getPositionDetail);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default int updateByPrimaryKey(Activity record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(detail).equalTo(record::getDetail)
            .set(subtitle).equalTo(record::getSubtitle)
            .set(beginTime).equalTo(record::getBeginTime)
            .set(endTime).equalTo(record::getEndTime)
            .set(timeType).equalTo(record::getTimeType)
            .set(bigPic).equalTo(record::getBigPic)
            .set(smallPic).equalTo(record::getSmallPic)
            .set(organizerId).equalTo(record::getOrganizerId)
            .set(category).equalTo(record::getCategory)
            .set(posLat).equalTo(record::getPosLat)
            .set(posLng).equalTo(record::getPosLng)
            .set(posDetail).equalTo(record::getPosDetail)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(positionCode).equalTo(record::getPositionCode)
            .set(positionDetail).equalTo(record::getPositionDetail)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-02-17T00:54:46.4948737+08:00", comments="Source Table: activity")
    default int updateByPrimaryKeySelective(Activity record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(detail).equalToWhenPresent(record::getDetail)
            .set(subtitle).equalToWhenPresent(record::getSubtitle)
            .set(beginTime).equalToWhenPresent(record::getBeginTime)
            .set(endTime).equalToWhenPresent(record::getEndTime)
            .set(timeType).equalToWhenPresent(record::getTimeType)
            .set(bigPic).equalToWhenPresent(record::getBigPic)
            .set(smallPic).equalToWhenPresent(record::getSmallPic)
            .set(organizerId).equalToWhenPresent(record::getOrganizerId)
            .set(category).equalToWhenPresent(record::getCategory)
            .set(posLat).equalToWhenPresent(record::getPosLat)
            .set(posLng).equalToWhenPresent(record::getPosLng)
            .set(posDetail).equalToWhenPresent(record::getPosDetail)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(positionCode).equalToWhenPresent(record::getPositionCode)
            .set(positionDetail).equalToWhenPresent(record::getPositionDetail)
            .where(id, isEqualTo(record::getId))
        );
    }
}