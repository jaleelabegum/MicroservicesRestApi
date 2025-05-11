package com.example.MicroserviceSecondService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.MicroserviceSecondService.Dao")
@EntityScan(basePackages = "com.example.MicroserviceSecondService.Entities")
@ComponentScan(basePackages = "com.example.MicroserviceSecondService")
public class MicroserviceSecondServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSecondServiceApplication.class, args);
	}

}
