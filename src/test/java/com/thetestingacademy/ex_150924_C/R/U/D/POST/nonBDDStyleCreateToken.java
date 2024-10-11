package com.thetestingacademy.ex_150924_C.R.U.D.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class nonBDDStyleCreateToken {

    static String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    public static void main(String[] args) {
        //Given - RequestSpecification
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        //When - Response
    Response response = r.when().post();

        //Then - ValidatableResponse
        ValidatableResponse vr = response.then();
        vr.log().all().statusCode(200);

    }
}
