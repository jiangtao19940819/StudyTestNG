package com.jt.qa;

import org.testng.annotations.DataProvider;

/**
 * @author: jiangtao
 * @create: 2020/1/1
 * @description: DataProvider
 **/

public class DataPro {
    @DataProvider(name="createData")
    public Object[][] createData(){
        return new Object[][]{
            {1,3},{2,2},{3,3}
        };
    }


}
