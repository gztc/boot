package org.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching//开启redis缓存
public class BootApplication {

	public static void main(String[] args) {
		//springboot执行入口
		SpringApplication.run(BootApplication.class, args);
	}
}
