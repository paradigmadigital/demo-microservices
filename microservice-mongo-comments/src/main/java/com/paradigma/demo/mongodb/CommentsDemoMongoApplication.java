package com.paradigma.demo.mongodb;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClientOptions;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class CommentsDemoMongoApplication {

	
	
    public static void main(String[] args) {
    	//fill data
    	//not in production
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
    
    
    
    @Autowired
    private MongoProperties properties;

    @Autowired(required = false)
    private MongoClientOptions options;

    @Bean(destroyMethod = "close")
    public Mongo mongo(MongodProcess mongodProcess) throws IOException {
        Net net = mongodProcess.getConfig().net();
        properties.setHost(net.getServerAddress().getHostName());
        properties.setPort(net.getPort());
        return properties.createMongoClient(this.options);
    }

    @Bean(destroyMethod = "stop")
    public MongodProcess mongodProcess(MongodExecutable mongodExecutable) throws IOException {
        return mongodExecutable.start();
    }

    @Bean(destroyMethod = "stop")
    public MongodExecutable mongodExecutable(MongodStarter mongodStarter, IMongodConfig iMongodConfig) throws IOException {
        return mongodStarter.prepare(iMongodConfig);
    }

    @Bean
    public IMongodConfig mongodConfig() throws IOException {
        return new MongodConfigBuilder().version(Version.Main.PRODUCTION).build();
    }

    @Bean
    public MongodStarter mongodStarter() {
        return MongodStarter.getDefaultInstance();
    }

    
}
