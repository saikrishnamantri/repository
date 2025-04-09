package com.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedApiTest {

	@Test
	public void testPostRequest() {
	    Response response = RestAssured.given()
	            .contentType("application/json")
	            .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
	            .post("https://jsonplaceholder.typicode.com/posts");

	    Assert.assertEquals(response.getStatusCode(), 201);
	    Assert.assertTrue(response.getBody().asString().contains("id")); // Response contains "id"
	}
	
	@Test
	public void testAllPosts() {
	    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
	    Assert.assertEquals(response.getStatusCode(), 200);
	    Assert.assertTrue(response.getBody().jsonPath().getList("$").size() > 0); // At least one post
	}


}
