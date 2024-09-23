package com.thetestingacademy.ex_150924_C.R.U.D.GET;

import io.restassured.RestAssured;

public class  BDDStyleGET {
    public static void main(String[] args) {

        test2();
        test1();
    }

    private static void test1(){
        RestAssured
                .given().relaxedHTTPSValidation()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/in/400072")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
    public static void test2(){
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/in/400101")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}
