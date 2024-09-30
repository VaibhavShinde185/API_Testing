package com.thetestingacademy.ex_220924.Verification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class verification001 {

    @Test
    public void testVerify(){
        String response = "Vaibhav";
        Assert.assertEquals("Vaibhav", response);
    }
}
