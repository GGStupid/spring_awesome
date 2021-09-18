package com.example.spring_awesome.service;

import com.example.spring_awesome.entity.User;

/**
 * @date: 2021/9/14 15:17
 */
public interface UserService {

	public User findByAccount(String account);
}
