package com.Swagger.APITesting;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ActivityPage {
    private static final String BASE_URI = "https://fakerestapi.azurewebsites.net";

    public Response postActivity(Activity activity) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(activity)
                .when()
                .post("/api/v1/Activities")
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getActivity(int id) {
        return given()
                .baseUri(BASE_URI)
                .contentType("application/json")
                .when()
                .get("/api/v1/Activities/" + id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response putActivity(int id, Activity updatedActivity) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(updatedActivity)
                .when()
                .put("/api/v1/Activities/" + id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response deleteActivity(int id) {
        return given()
                .baseUri(BASE_URI)
                .when()
                .delete("/api/v1/Activities/" + id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response getActivitiesWithQueryParams(int idBook) {
        return given()
                .baseUri(BASE_URI)
                .queryParam("idBook", idBook)
                .when()
                .get("/api/v1/Activities")
                .then()
                .log().all()
                .extract()
                .response();
    }
}
