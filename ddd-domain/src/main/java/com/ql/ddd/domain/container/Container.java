package com.ql.ddd.domain.container;

import com.ql.ddd.domain.stock.Stock;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wanqiuli
 * @date 2022/2/22 9:42
 */
public abstract class Container {

    private Integer id;
    private String containerNo;
    private BigDecimal number;
    private List<Stock> stockList;

    public abstract void add(Container container);
}
