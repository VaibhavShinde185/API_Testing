package com.thetestingacademy.ex_150924_C.R.U.D.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class createBooking {

    static String payload = "{\n" +
            "    \"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    public static void main(String[] args) {

        RequestSpecification rS = RestAssured.given();
        rS.baseUri("https://restful-booker.herokuapp.com");
        rS.basePath("/booking");
        rS.contentType(ContentType.JSON).log().all();
        rS.body(payload);

        Response r = rS.when().post();

        ValidatableResponse vR = r.then().log().all().statusCode(200);
    }
}
