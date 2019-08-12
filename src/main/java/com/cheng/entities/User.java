package com.cheng.entities;

import java.io.Serializable;
import java.time.LocalDateTime;


public class User implements Serializable{

	private static final long serialVersionUID = 5594526898136461812L;
	
	private Integer id;
	
	private String userName;
	
	private String password;
	
	private String roles;
	
	private LocalDateTime createTime;
	
	private LocalDateTime updateTime;
	
	

	public User( String userName, String password, String roles, LocalDateTime createTime,
			LocalDateTime updateTime) {
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	

}
