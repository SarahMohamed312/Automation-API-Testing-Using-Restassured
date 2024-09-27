package com.qacart.academi.testcases;

import io.restassured.http.Header;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StudentsTest {
   @Test
    public void shouldBeAbleToLogintoApplication(){

       String b="{\n" +
               "    \"email\":\"sarahabdelnaby2014@gmail.com\",\n" +
               "    \"password\":\"1234\"\n" +
               "}";

              given()
                      .baseUri("https://todo.qacart.com")
                      .header("Content-Type","application/json")
                      .body(b)
                      .log().all()
               .when()
               .post("/api/v1/students/login")
               .then()
               .log().all()
               .assertThat();
               //.statusCode(200);
   }
}
