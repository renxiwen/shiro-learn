package com.cheng.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cheng.entities.User;
import com.cheng.mappers.UserMapper;

@Service
public class UserService {
	private static Log log = LogFactory.getLog(UserService.class);
	//mybatis代理实现的dao
    @Resource
    private UserMapper userMapper;

    //根据用户名获得user对象
    public User queryUserByName(String name) {
        try {
            if (StringUtils.isEmpty(name)) {
                return null;
            }
            return userMapper.queryUserByName(name);
        } catch (Exception e) {
            log.error("db error when query user:{}", e);
            log.error(name + "不存在!");
        }
        return null;
    }
    
    //根据用户名获得用户的所有角色
    public Set<String> queryUserRole(String userName) {
        User user = queryUserByName(userName);
        if (user == null) {
            return Collections.emptySet();
        }
        List<String> roleList = splitRoles(user.getRoles());
        return new HashSet<String>(roleList);
    }
    private List<String> splitRoles(String roles){
    	String[] split = roles.split(",");
    	return Arrays.asList(split);
    }
    
    public boolean saveUser(String name,String password) {
    	User user = new User(name, password, "employer", LocalDateTime.now(), LocalDateTime.now());
    	return userMapper.saveUser(user);
    }
}
