package com.tream.common.result;

public class GlobalErrorInfoException extends RuntimeException {

    private ErrorInfoInterFace errorInfo;

    public GlobalErrorInfoException(ErrorInfoInterFace errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfoInterFace getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterFace errorInfo) {
        this.errorInfo = errorInfo;
    }
}
