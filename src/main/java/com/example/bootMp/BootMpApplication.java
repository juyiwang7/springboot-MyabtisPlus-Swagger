package com.example.bootMp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bootMp.mapper")
public class BootMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMpApplication.class, args);
	}

}
