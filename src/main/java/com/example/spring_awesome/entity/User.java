package com.example.spring_awesome.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @date: 2021/9/14 13:47
 */
@Data
@ToString
public class User implements Serializable {
	private static final long serialVersionUID = -6056125703075132981L;

	private Integer id;

	private String account;

	private String password;

	private String username;
}
