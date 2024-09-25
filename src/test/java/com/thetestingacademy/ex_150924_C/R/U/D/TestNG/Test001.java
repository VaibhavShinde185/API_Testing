package com.thetestingacademy.ex_150924_C.R.U.D.TestNG;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test001 {

    @Test
    public void test_get(){

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/in/400072")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}
