package com.example.demo;

import whalefall.loadconfigtest.LoadConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

	@Autowired
	private LoadConfig loadConfig;

	@Test
	void contextLoads() {
		log.info(String.format("A :%s B :%s", loadConfig.getA(), loadConfig.getB()));
		Assert.isTrue(loadConfig.getA() != null,"配置项为空");
	}

}
