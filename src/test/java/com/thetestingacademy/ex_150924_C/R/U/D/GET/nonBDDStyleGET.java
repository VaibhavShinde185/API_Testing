package com.thetestingacademy.ex_150924_C.R.U.D.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class nonBDDStyleGET {

    static RequestSpecification r = RestAssured.given();

    public static void main(String[] args) {
        r.baseUri("https://api.zippopotam.us");
//        r.useRelaxedHTTPSValidation("TLS");   --Use this if facing SSL related issues
            testnonBDDStyle1();
            testnonBDDStyle2();
    }

    private static void testnonBDDStyle1() {
        r.basePath("in/400101");
        r.when().get();
        r.then().log().all().statusCode(200);
    }

    private static void testnonBDDStyle2() {
        r.basePath("in/400072");
        r.when().get();
        r.then().log().all().statusCode(200);
    }
}
