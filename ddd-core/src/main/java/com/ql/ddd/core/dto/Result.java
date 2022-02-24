package com.ql.ddd.core.dto;

import com.ql.ddd.core.constant.Constant;
import lombok.Data;

/**
 * @author wanqiuli
 * @date 2022/2/22 9:52
 */
@Data
public class Result<T> {
    private boolean result = true;
    private int code;
    private String message;
    private T data;

    /**
     * @return the response data
     */
    public static Result<Void> success() {
        return new Result<>();
    }

    /**
     * @param <R>  the type parameter
     * @param data the data
     * @return the response data
     */
    public static <R> Result<R> success(R data) {
        return new Result<>(Constant.SUCCESS_CODE, Constant.SUCCESS_MESSAGE, data);
    }

    /**
     * @return the response data
     */
    public static Result<?> failure() {
        Result<Object> responseData = new Result<>(Constant.ERROR_CODE, Constant.ERROR_MESSAGE);
        responseData.setResult(false);
        return responseData;
    }

    /**
     * @param message the message
     * @return the response data
     */
    public static Result<?> failure(String message) {
        Result<Object> responseData = new Result<>(Constant.ERROR_CODE, message);
        responseData.setResult(false);
        return responseData;
    }

    /**
     * 默认是成功
     */
    public Result() {
        this.code = Constant.SUCCESS_CODE;
        this.message = Constant.SUCCESS_MESSAGE;
    }

    /**
     * 默认是成功
     *
     * @param data the data
     */
    public Result(T data) {
        this.code = Constant.SUCCESS_CODE;
        this.message = Constant.SUCCESS_MESSAGE;
        this.data = data;
    }

    /**
     * Instantiates a new Result.
     *
     * @param code    the code
     * @param message the message
     */
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Instantiates a new Response data.
     *
     * @param code    the code
     * @param message the message
     * @param data    the data
     */
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
