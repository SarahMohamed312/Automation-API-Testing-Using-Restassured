package com.Swagger.APITesting;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class BooksPage {


        private static final String BASE_URI = "https://fakerestapi.azurewebsites.net";
        private static final String end_point="/api/v1/Books/";
        public  Response postBook(Books books) {
            return given()
                    .baseUri(BASE_URI)
                    .header("Content-Type", "application/json")
                    .body(books)
                    .when()
                    .post(end_point)
                    .then()
                    .log().all()
                    .extract()
                    .response();
        }

        public Response getBook(int id) {
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

        public Response putBook(int id, Books updatedBooks) {
            return given()
                    .baseUri(BASE_URI)
                    .header("Content-Type", "application/json")
                    .body(updatedBooks)
                    .when()
                    .put(end_point + id)
                    .then()
                    .log().all()
                    .extract()
                    .response();
        }

        public Response deleteBook(int id) {
            return given()
                    .baseUri(BASE_URI)
                    .when()
                    .delete(end_point + id)
                    .then()
                    .log().all()
                    .extract()
                    .response();
        }

        public Response getBookWithQueryParams(int idBook) {
            return given()
                    .baseUri(BASE_URI)
                    .queryParam("idBook", idBook)
                    .when()
                    .get(end_point)
                    .then()
                    .log().all()
                    .extract()
                    .response();
        }
    }