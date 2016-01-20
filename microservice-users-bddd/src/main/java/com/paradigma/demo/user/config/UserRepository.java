package com.paradigma.demo.user.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource()
public interface UserRepository extends JpaRepository<User,Integer>{

	
}
