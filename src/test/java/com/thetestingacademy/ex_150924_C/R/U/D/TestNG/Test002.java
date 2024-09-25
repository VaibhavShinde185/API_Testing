package com.thetestingacademy.ex_150924_C.R.U.D.TestNG;

import org.testng.annotations.*;

public class Test002 {

    @BeforeSuite
    void demo1(){
        System.out.println("Before Suit");
    }

    @BeforeTest
    void demo2(){
        System.out.println("Before Test");
    }

    @BeforeClass
    void demo3(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("Before method");
    }

    @Test
    void demo5(){
        System.out.println("Test Case");
    }

    @AfterMethod
    void demo6(){
        System.out.println("After Method");
    }

    @AfterClass
    void demo7(){
        System.out.println("After Class");
    }

    @AfterTest
    void demo8(){
        System.out.println("After Test");
    }

    @AfterSuite
    void demo9(){
        System.out.println("After Suit");
    }

}
