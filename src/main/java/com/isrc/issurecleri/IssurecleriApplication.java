package com.isrc.issurecleri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.isrc")
@EntityScan(basePackages = "com.isrc.models")
@EnableJpaRepositories(basePackages="com.isrc.repositories")
@EnableSwagger2
public class IssurecleriApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssurecleriApplication.class, args);
	}

}
