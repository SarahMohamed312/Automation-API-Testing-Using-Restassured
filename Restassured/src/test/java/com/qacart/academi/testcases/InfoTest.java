package com.qacart.academi.testcases;

import io.restassured.http.Header;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class InfoTest {

    @Test
    void Test()

    {
        Header h=new Header("type","WEB");

        given()
                .baseUri("https://todo.qacart.com/")
                 .header(h)
                 //.header("type","MANUAL")
         .when()
                .get("/api/v1/info/courses")
            .then()
                  .log().all()
            .assertThat().statusCode(200);

    }
}
