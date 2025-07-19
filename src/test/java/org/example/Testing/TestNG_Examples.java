package org.example.Testing;

import org.testng.annotations.*;

public class TestNG_Examples {

    @AfterSuite
    public void afterSuiteExample(){
        System.out.println("afterSuiteExample");
    }

    @Test(priority= 1)
    public void testExample(){
        System.out.println("testExample");
    }

    @Test(priority= 0)
    public void testExample0(){
        System.out.println("testExample0");
    }

    @BeforeTest()
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @AfterTest()
    public void afterTest(){
        System.out.println("afterTest");
    }

    @BeforeClass()
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass()
    public void afterClass(){
        System.out.println("afterClass");
    }

    @BeforeMethod()//run before every test
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @AfterMethod()//run after every test
    public void afterMethod(){
        System.out.println("afterMethod");
    }

    @BeforeSuite
    public void beforeSuiteExample(){
        System.out.println("beforeSuiteExample");
    }
}

