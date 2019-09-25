package com.rimi.item.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Wang Xiaoping
 * @date 2019/9/23 16:40
 */
public class PwdUtilsTest {

    @Test
    public void getPwd() {
        String pwd = PwdUtils.getPwd("admin123");
        System.out.println(pwd);
    }
}