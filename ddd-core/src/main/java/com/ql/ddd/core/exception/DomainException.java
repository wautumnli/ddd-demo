package com.ql.ddd.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wanqiuli
 * @date 2022/2/23 11:13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DomainException extends RuntimeException {

    private String errorMessage;

    private String errorCode;

    /**
     * 构造新实例。
     */
    public DomainException() {
        super();
    }

    /**
     * 用给定的异常信息构造新实例。
     *
     * @param errorMessage 异常信息。
     */
    public DomainException(String errorMessage) {
        super((String) null);
        this.errorMessage = errorMessage;
    }

    /**
     * 用表示异常原因的对象构造新实例。
     *
     * @param cause 异常原因。
     */
    public DomainException(Throwable cause) {
        super(null, cause);
    }

    /**
     * 用异常消息和表示异常原因的对象构造新实例。
     *
     * @param errorMessage 异常信息。
     * @param cause        异常原因。
     */
    public DomainException(String errorMessage, Throwable cause) {
        super(null, cause);
        this.errorMessage = errorMessage;
    }

    /**
     * 用异常消息和表示异常原因及其他信息的对象构造新实例。
     *
     * @param errorMessage 异常信息。
     * @param errorCode    错误代码。
     * @param cause        异常原因。
     */
    public DomainException(String errorMessage, String errorCode, Throwable cause) {
        this(errorMessage, cause);
        this.errorCode = errorCode;
    }

    public DomainException(String code, String message) {
        super(message);
        this.errorCode = code;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
