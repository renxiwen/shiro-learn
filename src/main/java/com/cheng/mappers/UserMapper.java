package com.cheng.mappers;

import com.cheng.entities.User;

public interface UserMapper {

	User queryUserByName(String name);

	boolean saveUser(User user);

}
