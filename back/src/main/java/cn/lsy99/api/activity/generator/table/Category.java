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
public class Category {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.6835797+08:00", comments="Source field: category.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-02T23:47:10.6835797+08:00", comments="Source field: category.name")
    private String name;
}