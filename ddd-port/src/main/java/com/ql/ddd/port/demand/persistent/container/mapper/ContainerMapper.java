package com.ql.ddd.port.demand.persistent.container.mapper;

import com.ql.ddd.domain.container.StockContainer;
import com.ql.ddd.port.demand.persistent.container.po.ContainerPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author wanqiuli
 * @date 2022/2/22 14:08
 */
@Mapper
public interface ContainerMapper {
    ContainerMapper MAPPER = Mappers.getMapper(ContainerMapper.class);

    /**
     * function is toContainer
     *
     * @param containerPo the containerPo
     * @return the {@link StockContainer} data
     */
    StockContainer toContainer(ContainerPo containerPo);

    /**
     * function is toContainerPo
     *
     * @param stockContainer the stockContainer
     * @return the {@link ContainerPo} data
     */
    ContainerPo toContainerPo(StockContainer stockContainer);
}
