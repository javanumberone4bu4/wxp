package com.rimi.item.dao;

import com.rimi.item.dao.impl.UserDaoImpl;
import com.rimi.item.entity.User;
import com.rimi.item.util.JDBCUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Wang Xiaoping
 * @date 2019/9/23 16:31
 */
public class IUserDaoTest {
    private IUserDao userDao=new UserDaoImpl();

    @Test
    public void selectByUsernameAndPassword() {
        User user = userDao.selectByUsernameAndPassword("admin", "123");
        Assert.assertNotNull(user);
    }

    @Test
    public void insert() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void selectByPage() {
    }

    @Test
    public void count() {
    }

    @Test
    public void selectById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void testCount() {
    }

    @Test
    public void testSelectByPage() {
    }
}