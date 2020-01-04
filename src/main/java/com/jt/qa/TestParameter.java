package com.jt.qa;

import com.beust.jcommander.Parameter;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author: jiangtao
 * @create: 2020/1/1
 * @description: TestParameter
 **/

public class TestParameter {
    @Test
    public void testPara(ITestContext context){
        String name1 = context.getSuite().getParameter("data1");
        String name2 = context.getSuite().getParameter("data2");

    }
//    @Test
//    @Parameters({"data1","data2"})
//    public void testPara2(String data1,String data2){
//        System.out.println(data1);
//        System.out.println(data2);
//        Assert.assertEquals("jiangtao",data1);
//    }

}
