package com.rimi.item.service;

import com.rimi.item.common.Page;
import com.rimi.item.entity.Member;
import com.rimi.item.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 会员信息处理
 *
 * @author Wang Xiaoping
 * @date 2019/9/25 16:44
 */
public interface IMemberService {
    void save(Map<String, String[]> params);
    List<Member> getAll();
    Page<Member> findPagedBooks(Page page);
    Member findById(String id);
    boolean update(Map<String, String[]> parameterMap);
    void deleteById(Integer id);
    void deleteByIds(String[] ids);
    Page<Member> findPagedBooks(Map<String, String[]> parms, Page page);
}
