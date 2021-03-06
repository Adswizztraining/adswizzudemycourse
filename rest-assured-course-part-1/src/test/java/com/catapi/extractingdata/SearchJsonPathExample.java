package com.catapi.extractingdata;

import com.catapi.init.CatInit;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class SearchJsonPathExample extends CatInit {

    //extract id

    @Test
    public void test001() {

        Response request =
                given()
                        .headers("x-api-key", APIKEY)
                        .when()
                        .get("/votes");

        //GET Request
//        log.info(request.prettyPrint());


        ArrayList<Integer> ids = given()
                .headers("x-api-key", APIKEY)
                .when()
                .get("/votes")
                .then()
                .extract()
                .path("id");

        for (int id : ids
        ) {
            String idField = Integer.toString(id);
            //log doesn't print the value.
            System.out.println(idField);
        }

        ArrayList<Integer> expectedId = new ArrayList<>();
        expectedId.add(124474);
        Assert.assertEquals("Integer is equal to ", ids, expectedId);

    }

    @Test
    public void test002() {

        RequestSpecification httpRequest = RestAssured
                .given()
                .headers("x-api-key", APIKEY);

        Response response = httpRequest.get("/vote;s");
        JsonPath jsonPathEvaluator = response.jsonPath();
        String value = jsonPathEvaluator.getString("id");

        System.out.println(value);

    }


    @Test
    public void test003() {


        String xml = given()
                .headers("x-api-key", APIKEY)
                .when()
                .get("/votes")
                .asString();


        RequestSpecification httpRequest = RestAssured
                .given()
                .headers("x-api-key", APIKEY);

        Response response = httpRequest.get("/votes");
        JsonPath jsonPathEvaluator = response.jsonPath();
        String value = jsonPathEvaluator.getString("id");

        System.out.println(value);

    }


}
