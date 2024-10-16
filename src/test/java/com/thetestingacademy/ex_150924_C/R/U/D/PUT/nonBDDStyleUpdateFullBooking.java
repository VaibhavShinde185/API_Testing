package com.thetestingacademy.ex_150924_C.R.U.D.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class nonBDDStyleUpdateFullBooking {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void test_put() {

        String token = "96bd459d3105dfc";
        int bookingid = 1561 ;

        String payloadPut = "{\n" +
                "                \"firstname\" : \"Denab\",\n" +
                "                \"lastname\" : \"Cygnus\",\n" +
                "                \"totalprice\" : 111,\n" +
                "                \"depositpaid\" : true,\n" +
                "                \"bookingdates\" : {\n" +
                "            \"checkin\" : \"2018-01-01\",\n" +
                "                    \"checkout\" : \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+ bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payloadPut).log().all();

        Response response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }


}



