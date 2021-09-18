package com.example.spring_awesome.service.impl;

import com.example.spring_awesome.dao.UserMapper;
import com.example.spring_awesome.entity.User;
import com.example.spring_awesome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date: 2021/9/14 15:22
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByAccount(String account) {
		User user = userMapper.findByAccount(account);
		System.out.println(user);
		return user;
	}
}
