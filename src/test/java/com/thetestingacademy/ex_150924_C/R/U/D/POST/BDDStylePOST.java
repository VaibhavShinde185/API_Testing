package com.thetestingacademy.ex_150924_C.R.U.D.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDStylePOST {
    public static void main(String[] args) {

        // Payload can be given by three ways String, Classes and Hashmap

        String payload = "{\n" +
                "                \"username\" : \"admin\",\n" +
                "                \"password\" : \"password123\"\n" +
                "        }";

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON).log().all().body(payload)
                .when().post()
                .then().log().all().statusCode(200);
    }
}
