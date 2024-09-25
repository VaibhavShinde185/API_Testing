package com.thetestingacademy.ex_2120924.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG008_alwaysRunEnable {

    @Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test02(){
        Assert.assertTrue(false);
        // if enabled is false then TestNG will skip this test case
    }

    @Test(alwaysRun = true)
    public void test03(){
        Assert.assertTrue(true);
    }
}
