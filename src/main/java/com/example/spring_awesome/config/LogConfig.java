package com.example.spring_awesome.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date: 2021/9/2 15:24
 */
@Configuration
public class LogConfig {
	private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class);

	@Bean
	public void logMethod(){
		LOG.info("++++++++++  +++++++++++=");
	}
}
