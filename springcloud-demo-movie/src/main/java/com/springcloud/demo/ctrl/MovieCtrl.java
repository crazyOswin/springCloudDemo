package com.springcloud.demo.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.demo.entity.User;

@RestController
public class MovieCtrl {

	@Autowired private RestTemplate restTemplate;
	
	@GetMapping("/movie/{id}")
	public User findUserById(@PathVariable Long id){
		return restTemplate.getForObject("http://localhost:7900/simple/" + id, User.class);
	}
}
