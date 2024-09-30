package com.thetestingacademy.ex_220924.POJOS;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POJO001 {
    // POJO - Plain Old Java Object
    // String Payload

    public static void main(String[] args) {
        String username = "Vaibhav";

        String payload  = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON).log().all().body(payload)
                .when().post()
                .then().log().all().statusCode(200);

    }

}
