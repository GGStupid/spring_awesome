package com.example.spring_awesome.dto;

import lombok.Data;

/**
 * @date: 2021/9/2 11:44
 */
@Data
public class WebLog {

	private String description;
	private String username;
	private Long startTime;
	private Integer spendTime;
	private String basePath;
	private String uri;
	private String url;
	private String method;
	private String ip;
	private Object parameter;
	private Object result;
}
