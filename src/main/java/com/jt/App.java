package com.jt;

import com.jt.qa.TestOne;
import com.jt.qa.TestThress;
import com.jt.qa.TestTwo;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
       TestNG testng = new TestNG();
       List<String> suites = new ArrayList<>();
       suites.add("testNg.xml");
       testng.setTestSuites(suites);
       testng.run();
    }

}
