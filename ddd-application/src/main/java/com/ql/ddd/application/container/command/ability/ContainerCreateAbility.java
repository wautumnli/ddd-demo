package com.ql.ddd.application.container.command.ability;

import com.ql.ddd.application.common.ability.BaseAbility;
import com.ql.ddd.application.container.command.cmd.ContainerCreateCmd;
import com.ql.ddd.application.container.command.repository.ContainerRepository;
import com.ql.ddd.core.dto.Result;
import com.ql.ddd.core.util.ValidateUtil;
import com.ql.ddd.domain.container.Container;
import com.ql.ddd.domain.container.StockContainer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wanqiuli
 * @date 2022/2/23 10:45
 */
@Component
public class ContainerCreateAbility extends BaseAbility<ContainerCreateCmd, Void> {

    @Resource
    private ContainerRepository containerRepository;

    @Override
    public void checkCommand(ContainerCreateCmd command) {
        Container container = containerRepository.byContainerNo(command.getContainerNo());
        ValidateUtil.check(container == null, "容器已存在");
    }

    @Override
    public Result<Void> executeCommand(ContainerCreateCmd command) {
        // 转换成领域实体
        StockContainer stockContainer = command.toContainer();
        // 执行领域动作/行为
        stockContainer.create();
        // 存储领域实体
        containerRepository.save(stockContainer);
        return Result.success();
    }
}
