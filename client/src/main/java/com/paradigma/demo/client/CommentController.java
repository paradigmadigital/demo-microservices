package com.paradigma.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

	@Autowired
	private MicroserviceCommentsHystrixClient client;

	@RequestMapping("/comments")
	public ResponseEntity<PagedResources<Comment>> home() {
		return new ResponseEntity<PagedResources<Comment>>(client.getComments(), HttpStatus.ACCEPTED);
	}
}
