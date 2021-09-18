package com.example.spring_awesome.dao;

import com.example.spring_awesome.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
	List<Role> findRoleByUserId(@Param("userId") Integer userId);
}
