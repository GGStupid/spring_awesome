package com.example.spring_awesome.service.impl;

import com.example.spring_awesome.dao.PermissionMapper;
import com.example.spring_awesome.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date: 2021/9/14 14:48
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<String> findByRoleId(List<Integer> roleIds) {
		return permissionMapper.findByRoleId(roleIds);
	}
}
