package com.ql.ddd.port.demand.persistent.common.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author wanqiuli
 * @date 2022/2/22 16:50
 */
@Data
public class BasePo {
    /**
     * 创建用户
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private String createUser;
    /**
     * 更新用户
     */
    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    private String updateUser;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 版本号
     */
    @TableField(value = "ver")
    @Version
    private Integer ver;
    /**
     * 时间戳
     */
    @TableField(value = "ts", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Date ts;
    /**
     * 删除标志
     */
    @TableField(value = "deleted")
    @TableLogic
    private Integer deleted;
}
