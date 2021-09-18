package com.example.spring_awesome.dao;

import com.example.spring_awesome.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @date: 2021/9/14 14:23
 */
@Mapper
public interface UserMapper {
	User findByAccount(@Param("account") String account);
}
