package com.ql.ddd.application.container.command.impl;

import com.ql.ddd.application.container.command.ContainerCmdService;
import com.ql.ddd.application.container.command.ability.ContainerCreateAbility;
import com.ql.ddd.application.container.command.cmd.ContainerCreateCmd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wanqiuli
 * @date 2022/2/22 14:07
 */
@Service
public class ContainerCmdServiceImpl implements ContainerCmdService {

    @Resource
    private ContainerCreateAbility containerCreateAbility;

    @Override
    public void create(ContainerCreateCmd containerCreateCmd) {
        containerCreateAbility.execute(containerCreateCmd);
    }
}
