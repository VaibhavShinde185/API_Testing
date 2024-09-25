package com.thetestingacademy.ex_2120924.TestNG;

import org.testng.annotations.Test;

public class TestNG005_TestCasesGrouping {

    @Test(groups = {"sanity", "qa", "e2e"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
    }

    @Test(groups = {"qa", "e2e","reg"})
    public void regressionRun(){
        System.out.println("Regression");
    }

    @Test(groups = {"dev"})
    public void smokeRun(){
        System.out.println("Smoke");
    }
}
