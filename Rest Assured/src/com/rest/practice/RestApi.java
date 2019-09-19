package com.rest.practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import org.testng.annotations.*;
import static org.hamcrest.Matchers.equalTo;

public class RestApi {

	@Test
	public void getTest() {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://samples.openweathermap.org";

		Response res = given().param("q", "London,uk").param("appid", "b6907d289e10d714a6e88b30761fae22").when()
				.get("/data/2.5/weather").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("weather[0].description", equalTo("light intensity drizzle")).extract().response();
		
		String response = res.asString();
		System.out.println(response);
	}

}
