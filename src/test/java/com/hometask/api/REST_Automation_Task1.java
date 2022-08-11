package com.hometask.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class REST_Automation_Task1 {

	private static final String postUrl = "https://petstore.swagger.io/v2/pet";
	private static final String getPet = "https://petstore.swagger.io/v2/pet/12345";
	private static final String getUser = "https://jsonplaceholder.typicode.com/users";
	private static String INPUT_FILES_LOC = "C:\\Users\\Ashwin_Prasath\\eclipse-workspace\\Maven\\Data\\";

	@Test(priority = 1)
	public void createPet() throws IOException {

		String content = new String(Files.readAllBytes(Paths.get(INPUT_FILES_LOC + "inputRequest.json")));
		RequestSpecification requestSpec = given().contentType(ContentType.JSON).body(content);

		Response response = requestSpec.when().post(postUrl);
		assertThat(HttpStatus.SC_OK, equalTo(response.statusCode()));
	}

	@Test(priority = 2)
	public void getPet() throws IOException, JSONException {

		RequestSpecification requestSpec = given().contentType("application/json");
		Response response = requestSpec.when().get(getPet);
		assertThat(HttpStatus.SC_OK, equalTo(response.statusCode()));
		assertThat(response.getContentType(), equalTo("application/json"));
		
		JSONObject responseObject = new JSONObject(response.getBody().asString());
		Object aStatus = responseObject.get("status");
		Object aName = responseObject.get("name");
		assertEquals(aStatus, "pending");
		assertEquals(aName, "snoopie");
		
		JSONObject categoryObject = responseObject.getJSONObject("category");
		Object petName = categoryObject.get("name");
		assertEquals(petName, "dog");
	}

	@Test(priority = 3)
	public void getUser() throws IOException, JSONException {

		RequestSpecification requestSpec = given().contentType(ContentType.JSON);

		Response response = requestSpec.when().get(getUser);
		assertThat(HttpStatus.SC_OK, equalTo(response.statusCode()));

		JSONArray responseObject = new JSONArray(response.getBody().asString());
		System.out.println(responseObject);

		int usersCount = responseObject.length();
		assertTrue(usersCount > 3);

		int count = 0;
		for (int i = 0; i < usersCount; i++) {

			Object userName = responseObject.getJSONObject(i).get("name");
			if (userName.equals("Ervin Howell")) {
				count++;
				break;
			}
		}
		assertTrue(count == 1);
	}
}
