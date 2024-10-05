package com.thetestingacademy.ex_220924.IntegrationTC;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class createBooking {
    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vR;

    @Description("TC1 - Verify that create booking is working with valid payload")
    @Test
    public void booking(){

        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(999);
        booking.setDepositpaid(true);

        booking.setAdditionalneeds("Breakfast");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-10-01");
        bookingdates.setCheckout("2024-10-03");
        booking.setBookingdates(bookingdates);

        Gson gson = new Gson();
        String payloadCreateBooking = gson.toJson(booking);
        System.out.println(payloadCreateBooking);

        String baseURL = "https://restful-booker.herokuapp.com";
        String basePath = "/booking";

        rs.baseUri(baseURL);
        rs.basePath(basePath);
        rs.contentType(ContentType.JSON).log().all();
        rs.body(payloadCreateBooking);

        r = rs.when().post();
        System.out.println(r.asString());

        vR = r.then().statusCode(200).log().all();

        BookingResponse bookingresponse = gson.fromJson(r.asString(), BookingResponse.class);

        System.out.println(bookingresponse.getBookingid());
        System.out.println(bookingresponse.getBooking().getFirstname());
        System.out.println(bookingresponse.getBooking().getLastname());

        assertThat((bookingresponse.getBookingid())).isNotZero().isNotNull();
        assertThat(bookingresponse.getBooking().getFirstname()).isEqualTo("Jim").isNotEmpty().isNotNull();

    }



}
