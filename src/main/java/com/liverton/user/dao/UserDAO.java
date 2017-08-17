package com.liverton.user.dao;

import com.liverton.entity.User;

public interface UserDAO {
	User findByUserName(String username);

//    public void shutdown();
}
