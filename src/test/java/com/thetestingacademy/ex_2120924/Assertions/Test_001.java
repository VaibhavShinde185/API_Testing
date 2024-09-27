package com.thetestingacademy.ex_2120924.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Test_001 {

    //Types of Assertions
        // 1. Rest Assured Default - Hamcrest
        // 2. TestNG Assertion
            //  --> Soft Assert
            //  --> Hard Assert
        // 3. AssertJ


//    RequestSpecification requestSpecification;
//    ValidatableResponse validatableResponse;
//    Response response;
//    String token;
//    String bookingID;
//
//    @Test
//    public void testPost() {
//    //creating token
//        String payload = "{\n" +
//                "    \"username\" : \"admin\",\n" +
//                "    \"password\" : \"password123\"\n" +
//                "}";
//
//        //Given - Request Specification
//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
//        requestSpecification.basePath("/auth");
//        requestSpecification.contentType(ContentType.JSON).log().all();
//        requestSpecification.body(payload);
//
//        //When - HTTP methods
//        Response response = requestSpecification.when().post();
//
//        //Then - ValidatableResponse
//        ValidatableResponse validatableResponse1 = response.then();
//        validatableResponse.log().all().statusCode(200);
//
//    }
}

