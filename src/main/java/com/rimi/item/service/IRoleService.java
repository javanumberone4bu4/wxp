package com.rimi.item.service;

import com.rimi.item.common.Page;
import com.rimi.item.entity.Role;
import com.rimi.item.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 角色处理数据
 *
 * @author Wang Xiaoping
 * @date 2019/9/24 22:29
 */
public interface IRoleService {
    void save(Map<String, String[]> params);
    List<Role> getAll();
    Page<Role> findPagedBooks(Page page);
    Role findById(String id);
    void update(Map<String, String[]> parameterMap);
    void deleteById(Integer id);
    void deleteByIds(String[] ids);
}
