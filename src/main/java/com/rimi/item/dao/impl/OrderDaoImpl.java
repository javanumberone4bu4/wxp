package com.rimi.item.dao.impl;

import com.rimi.item.dao.IOrderDao;
import com.rimi.item.entity.Order;
import com.rimi.item.entity.User;
import com.rimi.item.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Wang Xiaoping
 * @date 2019/9/25 7:31
 */
public class OrderDaoImpl implements IOrderDao {
    @Override
    public void insert(Map<String, String[]> params) {
        // 1.定义sql
        String sql = "insert into orders(order_number,order_person,order_sum,order_money,order_status,money_status,good_status,money_style,send_style,order_time) values(?,?,?,?,?,?,?,?,?,?)";
        // 2.执行
        JDBCUtils.executeUpdate(sql,
                params.get("orderNumber")[0],
                params.get("orderPerson")[0],
                params.get("orderSum")[0],
                params.get("orderMoney")[0],
                params.get("orderStatus")[0],
                params.get("moneyStatus")[0],
                params.get("goodStatus")[0],
                params.get("moneyStyle")[0],
                params.get("sendStyle")[0],
                params.get("orderTime")[0]);

    }

    @Override
    public List<Order> selectAll() {
        // 1.定义SQL
        String sql = "select * from orders";
        // 2.执行SQL
        return JDBCUtils.executeQuery(Order.class, sql);
    }

    @Override
    public List<Order> selectByPage(Integer currentPage, Integer pageSize) {
        // 定义SQL
        String sql = "select * from orders limit ?,?";
        //if (currentPage > 0) {
        //    currentPage -= 1;
        //} else {
        //    currentPage = 0;
        //}
        // 判断当前开始的条数是否大于总条数
        // 执行SQL
        return JDBCUtils.executeQuery(Order.class, sql, currentPage, pageSize);
    }

    @Override
    public Integer count() {
        // 定义sql
        String sql = "select count(1) from orders";
        // 执行
        return JDBCUtils.executeQueryForCount(sql);
    }

    @Override
    public Order selectById(String id) {
        // 定义SQL
        String sql = "select * from orders where id = ?";
        return JDBCUtils.executeQueryForOne(Order.class, sql, id);
    }

    @Override
    public void update(Map<String, String[]> params) {
        // 定义SQL
        String sql = "update orders set " +
                "order_number = ?, " +
                "order_person = ?, " +
                "order_sum = ?, " +
                "order_money = ? , " +
                "order_status = ? , " +
                "money_status = ? , " +
                "good_status = ? , " +
                "money_style = ? , " +
                "send_style = ? , " +
                "order_time = ? where id = ?";
        // 执行
        JDBCUtils.executeUpdate(sql,
                params.get("orderNumber")[0],
                params.get("orderPerson")[0],
                params.get("orderSum")[0],
                params.get("orderMoney")[0],
                params.get("orderStatus")[0],
                params.get("moneyStatus")[0],
                params.get("goodStatus")[0],
                params.get("moneyStyle")[0],
                params.get("sendStyle")[0],
                params.get("orderTime")[0],
                params.get("id")[0]);
    }

    @Override
    public void deleteById(Integer id) {
        // 定义sql
        String sql = "delete from orders where id = ?";
        JDBCUtils.executeUpdate(sql, id);
    }
}
