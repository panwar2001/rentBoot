package com.panwar2001.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestApi {

	@GetMapping("/hello")
	public String hello() {
	  return "Hello";	
	}

}
