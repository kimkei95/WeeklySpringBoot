package com.bootcamp.WeeklySpringBoot;

import com.bootcamp.WeeklySpringBoot.Config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class WeeklySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeeklySpringBootApplication.class, args);
	}

}
