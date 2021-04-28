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
public class Admin {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8821057+08:00", comments="Source field: admin.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-04-24T22:40:53.8821057+08:00", comments="Source field: admin.password")
    private String password;
}