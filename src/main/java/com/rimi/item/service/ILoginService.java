package com.rimi.item.service;

import com.rimi.item.common.Page;
import com.rimi.item.entity.User;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 用户数据处理
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 15:33
 */
public interface ILoginService {
    boolean selectByUsernameAndPassword(String username, String password, HttpServletRequest request);
    void save(Map<String, String[]> params);
    List<User> getAll();
    Page<User> findPagedBooks(Page page);
    User findById(String id);
    boolean update(Map<String, String[]> parameterMap);
    void deleteById(Integer id);
    void deleteByIds(String[] ids);
    Page<User> findPagedBooks( Map<String, String[]> parms,Page page);
}
