package com.rimi.item.service.impl;

import com.rimi.item.common.Page;
import com.rimi.item.dao.IRuleDao;
import com.rimi.item.dao.impl.RuleDaoImpl;
import com.rimi.item.entity.Rule;
import com.rimi.item.entity.User;
import com.rimi.item.service.IRuleService;
import com.rimi.item.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Wang Xiaoping
 * @date 2019/9/24 22:57
 */
public class RuleServiceImpl implements IRuleService {
    private IRuleDao ruleDao=new RuleDaoImpl();
    @Override
    public void save(Map<String, String[]> params) {
        // 把数据插入到数据库中
        ruleDao.insert(params);
    }

    @Override
    public List<Rule> getAll() {
        // 查询数据库
        return ruleDao.selectAll();
    }
    @Override
    public Page<Rule> findPagedBooks(Page page) {
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
        Integer count = ruleDao.count();
        page.setTotalCount(count);
        // 判断分页开始的位置是否大于总条数
        int currentSize = currentPage * pageSize;
        if (currentSize > count){
            // (5-1)*10   38
            // 获取总分页数
            currentSize = (page.getPageCount() - 1) * pageSize;
        }
        // 2. 通过分页条件查询,并获取结果列表
        List<Rule> usersList = ruleDao.selectByPage(currentSize,pageSize);
        // 把结果存放到page对象中
        page.setPageData(usersList);
        return page;
    }

    @Override
    public Rule findById(String id) {
        if (StringUtils.isNotEmpty(id)){
            // 调用Dao方法,获取数据
            return ruleDao.selectById(id);
        }
        return null;
    }

    @Override
    public void update(Map<String, String[]> parameterMap) {
        ruleDao.update(parameterMap);
    }

    @Override
    public void deleteById(Integer id) {
        // 删除
        ruleDao.deleteById(id);
    }

    @Override
    public void deleteByIds(String[] ids) {
        for (String id : ids) {
            deleteById(Integer.valueOf(id));
        }
    }
}
