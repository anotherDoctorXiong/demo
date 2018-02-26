package com.demo;

import com.demo.model.Comunity;
import com.demo.service.rmqa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private rmqa r;

	@Test
	public void contextLoads() {
		ValueOperations<String, String> valueOperations = redisTemplate
				.opsForValue();
		//valueOperations.set("1", "dasf", 80, TimeUnit.SECONDS);
		//Comunity com1 = (Comunity) valueOperations.get("1");
		System.out.println(valueOperations.get("1"));
	}
	@Test
	public void rmqa(){

	}

}
