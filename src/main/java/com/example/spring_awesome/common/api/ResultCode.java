package com.example.spring_awesome.common.api;

public enum ResultCode implements IErrorCode {
    SUCCESS(200, "成功"),

    FAILED(500, "失败"),

    VALIDATE_FAILED(404, "参数验证失败"),

    UNAUTHORIZED(401, "未登录或token已过期"),

    FORBIDDEN(403, "没有相关权限");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}



