package com.example.spring_awesome.common.api;

import lombok.Data;

@Data
public class ResultData<T> {

	private int code;
	private String msg;
	private T data;
	private long t;

	public ResultData() {
		this.t = System.currentTimeMillis();
	}

	public static <T> ResultData<T> success(T data) {
		ResultData<T> resultData = new ResultData<>();
		resultData.setCode(ResultCode.RC200.getCode());
		resultData.setData(data);
		return resultData;
	}

	public static <T> ResultData<T> fail(int code, String msg) {
		ResultData<T> resultData = new ResultData<>();
		resultData.setCode(code);
		resultData.setMsg(msg);
		return resultData;
	}
}
