package com.paradigma.demo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("zuulserver")
public interface MicroservicesClient {

	@RequestMapping(method = RequestMethod.GET, value = "/api/app-comments/comments")
	public PagedResources<Comment> getComments();
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/app-users/users/")
	public PagedResources<User> getUsers();
	
}
