package com.rimi.item.dao.impl;

import com.rimi.item.dao.IMemberDao;
import com.rimi.item.entity.Member;
import com.rimi.item.entity.Order;
import com.rimi.item.entity.User;
import com.rimi.item.util.JDBCUtils;
import com.rimi.item.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Wang Xiaoping
 * @date 2019/9/25 16:29
 */
public class MemberDaoImpl implements IMemberDao {
    @Override
    public void insert(Map<String, String[]> params) {
        // 1.定义sql
        String sql = "insert into member(username,sex,telephone,address) values(?,?,?,?)";
        // 2.执行
        JDBCUtils.executeUpdate(sql,
                params.get("username")[0],
                params.get("sex")[0],
                params.get("telephone")[0],
                params.get("address")[0]);

    }

    @Override
    public List<Member> selectAll() {
        // 1.定义SQL
        String sql = "select * from member";
        // 2.执行SQL
        return JDBCUtils.executeQuery(Member.class, sql);
    }

    @Override
    public List<Member> selectByPage(Integer currentPage, Integer pageSize) {
        // 定义SQL
        String sql = "select * from member limit ?,?";
        //if (currentPage > 0) {
        //    currentPage -= 1;
        //} else {
        //    currentPage = 0;
        //}
        // 判断当前开始的条数是否大于总条数
        // 执行SQL
        return JDBCUtils.executeQuery(Member.class, sql, currentPage, pageSize);
    }

    @Override
    public Integer count() {
        // 定义sql
        String sql = "select count(1) from member";
        // 执行
        return JDBCUtils.executeQueryForCount(sql);
    }

    @Override
    public Member selectById(String id) {
        // 定义SQL
        String sql = "select * from member where id = ?";
        return JDBCUtils.executeQueryForOne(Member.class, sql, id);
    }

    @Override
    public Integer update(Map<String, String[]> params) {
        // 定义SQL
        String sql = "update member set " +
                "username = ?, " +
                "sex = ?, " +
                "telephone = ?, " +
                "address = ?  where id = ?";
        // 执行
     return   JDBCUtils.executeUpdate(sql,
                params.get("username")[0],
                params.get("sex")[0],
                params.get("telephone")[0],
                params.get("address")[0],
                params.get("id")[0]);
    }

    @Override
    public void deleteById(Integer id) {
        // 定义sql
        String sql = "delete from member where id = ?";
        JDBCUtils.executeUpdate(sql, id);
    }

    @Override
    public Integer count(Map<String, String[]> parms) {
        // 根据条件拼接sql
        StringBuffer sql = new StringBuffer("select count(1) from member where 1 = 1");
        List<String> parmsSql = new ArrayList<>();
        if (parms.get("username") != null && StringUtils.isNotEmpty(parms.get("username")[0])) {
            sql.append(" and username like ?");
            parmsSql.add("%"+parms.get("username")[0]+"%");
        }
        if (parms.get("sex") != null && StringUtils.isNotEmpty(parms.get("sex")[0])) {
            sql.append(" and sex like ?");
            parmsSql.add("%"+parms.get("sex")[0]+"%");
        }
        if (parms.get("telephone") != null && StringUtils.isNotEmpty(parms.get("telephone")[0])) {
            sql.append(" and telephone like ?");
            parmsSql.add("%"+parms.get("telephone")[0]+"%");
        }
        if (parms.get("address") != null && StringUtils.isNotEmpty(parms.get("address")[0])) {
            sql.append(" and address like ?");
            parmsSql.add("%"+parms.get("addrss")[0]+"%");
        }
        return JDBCUtils.executeQueryForCount(sql.toString(), parmsSql);
    }

    @Override
    public List<Member> selectByPage(Integer currentSize, Integer pageSize, Map<String, String[]> parms) {
        // 根据条件拼接sql
        StringBuffer sql = new StringBuffer("select * from member where 1 = 1");
        List<Object> parmsSql = new ArrayList<>();
        if (parms.get("username") != null && StringUtils.isNotEmpty(parms.get("username")[0])) {
            sql.append(" and username like ?");
            parmsSql.add("%"+parms.get("username")[0]+"%");
        }
        if (parms.get("sex") != null && StringUtils.isNotEmpty(parms.get("sex")[0])) {
            sql.append(" and sex like ?");
            parmsSql.add("%"+parms.get("sex")[0]+"%");
        }
        if (parms.get("telephone") != null && StringUtils.isNotEmpty(parms.get("telephone")[0])) {
            sql.append(" and telephone like ?");
            parmsSql.add("%"+parms.get("telephone")[0]+"%");
        }
        if (parms.get("address") != null && StringUtils.isNotEmpty(parms.get("address")[0])) {
            sql.append(" and address like ?");
            parmsSql.add("%"+parms.get("addrss")[0]+"%");
        }
        // 追加分页
        sql.append(" limit ?,?");
        parmsSql.add(currentSize);
        parmsSql.add(pageSize);
        return JDBCUtils.executeQuery(Member.class, sql.toString(), parmsSql);
    }
}
