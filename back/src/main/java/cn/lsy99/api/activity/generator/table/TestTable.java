package cn.lsy99.api.activity.generator.table;

import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class TestTable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6108159+08:00", comments="Source field: test_table.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.lat")
    private Double lat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.lng")
    private Double lng;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.position")
    private Object position;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.ids")
    private Object ids;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.6118138+08:00", comments="Source field: test_table.strings")
    private String[] strings;
}