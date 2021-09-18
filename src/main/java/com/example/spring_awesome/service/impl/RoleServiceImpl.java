package com.example.spring_awesome.service.impl;

import com.example.spring_awesome.dao.RoleMapper;
import com.example.spring_awesome.entity.Role;
import com.example.spring_awesome.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date: 2021/9/14 14:53
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> findRoleByUserId(Integer id) {
		return roleMapper.findRoleByUserId(id);
	}
}
