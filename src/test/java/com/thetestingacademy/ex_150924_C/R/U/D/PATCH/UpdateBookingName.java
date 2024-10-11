package com.thetestingacademy.ex_150924_C.R.U.D.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class UpdateBookingName {

    RequestSpecification rS = RestAssured.given();
    Response r;
    ValidatableResponse vR;

    @Test
    public void testPatch(){

        String token = "96bd459d3105dfc";
        int bookingid = 1561 ;

        String payloadPatch = "{\n" +
                "    \"firstname\" : \"Vaibhav\",\n" +
                "    \"lastname\" : \"Shinde\"\n" +
                "}";

        rS.baseUri("https://restful-booker.herokuapp.com");
        rS.basePath("/booking/"+bookingid);
        rS.contentType(ContentType.JSON).log().all();
        rS.cookie("token", token);
        rS.body(payloadPatch).log().all();

        Response r = rS.when().patch();

        ValidatableResponse vR = r.then().log().all().statusCode(200);

    }

}
