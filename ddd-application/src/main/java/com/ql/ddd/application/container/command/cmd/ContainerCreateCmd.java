package com.ql.ddd.application.container.command.cmd;

import com.ql.ddd.core.model.Command;
import com.ql.ddd.domain.container.Container;
import com.ql.ddd.domain.container.StockContainer;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author wanqiuli
 * @date 2022/2/23 10:00
 */
@Data
public class ContainerCreateCmd implements Command {

    private String parentContainerNo;

    @NotBlank(message = "容器号不能为空")
    private String containerNo;

    private Integer number;

    public StockContainer toContainer() {
        return new StockContainer(parentContainerNo, containerNo, number);
    }
}
