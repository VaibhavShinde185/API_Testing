package com.thetestingacademy;

import io.restassured.RestAssured;

public class Test002 {
    public static void main(String[] args) {
        System.out.println("Rest Assured Test Case");
        System.out.println("Get Request");

        //Gherkins Syntax i.e
        // given() - url, headers, body or payload
        // when() - http methods like get, post, put, patch, delete
        // then() - verify the response i.e expected result == actual result

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/1").log().all()
                .when()
                    .get()
                .then().log().all()
                .statusCode(200);

            //if test case is passing it will give you no output
            //log().all() - it will print all the info. in the console 
    }

}
