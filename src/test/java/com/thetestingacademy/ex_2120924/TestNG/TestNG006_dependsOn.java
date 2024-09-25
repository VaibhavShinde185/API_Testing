package com.thetestingacademy.ex_2120924.TestNG;

import org.testng.annotations.Test;

public class TestNG006_dependsOn {

    @Test
    public void serverStartedOk(){
        System.out.println("I will run first");
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void testMethod(){
        System.out.println("Method 1");
    }
}
