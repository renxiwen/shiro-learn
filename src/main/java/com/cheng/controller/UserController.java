package com.cheng.controller;




import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheng.service.UserService;

@Controller
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	BasicDataSource dataSource;
	
	@Autowired
	private UserService UserService;
	
	@PostMapping("/login")
	public String login(String username,String password) {
		 try {
	            //shiro通过SecurityUtils.getSubject()获得主体，主体可以理解为客户端实例，原理在后面讲
	            Subject subject = SecurityUtils.getSubject();
	            //已经认证过，也就是该客户端已经登陆过
	            if (subject.isAuthenticated()) {
	                return "redirect:/api/index";
	            }
	            //一般都使用UsernamePasswordToken，shiro的token中有Principal和Credentials的概念
	            //Principal代表当前客户端要登录的用户，Credentials代表证明该用户身份的凭证
	            //UsernamePasswordToken将username作为Principal，password作为Credentials
	            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	            //rememberMe功能后面讲
	            token.setRememberMe(true);
	            subject.login(token);
	        } catch (AuthenticationException e) {
	        	e.printStackTrace();
	            //登录失败则跳转到登录失败页面，可能是用户名或密码错误
	            return "redirect:/api/logout";
	        }
	        return "redirect:/api/index";	
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/register")
	public String register(String username,String password) {
		System.out.println("进入注册方法");
		System.out.println(dataSource.getPassword());
		String securityPassword = new Md5Hash(password, ByteSource.Util.bytes(username), 5).toString();
		UserService.saveUser(username, securityPassword);
		return "register";
	}
	
	

}
