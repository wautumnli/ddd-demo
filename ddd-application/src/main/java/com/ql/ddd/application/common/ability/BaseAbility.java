package com.ql.ddd.application.common.ability;

import com.ql.ddd.core.dto.Result;
import org.springframework.transaction.annotation.Transactional;

/**
 * 基础命令抽象类
 *
 * @author wanqiuli
 * @date 2022/2/23 10:27
 */
public abstract class BaseAbility<C, R> {

    /**
     * function is checkCommand
     *
     * @param command the command
     */
    public abstract void checkCommand(C command);


    /**
     * function is executeCommand
     *
     * @param command the command
     * @return the {@link Result<R>} data
     */
    public abstract Result<R> executeCommand(C command);


    /**
     * function is execute
     *
     * @param command the command
     * @return the {@link Result<R>} data
     */
    @Transactional(rollbackFor = Exception.class)
    public Result<R> execute(C command) {
        checkCommand(command);
        return executeCommand(command);
    }
}
