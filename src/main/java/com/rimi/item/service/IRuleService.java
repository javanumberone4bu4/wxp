package com.rimi.item.service;

import com.rimi.item.common.Page;
import com.rimi.item.entity.Order;
import com.rimi.item.entity.Rule;

import java.util.List;
import java.util.Map;

/**
 * 权限分类信息处理
 *
 * @author Wang Xiaoping
 * @date 2019/9/24 22:56
 */
public interface IRuleService {
    void save(Map<String, String[]> params);
    List<Rule> getAll();
    Page<Rule> findPagedBooks(Page page);
    Rule findById(String id);
    boolean update(Map<String, String[]> parameterMap);
    void deleteById(Integer id);
    void deleteByIds(String[] ids);
    Page<Rule> findPagedBooks(Map<String, String[]> parms, Page page);
}
