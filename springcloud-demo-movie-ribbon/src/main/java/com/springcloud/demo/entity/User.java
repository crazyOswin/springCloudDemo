package com.springcloud.demo.entity;

import java.io.Serializable;


public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2195134295188910270L;
	
	private Long id;
	
	private String loginName;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
