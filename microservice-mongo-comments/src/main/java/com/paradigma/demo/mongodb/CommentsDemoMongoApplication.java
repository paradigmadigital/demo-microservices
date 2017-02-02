package com.paradigma.demo.mongodb;

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
public class CommentsDemoMongoApplication {

	
	
    public static void main(String[] args) {
    	//fill data
    	//dont't make this in production xD
    	final ConfigurableApplicationContext context =  SpringApplication.run(CommentsDemoMongoApplication.class, args);
    	CommentRepository repo = context.getBean(CommentRepository.class);
    	User user = new User();
		user.setEmail("email_1@dominio.com");
		user.setName("Nombre 1");
		user.setLastName("Apellido 1");
		user.setPassword("password 1");
		User user2 = new User();
		user2.setEmail("email_2@dominio.com");
		user2.setName("Nombre 2");
		user2.setLastName("Apellido 2");
		user2.setPassword("password 2");
    	for(int i = 0 ; i < 500 ; i++){
    		Comment comment = new Comment();
        	comment.setText("Esto es un comentario con id->"+i);
        	comment.setUser((i % 2 == 0) ? user : user2);
    		repo.save(comment );
    	}
    	
    	
    }

    
}
