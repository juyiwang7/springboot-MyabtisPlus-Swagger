package com.example.bootMp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@SpringBootApplication
@MapperScan("com.example.bootMp.mapper")
public class BootMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMpApplication.class, args);
	}

}
