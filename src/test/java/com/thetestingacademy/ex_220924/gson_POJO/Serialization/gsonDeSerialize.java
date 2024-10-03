package com.thetestingacademy.ex_220924.gson_POJO.Serialization;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class gsonDeSerialize {

    RequestSpecification rS = RestAssured.given();
    Response r;
    ValidatableResponse vR;

    @Description("TC1 - Verify that create booking is working with valid payload")
    @Test
    public void testPost() {

        booking bk = new booking();
        bk.setFirstname("James");
        bk.setLastname("Brown");
        bk.setTotalprice(9999);
        bk.setDepositpaid(true);


        bookingdates bkdt = new bookingdates();
        bk.setBkdt(bkdt);
        bkdt.setCheckin("2024-10-01");
        bkdt.setCheckout("2024-10-03");

        bk.setAdditionalneeds("Lunch");

        System.out.println(bk);
        // We need to convert the Java object of POJO classes onto byteStream or JsonString so that we can transfer over HTTP - known as Serialization

        Gson gson = new Gson();
        String payloadCreateBooking = gson.toJson(bk);
        System.out.println(payloadCreateBooking);


        String baseURL = "https://restful-booker.herokuapp.com/";
        String basePath = "/booking";

        rS.baseUri(baseURL);
        rS.basePath(basePath);
        rS.contentType(ContentType.JSON);
        rS.body(payloadCreateBooking).log().all();

        r = rS.when().post();
        System.out.println(r.asString());

        vR = r.then().statusCode(200).log().all();

        // Parse - DeSerialize

        bookingResponse bR = gson.fromJson(r.asString(), bookingResponse.class);
        System.out.println(bR.getBookingid());

    }
}
