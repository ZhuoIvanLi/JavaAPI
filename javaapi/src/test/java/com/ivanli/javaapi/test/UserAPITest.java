package com.ivanli.javaapi.test;

import static org.hamcrest.CoreMatchers.hasItems;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UserAPITest {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port=8080;
	}

	@Test
	public void testGetAllUsers() {
		get("/users").then().body("id", hasItems(1, 2, 3));	
	}
	
	@Test
	public void testCreateUser() {
		int code = given()
			.contentType("application/json")
			.body("{\"name\":\"ivantest\",\"email\":\"ivantest@test.com\"}")
			.when()
			.post("/users")
			.getStatusCode();
		
		assertEquals(204, code);
	}
	
	@Test
	public void testGetUserById() {
		int code = given()
				.when()
				.get("/users/{id}", 1)
				.getStatusCode();
		
		assertEquals(200, code);
		
	}
	
	@Test
	public void testUpdateUserById() {
		int code = given()
				.contentType("application/json")
				.body("{\"name\":\"ivanupdate\",\"email\":\"ivanupdate@test.com\"}")
				.when()
				.put("/users/{id}", 3)
				.getStatusCode();
		
		assertEquals(204, code);
	}
	
	@Test
	public void testDeleteUser() {
		int code = given()
			.when()
			.contentType(ContentType.JSON)
			.delete("/users/11")
			.getStatusCode();
		
		assertEquals(204, code);	
		
	}
	
	
}
