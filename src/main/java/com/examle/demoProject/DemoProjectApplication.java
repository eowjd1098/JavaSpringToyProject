package com.examle.demoProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.context.annotation.*;

@EnableAutoConfiguration(
		exclude={DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		PersistenceExceptionTranslationAutoConfiguration.class
		})
@ImportResource("classpath:datasource-config.xml")
@ComponentScan(basePackages = "org.our.freecommit")

@SpringBootApplication
public class DemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);

	}

}
