package com.example.spring_awesome.common.api;

public enum ResultCode {
	/**
	 * 操作失败
	 **/
	RC999(999, "操作失败"),
	/**
	 * 操作成功
	 **/
	RC200(200, "操作成功"),
	/**
	 * access_denied
	 **/
	RC403(403, "无访问权限,请联系管理员授予权限"),
	/**
	 * access_denied
	 **/
	RC401(401, "匿名用户访问无权限资源时的异常"),
	/**
	 * 服务异常
	 **/
	RC500(500, "系统异常，请稍后重试"),

	INVALID_TOKEN(4001, "访问令牌不合法"),
	ACCESS_DENIED(4003, "没有权限访问该资源"),
	CLIENT_AUTHENTICATION_FAILED(1001, "客户端认证失败"),
	USERNAME_OR_PASSWORD_ERROR(1002, "用户名或密码错误"),
	UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式");


	/**
	 * 自定义状态码
	 **/
	private final int code;
	/**
	 * 自定义描述
	 **/
	private final String message;

	ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}


	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}



