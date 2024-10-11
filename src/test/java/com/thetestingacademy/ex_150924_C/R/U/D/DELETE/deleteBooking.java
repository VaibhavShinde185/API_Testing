package com.thetestingacademy.ex_150924_C.R.U.D.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class deleteBooking {

    RequestSpecification rS;
    Response r;
    ValidatableResponse vR;

    @Test
    public void testDelete(){

        String token = "1f7363272893b00";
        int bookingid = 6747 ;

        rS = RestAssured.given();
        rS.baseUri("https://restful-booker.herokuapp.com");
        rS.basePath("/booking/" + bookingid);
        rS.contentType(ContentType.JSON).log().all();
        rS.cookie("token", token);

        r = rS.when().delete();

        vR = r.then().statusCode(201).log().all();


    }

}
