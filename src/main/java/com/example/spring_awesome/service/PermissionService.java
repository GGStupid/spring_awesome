package com.example.spring_awesome.service;

import java.util.List;

/**
 * @Description:
 * @author:PermissionService
 * @date: 2021/9/14 14:49
 */
public interface PermissionService {
	public List<String> findByRoleId(List<Integer> roleIds);
}
