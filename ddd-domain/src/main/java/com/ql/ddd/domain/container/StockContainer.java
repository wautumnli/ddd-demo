package com.ql.ddd.domain.container;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wanqiuli
 * @date 2022/2/22 9:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StockContainer extends Container {

    public StockContainer(String parentContainerNo, String containerNo, Integer number) {
        setParentContainerNo(parentContainerNo);
        setContainerNo(containerNo);
        setNumber(number);
    }

    @Override
    public void add(Container container) {
        // 将一个容器加到另一个容器上
    }

    @Override
    public void create() {
        // 容器创建初始化动作, 此处简单化，实际包含复杂的初始化动作
        init();
    }
}
