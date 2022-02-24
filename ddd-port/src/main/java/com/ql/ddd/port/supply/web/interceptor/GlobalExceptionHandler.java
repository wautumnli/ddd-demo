package com.ql.ddd.port.supply.web.interceptor;

import com.ql.ddd.core.dto.Result;
import com.ql.ddd.core.exception.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;

/**
 * @author wanqiuli
 * @date 2022/2/23 11:26
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DomainException.class)
    public ResponseEntity<Result<?>> handleDomainException(DomainException exception) {
        return new ResponseEntity<>(Result.failure(exception.getErrorMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * 参数验证异常
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Result<?>> handleServiceException(MethodArgumentNotValidException exception) {
        //对校验错误信息进行封装，并输出到日志
        BindingResult result = exception.getBindingResult();
        StringBuilder errorMessage = new StringBuilder();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();

            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                errorMessage.append(fieldError.getDefaultMessage()).append(",");
            });
        }
        if (errorMessage.length() > 0) {
            errorMessage.setLength(errorMessage.length() - 1);
        }

        return new ResponseEntity<>(Result.failure(errorMessage.toString()), HttpStatus.BAD_REQUEST);
    }

    /**
     * 其他异常统一由此方法拦截
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Result<?>> hadleServerException(Exception e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        String msg = "server error, please try again later";
        Class<?> exceptionClazz = e.getClass();
        if (Objects.equals(MissingServletRequestParameterException.class, exceptionClazz)) {
            msg = "incorrect parameter";
            httpStatus = HttpStatus.BAD_REQUEST;
        } else if (Objects.equals(HttpRequestMethodNotSupportedException.class, exceptionClazz)) {
            httpStatus = HttpStatus.BAD_REQUEST;
            msg = e.getMessage();
        }
        return new ResponseEntity<>(Result.failure(msg), httpStatus);
    }

    /**
     * 不支持的请求方法
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Result<?>> handleException(HttpRequestMethodNotSupportedException e) {
        return new ResponseEntity<>(Result.failure("不支持' " + e.getMethod() + "'请求"), HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * 不支持的内容类型
     */
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public ResponseEntity<Result<?>> handleException(HttpMediaTypeNotSupportedException e) {
        Result<?> failure = Result.failure("只支持' " + e.getSupportedMediaTypes() + "'类型的请求");
        failure.setCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
        return new ResponseEntity<>(failure, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
}
