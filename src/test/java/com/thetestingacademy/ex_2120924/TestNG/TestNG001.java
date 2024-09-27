package com.thetestingacademy.ex_2120924.TestNG;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG001 {
    //the number of less annotation you use, you will have less confusion
    //always try to keep them simple

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that true == rtue")
    @Test
    public void testCase01(){
        Assert.assertEquals(true, true);
    }

    @Severity(SeverityLevel.BLOCKER )
    @Description("Verify that false == true")
    @Test
    public void testCase02(){
        Assert.assertEquals(false, true);
    }

}
