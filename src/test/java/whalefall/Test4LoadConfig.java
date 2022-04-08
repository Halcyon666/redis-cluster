package whalefall;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import whalefall.loadconfigtest.loadconfigfrompropfile.LoadConfig;

@SpringBootTest
@Slf4j
class Test4LoadConfig {

	@Autowired
	private LoadConfig loadConfig;

	@Test
	void contextLoads() {
		log.info(String.format("A :%s B :%s", loadConfig.getA(), loadConfig.getB()));
	}

}
