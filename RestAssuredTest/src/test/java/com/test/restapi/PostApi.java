package com.test.restapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class PostApi {

	// @Test
	public void postApiTest() {

		RestAssured.baseURI = "http://dummy.restapiexample.com";

		String body = "{\"name\":\"Karan\",\"salary\":\"1290\",\"age\":\"21\"}";

		given().body(body).when().post("/api/v1/create").then().assertThat().statusCode(200).body("name",
				equalTo("Karan"));
	}

	@Test
	public void postAndDeleteApiTest() {

		RestAssured.baseURI = "http://dummy.restapiexample.com";

		String body = "{\"name\":\"Shivam\",\"salary\":\"1500\",\"age\":\"22\"}";
		// raw format json reponse
		Response response = given().body(body).log().all().when().post("/api/v1/create").then().assertThat().statusCode(200).and()
				.contentType("text/html").log().all().extract().response();
		// converted into string
		String responseInString = response.asString();
		System.out.println("RESPONSE :\n" + responseInString);
		// to get json property value - from string to json
		JsonPath jsonPath = new JsonPath(responseInString);
		String idFromjson = jsonPath.get("id");

		Response delResp = given().when().delete("/api/v1/delete/" + idFromjson).then().assertThat().statusCode(200)
				.extract().response();
		System.out.println("DELETE Response: \n"+ delResp.asString()); 
		// .body("name", equalTo("Arjun"))
	}

}
