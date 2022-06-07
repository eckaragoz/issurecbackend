package com.isrc.issurecleri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.isrc")
@EntityScan(basePackages = "com.isrc.models")
@EnableJpaRepositories(basePackages="com.isrc.repositories")
public class IssurecleriApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssurecleriApplication.class, args);
	}

}
