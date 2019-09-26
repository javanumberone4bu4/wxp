package com.rimi.item.dao;

import com.rimi.item.entity.Member;
import com.rimi.item.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 会员查询
 *
 * @author Wang Xiaoping
 * @date 2019/9/25 16:23
 */
public interface IMemberDao {
    void insert(Map<String, String[]> params);
    List<Member> selectAll();

    List<Member> selectByPage(Integer currentPage, Integer pageSize);

    Integer count();

    Member selectById(String id);

    Integer update(Map<String, String[]> parameterMap);

    void deleteById(Integer id);
}
