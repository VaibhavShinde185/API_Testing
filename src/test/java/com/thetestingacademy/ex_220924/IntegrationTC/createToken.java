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

public class createToken {
    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vR;

    @Description("Create a token")
    @Test
    public void generateToken(){
        Token token = new Token();
        token.setUsername("admin");
        token.setPassword("password123");

        String baseURL = "https://restful-booker.herokuapp.com";
        String basePath = "/auth";

        Gson gson = new Gson();
        String payloadCreateToken = gson.toJson(token);
        System.out.println(payloadCreateToken);

        rs.baseUri(baseURL);
        rs.basePath(basePath);
        rs.contentType(ContentType.JSON).log().all();
        rs.body(payloadCreateToken);

        r = rs.when().post();
        System.out.println(r.asString());

        vR = r.then().statusCode(200).log().all();

        TokenResponse tokenresponse = gson.fromJson(r.asString(), TokenResponse.class);
        System.out.println(tokenresponse.getToken());

        assertThat(tokenresponse.getToken()).isNotNull();

    }

}
