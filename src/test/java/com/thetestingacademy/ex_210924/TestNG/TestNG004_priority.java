package com.thetestingacademy.ex_210924.TestNG;

import org.testng.annotations.Test;

public class TestNG004_priority {

    @Test (priority = 2)
    public void getToken(){
        System.out.println("1");
    }

    @Test (priority = 1)
    public void getBookingID(){
        System.out.println("2");
    }

    @Test (priority = 0)
    public void test_PUT(){
        // token and BookingID
        System.out.println("3");
    }
}
// in the bigger framework we try to avoid the priorities because it is very difficult to maintain the priority
// Priority should done within the class level