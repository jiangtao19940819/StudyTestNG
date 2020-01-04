package com.jt.qa;

import org.testng.annotations.*;

/**
 * @author: jiangtao
 * @create: 2019/12/31
 * @description: TestTwo
 **/

public class TestTwo {
//    @BeforeClass
//    public void beforeClassTwo(){
//        System.out.println("beforeClassTwo");
//    }
//    @AfterClass
//    public void afterClassTwo(){
//        System.out.println("afterClassTwo");
//    }
//
//    @BeforeMethod
//    public void beforeMethodTwo(){
//        System.out.println("beforeMethodTwo");
//    }
//
//    @AfterMethod
//    public void afterMethodTwo(){
//        System.out.println("afterMethodTwo");
//    }
    @Test
    public void testTwoOne(){
        System.out.println("testtwo");
    }

    @Test(expectedExceptions=ArithmeticException.class)
    public void testTwoTWO(){
        int a = 10/0;
    }

}
