package cn.lsy99.api.activity.organizer;

import cn.lsy99.api.activity.organizer.mapper.OrganizerMapper;
import cn.lsy99.api.activity.organizer.table.Organizer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static cn.lsy99.api.activity.organizer.mapper.OrganizerDynamicSqlSupport.organizer;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@SpringBootTest
class OrganizerApplicationTests {

	@Autowired
	OrganizerMapper organizerMapper;
	@Test
	void contextLoads() {
		String openId = "oNfDt4iiLsuT1jmDex_-AJhT-GaI";
		List<Organizer> result = organizerMapper.select(c -> c.where(organizer.wxOpenId, isEqualTo(openId)));
		System.out.println(result);
	}

}
