package com.thetestingacademy.ex_210924.C.R.U.D;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestCaseIntegrationA {
   String token;
   String bookingID;
   RequestSpecification requestSpecification;
   ValidatableResponse validatableResponse;
   Response response;

   public String createToken(){
       String createTokenPayload="{\n" +
               "    \"username\" : \"admin\",\n" +
               "    \"password\" : \"password123\"\n" +
               "}";
       RequestSpecification r = RestAssured.given();
       r.baseUri("https://restful-booker.herokuapp.com");
       r.basePath("/auth");
       r.contentType(ContentType.JSON).log().all();
       r.body(createTokenPayload);

       Response response = r.when().post();
       ValidatableResponse validatableResponse = response.then();
       validatableResponse.statusCode(200);

       token = response.jsonPath().getString("token");
       System.out.println(token);
       return token;
   }

   public String createBooking(){
       String createBoookingPayload = "{\n" +
               "    \"firstname\" : \"John\",\n" +
               "    \"lastname\" : \"Doe\",\n" +
               "    \"totalprice\" : 111,\n" +
               "    \"depositpaid\" : false,\n" +
               "    \"bookingdates\" : {\n" +
               "        \"checkin\" : \"2024-01-01\",\n" +
               "        \"checkout\" : \"2024-01-01\"\n" +
               "    },\n" +
               "    \"additionalneeds\" : \"Lunch\"\n" +
               "}";

    requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(createBoookingPayload).log().all();

    Response response = requestSpecification.when().post();

    validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    bookingID = response.jsonPath().getString("bookingid");
        System.out.println(bookingID);
        return bookingID;
   }

//    public String getBookingID() {
//        String payload_POST= "{\n" +
//                "    \"firstname\" : \"Pramod\",\n" +
//                "    \"lastname\" : \"Dutta\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : false,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2024-01-01\",\n" +
//                "        \"checkout\" : \"2024-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Lunch\"\n" +
//                "}";
//
//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
//        requestSpecification.basePath("/booking");
//        requestSpecification.contentType(ContentType.JSON);
//        requestSpecification.body(payload_POST).log().all();
//
//        Response response = requestSpecification.when().post();
//
//        validatableResponse = response.then().log().all();
//        validatableResponse.statusCode(200);
//
//        bookingID = response.jsonPath().getString("bookingid");
//        System.out.println(bookingID);
//        return bookingID;
//    }


    @Test
   public void updateBooking(){
       token = createToken();
       bookingID =  createBooking();
        String updateBookingPayload = "{\n" +
                "    \"firstname\" : \"vaibhav\",\n" +
                "    \"lastname\" : \"shinde\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+ bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(updateBookingPayload).log().all();

        Response response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

   }


}
