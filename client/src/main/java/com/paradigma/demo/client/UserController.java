package com.paradigma.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private MicroserviceCommentsHystrixClient client;

	@RequestMapping("/users")
	public ResponseEntity<PagedResources<User>> home() {
		return new ResponseEntity<PagedResources<User>>(client.getUsers(), HttpStatus.ACCEPTED);
	}
}
