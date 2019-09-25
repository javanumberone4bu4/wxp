package com.rimi.item.dao;

import com.rimi.item.entity.Rule;
import com.rimi.item.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 权限分类信息查询
 *
 * @author Wang Xiaoping
 * @date 2019/9/24 22:50
 */
public interface IRuleDao {
    void insert(Map<String, String[]> params);
    List<Rule> selectAll();

    List<Rule> selectByPage(Integer currentPage, Integer pageSize);

    Integer count();

    Rule selectById(String id);

    void update(Map<String, String[]> parameterMap);

    void deleteById(Integer id);
}
