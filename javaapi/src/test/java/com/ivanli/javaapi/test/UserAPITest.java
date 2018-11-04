package com.ivanli.javaapi.test;

import static org.hamcrest.CoreMatchers.hasItems;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UserAPITest {

	/*@BeforeClass
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
			.body("{\"name\":\"ivantest\",\"email\":\"ivantest@gmail.com\"}")
			.when()
			.post("/users")
			.getStatusCode();
		
		
		if(code==204){
			System.out.println("User Created Successfully");
		}else {
			System.out.println("Unexpected Error");
		}
	}
	
	@Test
	public void testGetUserById() {
		int code = given()
				.when()
				.get("/users/{id}", 1)
				.getStatusCode();
		
		if(code==200){
			System.out.println("Requested User's details");
		}else {
			System.out.println("Unexpected Error");
		}
		
	}
	
	@Test
	public void testUpdateUserById() {
		int code = given()
				.contentType("application/json")
				.body("{\"name\":\"ivanupdate\",\"email\":\"ivanupdate@test.com\"}")
				.when()
				.put("/users/{id}", 3)
				.getStatusCode();
		
		if(code==204){
			System.out.println("User modified Successfully");
		}else {
			System.out.println("Unexpected Error");
		}
		
	}
	
	@Test
	public void testDeleteUser() {
		int code = given()
			.when()
			.contentType(ContentType.JSON)
			.delete("/users/10")
			.getStatusCode();
		
		if(code==204){
			System.out.println("User deleted Successfully");
		}else {
			System.out.println("Unexpected Error");
		}
		
		
	}*/
	
	
}
