package com.paradigma.demo.user.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class UsersDemoApplication {

	
	
	public static void main(String[] args) {
		//fill data
    	//dont't make this in production xD
		final ConfigurableApplicationContext context = SpringApplication.run(UsersDemoApplication.class, args);
		final UserRepository repo = context.getBean(UserRepository.class);
		for(int i = 0 ; i < 100 ; i++){
			User user = new User();
			user.setEmail("email_"+i+"@dominio.com");
			user.setName("Nombre "+i);
			user.setLastName("Apellido "+i);
			user.setPassword("password"+i);

			repo.save(user);
		}
		
		

	}

}
