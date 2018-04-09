package com.tream.common.result;

public enum GlobalErrorInfoEnum implements ErrorInfoInterFace{

    SUCCESS(0 , "success"),
    NOT_FOUNT(1, "service not fount"),

    /**
     * token 异常
     */
    TOKEN_EXPRIED(700, "token过期"),
    TOKEN_ERROR(700, "token验证失败"),

    /**
     * 账号密码错误
     */

    LOGIN_ERROR(700, "token验证失败"),
    /**
     * 签名异常
     */
    SIGN_ERROR(700, "签名失败异常"),


    /**
     * 其他
     */
    AUTN_REQUEST_ERROR(400, "账号密码错误"),


    /**
     * 渲染页面错误
     */
    WRITE_ERROR(500, "渲染页面错误");









    private int code;

    private String message;


    GlobalErrorInfoEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
