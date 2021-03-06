package com.rimi.item.dao;

import com.rimi.item.entity.Role;
import com.rimi.item.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 角色查询
 *
 * @author Wang Xiaoping
 * @date 2019/9/24 22:19
 */
public interface IRoleDao {
    void insert(Map<String, String[]> params);
    List<Role> selectAll();

    List<Role> selectByPage(Integer currentPage, Integer pageSize);

    Integer count();

    Role selectById(String id);

    Integer update(Map<String, String[]> parameterMap);

    void deleteById(Integer id);
    Integer count(Map<String, String[]> parms);

    List<Role> selectByPage(Integer currentSize, Integer pageSize, Map<String, String[]> parms);
}
