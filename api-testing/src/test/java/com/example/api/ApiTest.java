package com.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This test is a temporary solution to verify the status code of a GET request.
 * In the future, we can enhance this test to validate the response body and other aspects.
 */
public class ApiTest {

@Test
public void testGetRequest() {
    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertNotNull(response.getBody());
    Assert.assertTrue(response.getBody().asString().contains("userId"));
}

@Test
public void testAllPosts() {
    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertTrue(response.getBody().jsonPath().getList("$").size() > 0);
}


}

