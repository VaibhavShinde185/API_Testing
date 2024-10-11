package com.thetestingacademy.ex_210924.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
 import static org.assertj.core.api.Assertions.*;


    public class Test_002 {
      // -----|| ASSERTION EXAMPLE ||-----
        //  POST - Create -> Verify the Response
        RequestSpecification requestSpecification;
        ValidatableResponse validatableResponse;
        Response response;
        String token;
        Integer bookingId;

        @Test
        public void test_post(){
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

            // Given - Request Specifications
            requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
            requestSpecification.basePath("/booking");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(payload_POST).log().all();

            // When - HTTP methods
            Response response = requestSpecification.when().post();

            // Then Validate Response
            // Get Validate response to perform validation
            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);

            //Extracting data from the JSON string by using JSON path
            bookingId = response.jsonPath().getInt("bookingid");
            System.out.println(bookingId);

            // Rest Assured Default - Hamcrest
            // import org.hamcrest.Matchers;
//        validatableResponse.body("booking.firstname",Matchers.equalTo("Pramod"));
//        validatableResponse.body("booking.lastname",Matchers.equalTo("Dutta"));
//        validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
//        validatableResponse.body("bookingid",Matchers.notNullValue());



            // TestNG Assertion
            // SoftAssert vs
            // HardAssert - This means that if any assertion fails, the remaining statements in that test method will not be executed.

            //Extracting data from the JSON string by using extract function
            bookingId = response.then().extract().path("bookingid");
            String firstname = response.then().extract().path("booking.firstname");
//
//            Assert.assertNotNull(bookingId);
//            Assert.assertEquals(firstname,"Pramod");

            // AssertJ Assertion
            assertThat(bookingId).isNotNull().isNotZero().isPositive();
            assertThat(firstname).isEqualTo("Pramod").isNotEmpty().isNotBlank();
//            String s = ""; //Empty
//            String s2 = " "; //Blank



        }



    }
