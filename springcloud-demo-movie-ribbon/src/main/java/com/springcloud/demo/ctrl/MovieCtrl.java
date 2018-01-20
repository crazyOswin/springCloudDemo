package com.springcloud.demo.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.demo.entity.User;

@RestController
public class MovieCtrl {

	@Autowired private RestTemplate restTemplate;
	
	@Autowired private LoadBalancerClient loadBalanceClient;
	
	@GetMapping("/movie/{id}")
	public User findUserById(@PathVariable Long id){
		return restTemplate.getForObject("http://eureka-user/simple/" + id, User.class);
	}
	
	@GetMapping("/ribbon")
	public String ribbon(){
		ServiceInstance serviceInstance = loadBalanceClient.choose("eureka-user");
		System.out.println(serviceInstance.getServiceId()+":"+serviceInstance.getHost()+":"+serviceInstance.getPort());
		
		ServiceInstance serviceInstance2 = loadBalanceClient.choose("eureka-user2");
		System.out.println(serviceInstance2.getServiceId()+":"+serviceInstance2.getHost()+":"+serviceInstance2.getPort());
		
		return "ok";
	}
}
