package com.springcloud.demo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.demo.entity.User;

@RestController
public class UserCtrl {

	@GetMapping("/simple/{id}")
	public User findUserById(@PathVariable Long id){
		User user = new User();
		user.setId(id);
		user.setName("张三");
		user.setLoginName("zhangsan");
		return user;
	}
}
