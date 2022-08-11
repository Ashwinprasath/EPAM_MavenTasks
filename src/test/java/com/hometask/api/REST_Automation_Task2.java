package com.hometask.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class REST_Automation_Task2 {

	private static final String endPoint = "http://api.openweathermap.org/data/2.5/weather";

	@Test
	public void getWeatherByLocation() throws IOException, JSONException {
		RequestSpecification requestSpec = given().contentType(ContentType.JSON).queryParam("q", "hyderabad")
				.queryParam("appid", "759fd0537e94d29a4a8612fec87208d7");

		Response response = requestSpec.when().get(endPoint);
		assertThat(response.statusCode(), equalTo(HttpStatus.SC_OK));
		System.out.println(response.getBody().asString());
	}

	@Test
	public void getWeatherByCoordinates() throws IOException, JSONException {
		RequestSpecification requestSpec = given().contentType(ContentType.JSON).queryParam("lat", "17.3753")
				.queryParam("lon", "78.4744").queryParam("appid", "759fd0537e94d29a4a8612fec87208d7");
		
		// Validate City name
		Response response = requestSpec.when().get(endPoint);
		assertThat(HttpStatus.SC_OK, equalTo(response.statusCode()));
		JSONObject resBody = new JSONObject(response.getBody().asString());
		Object name = resBody.get("name");
		assertThat("" + name + "", equalTo("Hyderabad"));

		// Validate country
		JSONObject sys = resBody.getJSONObject("sys");
		String country = sys.get("country").toString();
		assertThat("" + country + "", equalTo("IN"));

		// Verify the temperature
		JSONObject main = resBody.getJSONObject("main");
		double temp_min = (double) main.get("temp_min");
		double temp = (double) main.get("temp");
		assertTrue(temp_min > 0);
		assertTrue(temp > 0);
	}
}
