package com.ql.ddd.port.supply.web.container;

import com.ql.ddd.application.container.command.ContainerCmdService;
import com.ql.ddd.application.container.command.cmd.ContainerCreateCmd;
import com.ql.ddd.core.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author wanqiuli
 * @date 2022/2/22 18:19
 */
@Slf4j
@RestController
@RequestMapping(value = "/web/container")
public class ContainerController {

    @Resource
    private ContainerCmdService containerCmdService;


    @PostMapping("/create")
    public Result<String> create(@RequestBody @Valid ContainerCreateCmd containerCreateCmd) {
        try {
            containerCmdService.create(containerCreateCmd);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Result.success("容器创建成功");
    }
}
