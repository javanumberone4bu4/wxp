package com.rimi.item.dao;

import com.rimi.item.entity.Order;
import com.rimi.item.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 订单查询
 *
 * @author Wang Xiaoping
 * @date 2019/9/25 7:30
 */
public interface IOrderDao {
    void insert(Map<String, String[]> params);
    List<Order> selectAll();

    List<Order> selectByPage(Integer currentPage, Integer pageSize);

    Integer count();

    Order selectById(String id);

    Integer update(Map<String, String[]> parameterMap);

    void deleteById(Integer id);
    Integer count(Map<String, String[]> parms);
    List<Order> selectByPage(Integer currentSize, Integer pageSize, Map<String, String[]> parms);
}
