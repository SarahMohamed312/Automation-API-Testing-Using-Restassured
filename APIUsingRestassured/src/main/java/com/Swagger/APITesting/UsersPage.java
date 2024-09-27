package com.Swagger.APITesting;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersPage {
    private static final String BASE_URI = "https://fakerestapi.azurewebsites.net";
    private static final String end_point="/api/v1/Users/";

    public Response postUser(Users userInfo)
    {
        return given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(userInfo)
                .when()
                .post(end_point)
                .then()
                .log().all()
                .extract()
                .response();
    }
    public Response getUserWithQueryParam(int id) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .when()
                .get(end_point + id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response putUser(int id, Users updateUsersInfo) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(updateUsersInfo)
                .when()
                .put(end_point + id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response deleteUser(int id) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .when()
                .delete(end_point + id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response TestgetUser() {
        return given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .when()
                .get(end_point)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
