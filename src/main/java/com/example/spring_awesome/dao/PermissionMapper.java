package com.example.spring_awesome.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper {
	List<String> findByRoleId(@Param("roleIds") List<Integer> roleIds);
}
