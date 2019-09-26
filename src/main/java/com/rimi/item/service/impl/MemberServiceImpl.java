package com.rimi.item.service.impl;

import com.rimi.item.common.Page;
import com.rimi.item.dao.IMemberDao;
import com.rimi.item.dao.impl.MemberDaoImpl;
import com.rimi.item.entity.Member;
import com.rimi.item.service.IMemberService;
import com.rimi.item.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Wang Xiaoping
 * @date 2019/9/25 16:45
 */
public class MemberServiceImpl implements IMemberService {
    private IMemberDao memberDao=new MemberDaoImpl();
    @Override
    public void save(Map<String, String[]> params) {
        // 把数据插入到数据库中
        memberDao.insert(params);
    }

    @Override
    public List<Member> getAll() {
        // 查询数据库
        return memberDao.selectAll();
    }
    @Override
    public Page<Member> findPagedBooks(Page page) {
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
        Integer count = memberDao.count();
        page.setTotalCount(count);
        // 判断分页开始的位置是否大于总条数
        int currentSize = currentPage * pageSize;
        if (currentSize > count){
            // (5-1)*10   38
            // 获取总分页数
            currentSize = (page.getPageCount() - 1) * pageSize;
        }
        // 2. 通过分页条件查询,并获取结果列表
        List<Member> usersList = memberDao.selectByPage(currentSize,pageSize);
        // 把结果存放到page对象中
        page.setPageData(usersList);
        return page;
    }

    @Override
    public Member findById(String id) {
        if (StringUtils.isNotEmpty(id)){
            // 调用Dao方法,获取数据
            return memberDao.selectById(id);
        }
        return null;
    }

    @Override
    public boolean update(Map<String, String[]> parameterMap) {
        Integer result = memberDao.update(parameterMap);
        return result != null && result > 0;
    }

    @Override
    public void deleteById(Integer id) {
        // 删除
        memberDao.deleteById(id);
    }

    @Override
    public void deleteByIds(String[] ids) {
        for (String id : ids) {
            deleteById(Integer.valueOf(id));
        }
    }
}
