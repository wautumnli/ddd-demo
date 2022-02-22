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
@Builder
public class StockContainer extends Container {

    @Override
    public void add(Container container) {
        // 将一个容器加到另一个容器上
    }
}
