package com.ql.ddd.port.supply.web.container;

import com.ql.ddd.application.container.command.ContainerCmdService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wanqiuli
 * @date 2022/2/22 18:19
 */
@RestController
@RequestMapping("/web/container")
public class ContainerController {

    @Resource
    private ContainerCmdService containerCmdService;
}
