package com.rimi.item.service;

import com.rimi.item.common.Page;
import com.rimi.item.entity.Order;
import com.rimi.item.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 订单信息处理
 *
 * @author Wang Xiaoping
 * @date 2019/9/25 7:42
 */
public interface IOrderService {
    void save(Map<String, String[]> params);
    List<Order> getAll();
    Page<Order> findPagedBooks(Page page);
    Order findById(String id);
    boolean update(Map<String, String[]> parameterMap);
    void deleteById(Integer id);
    void deleteByIds(String[] ids);
    Page<Order> findPagedBooks( Map<String, String[]> parms,Page page);
}
