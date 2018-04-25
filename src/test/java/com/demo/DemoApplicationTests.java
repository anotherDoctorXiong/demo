package com.demo;

import com.demo.model.Adminer;
import com.demo.model.Comunity;
import com.demo.service.rmqa;
import com.demo.service.redis;
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
	@Autowired
	private redis re;

	@Test
	public void redis(){
		re.getData();
	}


}
