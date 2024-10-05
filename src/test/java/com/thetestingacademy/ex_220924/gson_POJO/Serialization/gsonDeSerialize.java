package com.thetestingacademy.ex_220924.gson_POJO.Serialization;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class gsonDeSerialize {

    RequestSpecification rS = RestAssured.given();
    Response r;
    ValidatableResponse vR;

    @Description("TC1 - Verify that create booking is working with valid payload")
    @Test
    public void testPost() {

        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(9999);
        booking.setDepositpaid(true);


        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-10-01");
        bookingdates.setCheckout("2024-10-03");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");

        System.out.println(booking);
        // We need to convert the Java object of POJO classes onto byteStream or JsonString so that we can transfer over HTTP - known as Serialization

        Gson gson = new Gson();
        String payloadCreateBooking = gson.toJson(booking);
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
        System.out.println(bR.getBooking().getFirstname());

        assertThat(bR.getBooking().getFirstname()).isEqualTo("James").isNotEmpty().isNotNull();

    }
}
