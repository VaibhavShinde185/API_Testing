package com.thetestingacademy.ex_210924.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG002_passValuesToOtherTC {

    // PUT
    String token;
    Integer bookingID;

    @BeforeTest
    public void getToken() {
        token = "123";
     //   return token;
    }

    @BeforeTest
    public void getTokenAndBookingID() {
        // POST Req -
        // POST code
        bookingID = 999;
    }

    @Test
    public void testPUTReq() {
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq2() {
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq3() {
        System.out.println(token);
        System.out.println(bookingID);
    }

}
