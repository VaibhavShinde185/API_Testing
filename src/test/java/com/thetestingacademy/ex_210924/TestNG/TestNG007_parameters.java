package com.thetestingacademy.ex_210924.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG007_parameters {

    @Parameters("browser")
    @Test
    void demo1(String value){
        System.out.println("Browser is " + value);
        // Sending Browser Name i.e parameter by using xml file named as testng_parameter
    }
}
