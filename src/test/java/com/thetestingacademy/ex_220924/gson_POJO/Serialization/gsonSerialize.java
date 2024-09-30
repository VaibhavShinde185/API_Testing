package com.thetestingacademy.ex_220924.gson_POJO.Serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class gsonSerialize {
    //  POJO - Plain Object Javascript Object
        // we create a class for the payload which is called as POJO class

    //  PUT request
    //  use hardcoded token and bookingid

    RequestSpecification rS = RestAssured.given();
    Response r;
    ValidatableResponse vR;

    @Description("TC1 - Verify that create booking is working with valid payload")
    @Test
    public void testPost(){
        String baseURL = "https://restful-booker.herokuapp.com";
        String basePath = "/booking";

        rS.baseUri(baseURL);
        rS.basePath(basePath);
        rS.contentType(ContentType.JSON);
        rS.body(payloadCreateBooking).log().all();

        r = rS.when().post();

        vR = r.then().statusCode(200).log().all();



    }

}
