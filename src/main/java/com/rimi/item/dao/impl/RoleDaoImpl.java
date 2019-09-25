package com.rimi.item.dao.impl;

import com.rimi.item.dao.IRoleDao;
import com.rimi.item.entity.Role;
import com.rimi.item.entity.User;
import com.rimi.item.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Wang Xiaoping
 * @date 2019/9/24 22:21
 */
public class RoleDaoImpl implements IRoleDao {
    @Override
    public void insert(Map<String, String[]> params) {
        // 1.定义sql
        String sql = "insert into role(role_name,role_rule,role_description) values (?,?,?)";
        // 2.执行
        JDBCUtils.executeUpdate(sql,
                params.get("roleName")[0],
                params.get("roleRule")[0],
                params.get("roleDescription")[0]);

    }

    @Override
    public List<Role> selectAll() {
        // 1.定义SQL
        String sql = "select * from role";
        // 2.执行SQL
        return JDBCUtils.executeQuery(Role.class, sql);
    }

    @Override
    public List<Role> selectByPage(Integer currentPage, Integer pageSize) {
        // 定义SQL
        String sql = "select * from role limit ?,?";
        //if (currentPage > 0) {
        //    currentPage -= 1;
        //} else {
        //    currentPage = 0;
        //}
        // 判断当前开始的条数是否大于总条数
        // 执行SQL
        return JDBCUtils.executeQuery(Role.class, sql, currentPage, pageSize);
    }

    @Override
    public Integer count() {
        // 定义sql
        String sql = "select count(1) from role";
        // 执行
        return JDBCUtils.executeQueryForCount(sql);
    }

    @Override
    public Role selectById(String id) {
        // 定义SQL
        String sql = "select * from role where id = ?";
        return JDBCUtils.executeQueryForOne(Role.class, sql, id);
    }

    @Override
    public void update(Map<String, String[]> params) {
        // 定义SQL
        String sql = "update role set " +
                "role_name = ?, " +
                "role_rule = ?, " +
                "role_description = ? where id = ?";
        // 执行
        JDBCUtils.executeUpdate(sql,
                params.get("roleName")[0],
                params.get("roleRule")[0],
                params.get("roleDescription")[0]);
    }

    @Override
    public void deleteById(Integer id) {
        // 定义sql
        String sql = "delete from role where id = ?";
        JDBCUtils.executeUpdate(sql, id);
    }
}
