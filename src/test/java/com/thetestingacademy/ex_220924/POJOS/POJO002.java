package com.thetestingacademy.ex_220924.POJOS;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class POJO002 {
    // POJO - Plain Old Java Object
    // Hashmap Payload

    RequestSpecification rS;
    ValidatableResponse vR;
    Response r;
    String token;
    String bookingId;

    @Test
    public void testPostWithHashMap() {

//        {
//            "firstname" : "Jim",
//                "lastname" : "Brown",
//                "totalprice" : 111,
//                "depositpaid" : true,
//                "bookingdates" : {
//                      "checkin" : "2018-01-01",
//                       "checkout" : "2019-01-01"
//        },
//            "additionalneeds" : "Breakfast"
//        }


        // {} corresponds to map
        // in the above payload there is one parent and one child map

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        // Linked Has Map is used to maintain the order
        jsonBodyUsingMap.put("firstname","Jim");
        jsonBodyUsingMap.put("lastname", "Brown");
        jsonBodyUsingMap.put("totalprice", 111);
        jsonBodyUsingMap.put("depositpaid", true);

        Map<String, Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");
        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);

        jsonBodyUsingMap.put("additionalneeds","Breakfast");

        System.out.println(jsonBodyUsingMap);


        rS = RestAssured.given();
        rS.baseUri("https://restful-booker.herokuapp.com/");
        rS.basePath("/booking");
        rS.contentType(ContentType.JSON);
        rS.body(jsonBodyUsingMap).log().all();

        r = rS.when().post();

        vR = r.then().log().all();
        vR.statusCode(200);

        bookingId = r.jsonPath().getString("bookingid");
        System.out.println(bookingId);

    }

}
