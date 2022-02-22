package com.ql.ddd.port.demand.persistent.container.po;

import com.baomidou.mybatisplus.annotation.*;
import com.ql.ddd.port.demand.persistent.common.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wanqiuli
 * @date 2022/2/22 14:09
 */
@Data
@TableName("st_container")
@EqualsAndHashCode(callSuper = true)
public class ContainerPo extends BasePo {
    /**
     * 唯一id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父容器号
     */
    @TableField(value = "parent_container_no")
    private String parentContainerNo;
    /**
     * 容器号
     */
    @TableField(value = "container_no")
    private String containerNo;
    /**
     * 容器数量
     */
    @TableField(value = "number")
    private Integer number;
}
