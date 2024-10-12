package com.thetestingacademy.ex_210924.C.R.U.D;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestCaseIntegration {

    //  Create a Token
    // Create a Booking
    //  Perform  a PUT request
    //  Verify that PUT is success by GET Request
    // Delete the ID
    // Verify it doesn't exist GET Request

    RequestSpecification rS;
    ValidatableResponse vR;
    Response r;
    String token;
    String bookingId;


    public String getToken() {
        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";
        // Given - Request Spec
        rS = RestAssured.given();
        rS.baseUri("https://restful-booker.herokuapp.com");
        rS.basePath("/auth");
        rS.contentType(ContentType.JSON).log().all();
        rS.body(payload);

        r = rS.when().post();

        vR = r.then();
        vR.statusCode(200);

        token = r.jsonPath().getString("token") ;
        System.out.println(token);
        return token;
    }

    public String getBookingID() {
        String payload_POST= "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        rS = RestAssured.given();
        rS.baseUri("https://restful-booker.herokuapp.com/");
        rS.basePath("/booking");
        rS.contentType(ContentType.JSON);
        rS.body(payload_POST).log().all();

        r = rS.when().post();

        vR = r.then().log().all();
        vR.statusCode(200);

        bookingId = r.jsonPath().getString("bookingid");
        System.out.println(bookingId);
        return bookingId;
    }

    @Test (priority = 1)
    public void test_update_request_put() {
        token = getToken();
        bookingId= getBookingID();
        String payloadPUT= "{\n" +
                "    \"firstname\" : \"Anshul\",\n" +
                "    \"lastname\" : \"Ji\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        rS = RestAssured.given();
        rS.baseUri("https://restful-booker.herokuapp.com/");
        rS.basePath("/booking/"+bookingId);
        rS.contentType(ContentType.JSON);
        rS.cookie("token",token);
        rS.body(payloadPUT).log().all();

        r = rS.when().put();

        vR = r.then().log().all();
        vR.statusCode(200);
    }

    @Test (priority = 2)
    public void test_get_bookingid() {
        System.out.println("Booking id of the above request is " + bookingId);
        System.out.println();
    }

    @Test (priority = 3)
    public void test_delete_booking() {
        rS = RestAssured.given();
        rS.baseUri("https://restful-booker.herokuapp.com/");
        rS.basePath("/booking/" + bookingId);
        rS.contentType(ContentType.JSON);
        rS.cookie("token", token).log().all();

        r = rS.when().delete();

        vR = r.then().statusCode(201);

        System.out.println(bookingId);
        System.out.println(token);
    }
//
//    @Test
//    public void test_after_delete_request_get() {
//        System.out.println(bookingId);
//        }

    }