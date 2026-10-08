package com.saas.generics;

public class ApiResult<T> {
    private boolean success;
    private String message;
    private T data;

    public ApiResult(boolean success, String message, T data){
        this.success=success;
        this.message=message;
        this.data=data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
