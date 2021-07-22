package com.example.spring_awesome.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.spring_awesome.mbg.mapper")
public class MyBatisConfig {
}
