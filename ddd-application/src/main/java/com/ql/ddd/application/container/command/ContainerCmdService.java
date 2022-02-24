package com.ql.ddd.application.container.command;

import com.ql.ddd.application.container.command.cmd.ContainerCreateCmd;

/**
 * @author wanqiuli
 * @date 2022/2/22 14:05
 */
public interface ContainerCmdService {

    /**
     * 创建容器
     *
     * @param containerCreateCmd the containerCreateCmd
     */
    void create(ContainerCreateCmd containerCreateCmd);
}
