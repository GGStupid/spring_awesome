package com.example.spring_awesome.common.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @author:RestExceptionHandler
 * @date: 2021/9/1 15:21
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultData<String> exception(Exception e) {
		log.error("全局异常信息 ex={}", e.getMessage(), e);
		return ResultData.fail(ResultCode.RC500.getCode(), e.getMessage());
	}
}
