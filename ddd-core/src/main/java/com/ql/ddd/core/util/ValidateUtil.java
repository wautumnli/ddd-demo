package com.ql.ddd.core.util;

import com.ql.ddd.core.exception.DomainException;

import java.util.Objects;

/**
 * @author wanqiuli
 * @date 2022/2/23 11:12
 */
public class ValidateUtil {

    public static void check(Object object, String message) {
        if (Objects.isNull(object)) {
            throw new DomainException(message);
        }
    }

    public static void check(boolean expect, String message) {
        if (!expect) {
            throw new DomainException(message);
        }
    }
}
