package com.thetestingacademy.ex_2120924.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_003_TestNGAssertions {

//@Test
//public void hardAssert(){
//    Assert.assertTrue(false);
//    // The above statement throw an assertion error  and stop execution
//    System.out.println("This line would not be executed");
// }

    @Test
    public void softAssert(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        // The above statement would not stop execution
        System.out.println("This line will executed");
        softAssert.assertAll(); // this will report all collected errors
    }

}
