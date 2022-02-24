package com.ql.ddd.application.container.command.repository;

import com.ql.ddd.domain.container.Container;
import com.ql.ddd.domain.container.StockContainer;

/**
 * @author wanqiuli
 * @date 2022/2/22 14:06
 */
public interface ContainerRepository {

    /**
     * function is byContainerNo
     *
     * @param containerNo the containerNo
     * @return the {@link Container} data
     */
    Container byContainerNo(String containerNo);

    /**
     * function is save
     *
     * @param stockContainer the stockContainer
     */
    void save(StockContainer stockContainer);
}
