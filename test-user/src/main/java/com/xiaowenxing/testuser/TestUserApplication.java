package com.xiaowenxing.testuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xiaowenxing.testuser.dao.**")
public class TestUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestUserApplication.class, args);
	}

}
