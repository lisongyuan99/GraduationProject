package cn.lsy99.api.activity.generator.table;

import javax.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Category {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5968538+08:00", comments="Source field: category.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-30T17:26:34.5968538+08:00", comments="Source field: category.name")
    private String name;
}