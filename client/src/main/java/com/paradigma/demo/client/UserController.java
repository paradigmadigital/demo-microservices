package com.paradigma.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {

	@Autowired
	private MicroserviceCommentsHystrixClient client;
	
	@Autowired
	private ObjectMapper mapper;

	@RequestMapping("/users")
	public ResponseEntity<String> home() throws JsonProcessingException {
		return new ResponseEntity<String>(mapper.writeValueAsString(client.getUsers()), HttpStatus.ACCEPTED);
	}
	
}
