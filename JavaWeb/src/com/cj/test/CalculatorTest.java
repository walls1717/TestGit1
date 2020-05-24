package com.cj.test;

import com.cj.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试计算机类
 * @version 2020-5-19
 * @author CJ
 */
public class CalculatorTest {

    /**
     * 初始化方法
     * 用于资源申请，所有测试方法在执行前都会先执行该方法
     */
    @Before
    public void init() {
        System.out.println("init");
    }

    /**
     * 释放资源方法
     * 在所有测试方法执行完之后，都会自定执行该方法
     */
    @After
    public void close() {
        System.out.println("close");
    }

    @Test
    public void testAdd() {
        var cal = new Calculator();
        int result = cal.add(10, 2);
        System.out.println("add");
        System.out.println(result);

        // 断言
        Assert.assertEquals(12, result);
    }

    @Test
    public void testSub() {
        var cal = new Calculator();
        int result = cal.sub(10, 2);
        System.out.println("sub");
        System.out.println(result);

        // 断言
        Assert.assertEquals(8, result);
    }
}
