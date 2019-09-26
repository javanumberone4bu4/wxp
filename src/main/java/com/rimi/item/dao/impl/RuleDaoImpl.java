package com.rimi.item.dao.impl;

import com.rimi.item.dao.IRuleDao;
import com.rimi.item.entity.Rule;
import com.rimi.item.entity.User;
import com.rimi.item.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Wang Xiaoping
 * @date 2019/9/24 22:53
 */
public class RuleDaoImpl implements IRuleDao {
    @Override
    public void insert(Map<String, String[]> params) {
        // 1.定义sql
        String sql = "insert into rule(classifyname) values (?)";
        // 2.执行
        JDBCUtils.executeUpdate(sql,
                params.get("classifyname")[0]);
    }

    @Override
    public List<Rule> selectAll() {
        // 1.定义SQL
        String sql = "select * from rule";
        // 2.执行SQL
        return JDBCUtils.executeQuery(Rule.class, sql);
    }

    @Override
    public List<Rule> selectByPage(Integer currentPage, Integer pageSize) {
        // 定义SQL
        String sql = "select * from rule limit ?,?";
        //if (currentPage > 0) {
        //    currentPage -= 1;
        //} else {
        //    currentPage = 0;
        //}
        // 判断当前开始的条数是否大于总条数
        // 执行SQL
        return JDBCUtils.executeQuery(Rule.class, sql, currentPage, pageSize);
    }

    @Override
    public Integer count() {
        // 定义sql
        String sql = "select count(1) from rule";
        // 执行
        return JDBCUtils.executeQueryForCount(sql);
    }

    @Override
    public Rule selectById(String id) {
        // 定义SQL
        String sql = "select * from rule where id = ?";
        return JDBCUtils.executeQueryForOne(Rule.class, sql, id);
    }

    @Override
    public Integer update(Map<String, String[]> params) {
        // 定义SQL
        String sql = "update rule set " +
                "classifyname = ? where id = ?";
        // 执行
       return JDBCUtils.executeUpdate(sql,
                params.get("classifyname")[0],
                params.get("id")[0]);
    }

    @Override
    public void deleteById(Integer id) {
        // 定义sql
        String sql = "delete from rule where id = ?";
        JDBCUtils.executeUpdate(sql, id);
    }
}
