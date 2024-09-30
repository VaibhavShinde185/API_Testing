package com.thetestingacademy.ex_220924.gson_POJO.Serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class withoutSerialization {

    RequestSpecification rS = RestAssured.given();
    Response r;
    ValidatableResponse vR;

    @Description("TC1 - Verify that create booking is working with valid payload")
    @Test
    public void testPost(){
        String baseURL = "https://restful-booker.herokuapp.com";
        String basePath = "/booking";
        String firstname = "Vaibhav";

        String payloadCreateBooking = "{\"firstname\":\"Vaibhav\",\"lastname\":\"Shinde\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Lunch\"}\n";

        rS.baseUri(baseURL);
        rS.basePath(basePath);
        rS.contentType(ContentType.JSON);
        rS.body(payloadCreateBooking).log().all();

        r = rS.when().post();
        String responseString = r.asString();

        vR = r.then().statusCode(200).log().all();


    }

}
