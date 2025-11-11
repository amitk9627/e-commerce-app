package com.ecom.response;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse<T> {
    private boolean status;
    private String message;
    private T result;
//    private Map<String, Object> extra = new HashMap<>();

    public ApiResponse() {}

    public ApiResponse(boolean status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public static <T> ApiResponse<T> success(String message, T result) {
        return new ApiResponse<>(true, message, result);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, null);
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getResult() {
        return result;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
