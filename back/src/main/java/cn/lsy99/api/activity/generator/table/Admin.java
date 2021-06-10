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
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-10T16:16:02.7310414+08:00", comments="Source field: admin.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-10T16:16:02.7310414+08:00", comments="Source field: admin.password")
    private String password;
}