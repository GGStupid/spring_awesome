package com.example.spring_awesome.service;

import com.example.spring_awesome.entity.Role;

import java.util.List;

public interface RoleService {
	public List<Role> findRoleByUserId(Integer id);
}
