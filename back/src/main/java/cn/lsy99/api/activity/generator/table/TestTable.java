package cn.lsy99.api.activity.generator.table;

import javax.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TestTable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source field: test_table.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source field: test_table.lat")
    private Double lat;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source field: test_table.lng")
    private Double lng;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source field: test_table.position")
    private Object position;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source field: test_table.ids")
    private Object ids;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-03T19:11:46.2255971+08:00", comments="Source field: test_table.strings")
    private String[] strings;
}