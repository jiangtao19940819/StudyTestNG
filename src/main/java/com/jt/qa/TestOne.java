package com.jt.qa;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author: jiangtao
 * @create: 2019/12/31
 * @description: TestOne
 **/
public class TestOne {

    @BeforeClass
    public void beforeClassOne(){
        System.out.println("beforeClassOne");
    }
    @AfterClass
    public void afterClassOne(){
        System.out.println("afterClassOne");
    }

    @Test(enabled=false)
    public void testOneOne(){
        Assert.assertEquals(1,3);

    }
    @Test(dataProvider="createData",dataProviderClass=DataPro.class)
    public void testOneTwo(int a,int b){
        Assert.assertEquals(a,b);
    }

//    @DataPro(name="providerDataOne")
//    public Object[][] createProviderData(){
//        return new Object[][]{
//                {1,1},{2,3},{4,5},{8,8}
//        };
//    }
}
