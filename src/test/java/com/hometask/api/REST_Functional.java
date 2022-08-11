package com.hometask.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class REST_Functional {

	private static final String endPoint = "https://jsonplaceholder.typicode.com/";
	private static String INPUT_FILES_LOCATION = "C:\\Users\\Ashwin_Prasath\\eclipse-workspace\\Maven\\Data\\";

	@Test(priority = 1)
	public void getResources() throws IOException, JSONException {
		RequestSpecification requestSpec = given().contentType(ContentType.JSON);
		Response response = null;
		ArrayList<String> params = new ArrayList<String>();
		params.add("posts");
		params.add("comments");
		params.add("albums");
		params.add("photos");
		params.add("todos");
		params.add("users");
		for (String inputParams : params) {
			response = requestSpec.when().get(endPoint + inputParams);
			JSONArray responseObject = new JSONArray(response.getBody().asString());
			int noOfResources = responseObject.length();
			System.out.println(noOfResources);
			Assert.assertTrue(noOfResources > 1);
		}
		assertThat(HttpStatus.SC_OK, equalTo(response.statusCode()));
	}
	
	@Test(priority = 2)
	public void addPosts() throws IOException, JSONException {
		String content = new String(Files.readAllBytes(Paths.get(INPUT_FILES_LOCATION + "addPosts_InputRequest.json")));
		RequestSpecification requestSpec = given().contentType(ContentType.JSON).body(content);
		Response response = requestSpec.when().post(endPoint + "posts");
		JSONObject responseObject = new JSONObject(response.getBody().asString());
		Object title = responseObject.get("title");
		Object body = responseObject.get("body");
		Object userID = responseObject.get("userId");
		assertThat(""+title+"", equalTo("Ashwin"));
		assertThat(""+body+"", equalTo("Hi, How are you?"));
		assertThat(""+userID+"", equalTo("500"));
		assertThat(HttpStatus.SC_CREATED, equalTo(response.statusCode()));
	}

	@Test(priority = 3)
	public void modifyPosts() throws IOException, JSONException {
		String content = new String(Files.readAllBytes(Paths.get(INPUT_FILES_LOCATION + "modifyPosts_InputRequest.json")));
		RequestSpecification requestSpec = given().contentType(ContentType.JSON).body(content);
		Response response = requestSpec.when().put(endPoint + "posts/1");
		assertThat(HttpStatus.SC_OK, equalTo(response.statusCode()));
		JSONObject responseObject = new JSONObject(response.getBody().asString());
		Object title = responseObject.get("title");
		Object body = responseObject.get("body");
		Object userID = responseObject.get("userId");
		assertThat(""+title+"", equalTo("AshwinPrasath"));
		assertThat(""+body+"", equalTo("Updated the body content"));
		assertThat(""+userID+"", equalTo("500"));
	}

	@Test(priority = 4)
	public void deletePosts() throws IOException, JSONException {
		RequestSpecification requestSpec = given().contentType(ContentType.JSON);
		Response response = requestSpec.when().delete(endPoint + "posts/1");
		assertThat(HttpStatus.SC_OK, equalTo(response.statusCode()));
	}
}
