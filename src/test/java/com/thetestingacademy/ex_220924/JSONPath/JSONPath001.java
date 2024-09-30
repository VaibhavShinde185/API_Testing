package com.thetestingacademy.ex_220924.JSONPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JSONPath001 {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    @Test
    public void testPost(){
        String createBookingPayload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(createBookingPayload);

        response = requestSpecification.when().post();

        System.out.println(response.asString());

        JsonPath jsonpath = new JsonPath(response.asString());
        String bookingID = jsonpath.getString("bookingid");
        System.out.println(bookingID);
        String firstname = jsonpath.getString("booking.firstname");
        System.out.println(firstname);
        String checkoutdate = jsonpath.getString("booking.bookingdates.checkout");
        System.out.println(checkoutdate);

        assertThat(bookingID).isNotNull().isNotBlank().isGreaterThan("0");
        assertThat(firstname).isNotNull().isNotBlank().isEqualTo("Jim");
        assertThat(checkoutdate).isNotNull().isNotBlank();

    }

}
