package com.rimi.item.service.impl;

import com.rimi.item.common.LoginConstant;
import com.rimi.item.common.Page;
import com.rimi.item.dao.IUserDao;
import com.rimi.item.dao.impl.UserDaoImpl;
import com.rimi.item.entity.User;
import com.rimi.item.service.ILoginService;
import com.rimi.item.util.PwdUtils;
import com.rimi.item.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author Wang Xiaoping
 * @date 2019/9/23 15:35
 */
public class LoginServiceImpl implements ILoginService {
    private IUserDao userDao=new UserDaoImpl();
    @Override
    public boolean selectByUsernameAndPassword(String username, String password, HttpServletRequest request) {
        if(StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(password)) {
            User user = userDao.selectByUsernameAndPassword(username, PwdUtils.getPwd(username + password));
            if(user!=null) {
                HttpSession session = request.getSession();
                session.setAttribute(LoginConstant.LOGIN_USERNAME,username);
                return true;
            }
        }
        return false;
    }
    @Override
    public void save(Map<String, String[]> params) {
        // 把数据插入到数据库中
        userDao.insert(params);
    }

    @Override
    public List<User> getAll() {
        // 查询数据库
        return userDao.selectAll();
    }
    @Override
    public Page<User> findPagedBooks(Page page) {
        // 分页查询
        // 0. 获取分页的条件
        Integer currentPage = page.getCurrentPage();
        Integer pageSize = page.getPageSize();
        if (currentPage > 0) {
            currentPage -= 1;
        } else {
            currentPage = 0;
        }
        // 1. 通过查询获取总条数
        Integer count = userDao.count();
        page.setTotalCount(count);
        // 判断分页开始的位置是否大于总条数
        int currentSize = currentPage * pageSize;
        if (currentSize > count){
            // (5-1)*10   38
            // 获取总分页数
            currentSize = (page.getPageCount() - 1) * pageSize;
        }
        // 2. 通过分页条件查询,并获取结果列表
        List<User> usersList = userDao.selectByPage(currentSize,pageSize);
        // 把结果存放到page对象中
        page.setPageData(usersList);
        return page;
    }

    @Override
    public User findById(String id) {
        if (StringUtils.isNotEmpty(id)){
            // 调用Dao方法,获取数据
            return userDao.selectById(id);
        }
        return null;
    }

    @Override
    public void update(Map<String, String[]> parameterMap) {
        userDao.update(parameterMap);
    }

    @Override
    public void deleteById(Integer id) {
        // 删除
        userDao.deleteById(id);
    }

    @Override
    public void deleteByIds(String[] ids) {
        for (String id : ids) {
            deleteById(Integer.valueOf(id));
        }
    }
}
