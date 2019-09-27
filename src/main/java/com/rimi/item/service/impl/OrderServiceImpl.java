package com.rimi.item.service.impl;

import com.rimi.item.common.Page;
import com.rimi.item.dao.IOrderDao;
import com.rimi.item.dao.impl.OrderDaoImpl;
import com.rimi.item.entity.Order;
import com.rimi.item.entity.User;
import com.rimi.item.service.IOrderService;
import com.rimi.item.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Wang Xiaoping
 * @date 2019/9/25 7:44
 */
public class OrderServiceImpl implements IOrderService {
    private IOrderDao orderDao=new OrderDaoImpl();
    @Override
    public void save(Map<String, String[]> params) {
        // 把数据插入到数据库中
        orderDao.insert(params);
    }

    @Override
    public List<Order> getAll() {
        // 查询数据库
        return orderDao.selectAll();
    }
    @Override
    public Page<Order> findPagedBooks(Page page) {
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
        Integer count = orderDao.count();
        if (count == null) {
            count = 0;
        }
        page.setTotalCount(count);
        // 判断分页开始的位置是否大于总条数
        int currentSize = currentPage * pageSize;
        if (currentSize > count){
            // (5-1)*10   38
            // 获取总分页数
            currentSize = (page.getPageCount() - 1) * pageSize;
        }
        // 2. 通过分页条件查询,并获取结果列表
        List<Order> usersList = orderDao.selectByPage(currentSize,pageSize);
        // 把结果存放到page对象中
        page.setPageData(usersList);
        return page;
    }

    @Override
    public Order findById(String id) {
        if (StringUtils.isNotEmpty(id)){
            // 调用Dao方法,获取数据
            return orderDao.selectById(id);
        }
        return null;
    }

    @Override
    public boolean update(Map<String, String[]> parameterMap) {
        Integer update = orderDao.update(parameterMap);
        return update!=null&&update>0;
    }

    @Override
    public void deleteById(Integer id) {
        // 删除
        orderDao.deleteById(id);
    }

    @Override
    public void deleteByIds(String[] ids) {
        for (String id : ids) {
            deleteById(Integer.valueOf(id));
        }
    }

    @Override
    public Page<Order> findPagedBooks( Map<String, String[]> parms,Page page) {
        // 根据条件查询所有的记录
        Integer count = orderDao.count(parms);
        page.setTotalCount(count);
        // 调用方法
        List<Order> books = orderDao.selectByPage(page.getCurrentSize(), page.getPageSize(), parms);
        page.setPageData(books);
        return page;
    }
}
