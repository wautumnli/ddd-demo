package com.ql.ddd.port.demand.persistent.container.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ql.ddd.application.container.command.repository.ContainerRepository;
import com.ql.ddd.domain.container.Container;
import com.ql.ddd.domain.container.StockContainer;
import com.ql.ddd.port.demand.persistent.container.dao.ContainerDao;
import com.ql.ddd.port.demand.persistent.container.po.ContainerPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import static com.ql.ddd.port.demand.persistent.container.mapper.ContainerMapper.MAPPER;

/**
 * @author wanqiuli
 * @date 2022/2/22 14:18
 */
@Slf4j
@Repository
public class ContainerRepositoryImpl implements ContainerRepository {

    @Resource
    private ContainerDao containerDao;

    @Override
    public Container byContainerNo(String containerNo) {
        ContainerPo containerPo = containerDao.selectOne(Wrappers.<ContainerPo>lambdaQuery()
                .eq(ContainerPo::getContainerNo, containerNo));
        if (containerPo == null) {
            return null;
        }
        return MAPPER.toContainer(containerPo);
    }

    @Override
    public void save(StockContainer stockContainer) {
        ContainerPo containerPo = null;
        try {
            containerPo = MAPPER.toContainerPo(stockContainer);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        containerDao.insert(containerPo);
    }
}
