package com.Swagger.APITesting;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class APITest {
    private static final String BASE_URI = "https://fakerestapi.azurewebsites.net";

    @BeforeClass
    public void setUp() {
        // Any setup before tests, if needed
    }

    @Test
    public void postActivity() {
        Activity activity = new Activity(0, "string", "2024-09-10T15:10:53.471Z", true);

        Response response = given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(activity)
                .when()
                .post("/api/v1/Activities")
                .then()
                .log().all()
                .log().status()
                .extract()
                .response();

        System.out.println("POST Response Body: " + response.asString());
    }

    @Test(dependsOnMethods = "postActivity")
    public void getActivity() {
        int id = 1; // Example ID for GET request
        Response response = given()
                .baseUri(BASE_URI)
                .when()
                .get("/api/v1/Activities/" + id)
                .then()
                .log().all()
                .log().status()
                .extract()
                .response();

        System.out.println("GET Response Body: " + response.asString());
    }

    @Test(dependsOnMethods = "postActivity")
    public void putActivity() {
        int id = 1; // Example ID for PUT request
        Activity updatedActivity = new Activity(id, "updated string", "2024-10-10T15:10:53.471Z", false);

        Response response = given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(updatedActivity)
                .when()
                .put("/api/v1/Activities/" + id)
                .then()
                .log().all()
                .log().status()
                .extract()
                .response();

        System.out.println("PUT Response Body: " + response.asString());
    }

    @Test(dependsOnMethods = "postActivity")
    public void deleteActivity() {
        int id = 1; // Example ID for DELETE request
        Response response = given()
                .baseUri(BASE_URI)
                .when()
                .delete("/api/v1/Activities/" + id)
                .then()
                .log().all()
                .log().status()
                .extract()
                .response();

        System.out.println("DELETE Response Body: " + response.asString());
    }

    @Test
    public void getActivitiesWithQueryParams() {
        int idBook = 2; // Example query param
        Response response = given()
                .baseUri(BASE_URI)
                .queryParam("idBook", idBook)
                .when()
                .get("/api/v1/Activities")
                .then()
                .log().all()
                .log().status()
                .extract()
                .response();

        System.out.println("GET with Query Params Response Body: " + response.asString());
    }
}
