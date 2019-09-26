package com.rimi.item.dao.impl;

import com.rimi.item.dao.IUserDao;
import com.rimi.item.entity.User;
import com.rimi.item.util.JDBCUtils;
import com.rimi.item.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Wang Xiaoping
 * @date 2019/9/23 15:11
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username=? and password=?";
        return JDBCUtils.executeQueryForOne(User.class, sql, username, password);
    }
    @Override
    public void insert(Map<String, String[]> params) {
        // 1.定义sql
        String sql = "insert into user(username,password,telephone,email,join_time) values (?,?,?,?,?)";
        // 2.执行
        JDBCUtils.executeUpdate(sql,
                params.get("username")[0],
                params.get("password")[0],
                params.get("telephone")[0],
                params.get("email")[0],
                params.get("joinTime")[0]);
    }


    @Override
    public List<User> selectAll() {
        // 1.定义SQL
        String sql = "select * from user";
        // 2.执行SQL
        return JDBCUtils.executeQuery(User.class, sql);
    }

    @Override
    public List<User> selectByPage(Integer currentPage, Integer pageSize) {
        // 定义SQL
        String sql = "select * from user limit ?,?";
        //if (currentPage > 0) {
        //    currentPage -= 1;
        //} else {
        //    currentPage = 0;
        //}
        // 判断当前开始的条数是否大于总条数
        // 执行SQL
        return JDBCUtils.executeQuery(User.class, sql, currentPage, pageSize);
    }

    @Override
    public Integer count() {
        // 定义sql
        String sql = "select count(1) from user";
        // 执行
        return JDBCUtils.executeQueryForCount(sql);
    }

    @Override
    public User selectById(String id) {
        // 定义SQL
        String sql = "select * from user where id = ?";
        return JDBCUtils.executeQueryForOne(User.class, sql, id);
    }

    @Override
    public Integer update(Map<String, String[]> params) {
        // 定义SQL
        String sql = "update user set " +
                "username = ?, " +
                "password = ?, " +
                "telephone = ?, " +
                "email = ? , " +
                "join_time = ? where id = ?";
        // 执行
        return JDBCUtils.executeUpdate(sql,
                params.get("username")[0],
                params.get("password")[0],
                params.get("telephone")[0],
                params.get("email")[0],
                params.get("joinTime")[0],
                params.get("id")[0]);
    }

    @Override
    public void deleteById(Integer id) {
        // 定义sql
        String sql = "delete from user where id = ?";
        JDBCUtils.executeUpdate(sql, id);
    }
    @Override
    public Integer count(Map<String, String[]> parms) {
        // 根据条件拼接sql
        StringBuffer sql = new StringBuffer("select count(1) from user where 1 = 1");
        List<String> parmsSql = new ArrayList<>();
        if (parms.get("username") != null && StringUtils.isNotEmpty(parms.get("username")[0])) {
            sql.append(" and username like ?");
            parmsSql.add("%"+parms.get("username")[0]+"%");
        }
        if (parms.get("telephone") != null && StringUtils.isNotEmpty(parms.get("telephone")[0])) {
            sql.append(" and telephone like ?");
            parmsSql.add("%"+parms.get("telephone")[0]+"%");
        }
        if (parms.get("email") != null && StringUtils.isNotEmpty(parms.get("email")[0])) {
            sql.append(" and email like ?");
            parmsSql.add("%"+parms.get("email")[0]+"%");
        }
        if (parms.get("joinTime") != null && StringUtils.isNotEmpty(parms.get("joinTime")[0])) {
            sql.append(" and join_time like ?");
            parmsSql.add("%"+parms.get("joinTime")[0]+"%");
        }
        return JDBCUtils.executeQueryForCount(sql.toString(), parmsSql);
    }

    @Override
    public List<User> selectByPage(Integer currentSize, Integer pageSize, Map<String, String[]> parms) {
        // 根据条件拼接sql
        StringBuffer sql = new StringBuffer("select * from user where 1 = 1");
        List<Object> parmsSql = new ArrayList<>();
        if (parms.get("username") != null && StringUtils.isNotEmpty(parms.get("username")[0])) {
            sql.append(" and username like ?");
            parmsSql.add("%"+parms.get("username")[0]+"%");
        }
        if (parms.get("telephone") != null && StringUtils.isNotEmpty(parms.get("telephone")[0])) {
            sql.append(" and telephone like ?");
            parmsSql.add("%"+parms.get("telephone")[0]+"%");
        }
        if (parms.get("email") != null && StringUtils.isNotEmpty(parms.get("email")[0])) {
            sql.append(" and email like ?");
            parmsSql.add("%"+parms.get("email")[0]+"%");
        }
        if (parms.get("joinTime") != null && StringUtils.isNotEmpty(parms.get("joinTime")[0])) {
            sql.append(" and join_time like ?");
            parmsSql.add("%"+parms.get("joinTime")[0]+"%");
        }
        // 追加分页
        sql.append(" limit ?,?");
        parmsSql.add(currentSize);
        parmsSql.add(pageSize);
        return JDBCUtils.executeQuery(User.class, sql.toString(), parmsSql);
    }
}
