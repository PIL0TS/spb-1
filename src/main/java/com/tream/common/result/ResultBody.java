package com.tream.common.result;

public class ResultBody {

    private int code; //响应代码

    private String message; //响应消息

    private Object result; //相应结果

    public ResultBody(ErrorInfoInterFace errInfo) {
        code = errInfo.getCode();
        message = errInfo.getMessage();
    }

    public ResultBody(Object result) {
        this.code = GlobalErrorInfoEnum.SUCCESS.getCode();


        this.result = result;
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
