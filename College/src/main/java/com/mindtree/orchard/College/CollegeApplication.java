package com.mindtree.orchard.College;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
@ComponentScan(basePackages = {"com.mindtree.orchard"})
@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages ="com.mindtree.orchard")
@EntityScan(basePackages ="com.mindtree.orchard")
public class CollegeApplication {
	@Bean
	@LoadBalanced
	public RestTemplate getResttemplate()
	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CollegeApplication.class, args);
	}

}
