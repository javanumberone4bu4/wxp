package com.rimi.item.dao;

import com.rimi.item.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户信息数据库
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 15:10
 */
public interface IUserDao {
    User selectByUsernameAndPassword(String username,String password);
    void insert(Map<String, String[]> params);
    List<User> selectAll();

    List<User> selectByPage(Integer currentPage, Integer pageSize);

    Integer count();

    User selectById(String id);

    Integer update(Map<String, String[]> parameterMap);

    void deleteById(Integer id);
    Integer count(Map<String, String[]> parms);

    List<User> selectByPage(Integer currentSize, Integer pageSize, Map<String, String[]> parms);
}
