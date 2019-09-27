package com.rimi.item.dao.impl;

import com.rimi.item.dao.IOrderDao;
import com.rimi.item.entity.Order;
import com.rimi.item.entity.User;
import com.rimi.item.util.JDBCUtils;
import com.rimi.item.util.StringUtils;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
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
    public Integer update(Map<String, String[]> params) {
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
      return   JDBCUtils.executeUpdate(sql,
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
    @Override
    public Integer count(Map<String, String[]> parms) {
        // 根据条件拼接sql
        StringBuffer sql = new StringBuffer("select count(1) from orders where 1 = 1");
        List<Object> parmsSql = new ArrayList<>();
        if (parms.get("orderNumber") != null && StringUtils.isNotEmpty(parms.get("orderNumber")[0])) {
            sql.append(" and order_number like ?");
            parmsSql.add("%"+parms.get("orderNumber")[0]+"%");
        }
        if (parms.get("orderPerson") != null && StringUtils.isNotEmpty(parms.get("orderPerson")[0])) {
            sql.append(" and order_person like ?");
            parmsSql.add("%"+parms.get("orderPerson")[0]+"%");
        }
        if (parms.get("orderSum") != null && StringUtils.isNotEmpty(parms.get("orderSum")[0])) {
            sql.append(" and order_sum like ?");
            parmsSql.add("%"+parms.get("orderSum")[0]+"%");
        }
        if (parms.get("orderMoney") != null && StringUtils.isNotEmpty(parms.get("orderMoney")[0])) {
            sql.append(" and order_money like ?");
            parmsSql.add("%"+parms.get("orderMoney")[0]+"%");
        }
        if (parms.get("orderStatus") != null && StringUtils.isNotEmpty(parms.get("orderStatus")[0])) {
            sql.append(" and order_status like ?");
            parmsSql.add("%"+parms.get("orderStatus")[0]+"%");
        }
        if (parms.get("moneyStatus") != null && StringUtils.isNotEmpty(parms.get("moneyStatus")[0])) {
            sql.append(" and money_status like ?");
            parmsSql.add("%"+parms.get("moneyStatus")[0]+"%");
        }
        if (parms.get("goodStatus") != null && StringUtils.isNotEmpty(parms.get("goodStatus")[0])) {
            sql.append(" and good_status like ?");
            parmsSql.add("%"+parms.get("goodStatus")[0]+"%");
        }
        if (parms.get("moneyStyle") != null && StringUtils.isNotEmpty(parms.get("moneyStyle")[0])) {
            sql.append(" and money_style like ?");
            parmsSql.add("%"+parms.get("moneyStyle")[0]+"%");
        }
        if (parms.get("sendStyle") != null && StringUtils.isNotEmpty(parms.get("sendStyle")[0])) {
            sql.append(" and send_style like ?");
            parmsSql.add("%"+parms.get("sendStyle")[0]+"%");
        }
        if (parms.get("orderTime") != null && StringUtils.isNotEmpty(parms.get("orderTime")[0])) {
            sql.append(" and order_time like ?");
            parmsSql.add("%"+parms.get("orderTime")[0]+"%");
        }
        return JDBCUtils.executeQueryForCount(sql.toString(), parmsSql);
    }

    @Override
    public List<Order> selectByPage(Integer currentSize, Integer pageSize, Map<String, String[]> parms) {
        // 根据条件拼接sql
        StringBuffer sql = new StringBuffer("select * from orders where 1 = 1");
        List<Object> parmsSql = new ArrayList<>();
        if (parms.get("orderNumber") != null && StringUtils.isNotEmpty(parms.get("orderNumber")[0])) {
            sql.append(" and order_number like ?");
            parmsSql.add("%"+parms.get("orderNumber")[0]+"%");
        }
        if (parms.get("orderPerson") != null && StringUtils.isNotEmpty(parms.get("orderPerson")[0])) {
            sql.append(" and order_person like ?");
            parmsSql.add("%"+parms.get("orderPerson")[0]+"%");
        }
        if (parms.get("orderSum") != null && StringUtils.isNotEmpty(parms.get("orderSum")[0])) {
            sql.append(" and order_sum like ?");
            parmsSql.add("%"+parms.get("orderSum")[0]+"%");
        }
        if (parms.get("orderMoney") != null && StringUtils.isNotEmpty(parms.get("orderMoney")[0])) {
            sql.append(" and order_money like ?");
            parmsSql.add("%"+parms.get("orderMoney")[0]+"%");
        }
        if (parms.get("orderStatus") != null && StringUtils.isNotEmpty(parms.get("orderStatus")[0])) {
            sql.append(" and order_status like ?");
            parmsSql.add("%"+parms.get("orderStatus")[0]+"%");
        }
        if (parms.get("moneyStatus") != null && StringUtils.isNotEmpty(parms.get("moneyStatus")[0])) {
            sql.append(" and money_status like ?");
            parmsSql.add("%"+parms.get("moneyStatus")[0]+"%");
        }
        if (parms.get("goodStatus") != null && StringUtils.isNotEmpty(parms.get("goodStatus")[0])) {
            sql.append(" and good_status like ?");
            parmsSql.add("%"+parms.get("goodStatus")[0]+"%");
        }
        if (parms.get("moneyStyle") != null && StringUtils.isNotEmpty(parms.get("moneyStyle")[0])) {
            sql.append(" and money_style like ?");
            parmsSql.add("%"+parms.get("moneyStyle")[0]+"%");
        }
        if (parms.get("sendStyle") != null && StringUtils.isNotEmpty(parms.get("sendStyle")[0])) {
            sql.append(" and send_style like ?");
            parmsSql.add("%"+parms.get("sendStyle")[0]+"%");
        }
        if (parms.get("orderTime") != null && StringUtils.isNotEmpty(parms.get("orderTime")[0])) {
            sql.append(" and order_time like ?");
            parmsSql.add("%"+parms.get("orderTime")[0]+"%");
        }
        // 追加分页
        sql.append(" limit ?,?");
        parmsSql.add(currentSize);
        parmsSql.add(pageSize);
        return JDBCUtils.executeQuery(Order.class, sql.toString(), parmsSql);
    }
}
