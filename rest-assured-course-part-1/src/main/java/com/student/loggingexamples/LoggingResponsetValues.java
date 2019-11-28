package com.student.loggingexamples;

import com.student.base.TestBase;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class LoggingResponsetValues extends TestBase {

    @Test
    public void test002() {
        System.out.println("-------------------Printing response headers------------------");
        given()
                .param("programme", "Financial Analysis")
                .param("limit", -1)
                .log().parameters()
                .when()
                .get("/list/")
                .then()
                .log()
                .ifError();
//                .body()
//                .status()
//                .headers()
//                .statusCode(200);
    }

}