package com.ql.ddd.application.container.command.cmd;

import com.ql.ddd.core.model.Command;
import lombok.Data;

/**
 * @author wanqiuli
 * @date 2022/2/22 14:07
 */
@Data
public class ContainerAddCmd implements Command {

    /**
     * 源容器号
     */
    private String srcContainerNo;
    /**
     * 目的容器号
     */
    private String targetContainerNo;
}
