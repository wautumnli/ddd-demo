package com.ql.ddd.domain.container;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;


/**
 * @author wanqiuli
 * @date 2022/2/22 9:42
 */
@Data
public abstract class Container {

    private Long id;
    private String parentContainerNo;
    private String containerNo;
    private Integer number;

    /**
     * 容器添加领域动作
     *
     * @param container the container
     */
    public abstract void add(Container container);

    /**
     * function is create
     */
    public abstract void create();

    /**
     * 初始化容器动作
     */
    protected void init() {
        if (StringUtils.isBlank(parentContainerNo)) {
            this.parentContainerNo = "WQL_001";
        }
        if (Objects.isNull(number)) {
            this.number = 10;
        }
    }
}
