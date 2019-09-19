package com.qa.testcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_REQUEST_ExtractEachValueFromJSONResponse 
{
	@Test
	void ExtractEachValueFromJSonResponse()
	{
		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
				
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
				
		//Response Object which we will get when we hit the GET request
		Response response = httpRequest.request(Method.GET, "/Mumbai");
				
		//To access each and every node from JSON response we use JSONPath Class
		JsonPath jsonPath = response.jsonPath();
		
		System.out.println(jsonPath.get("City"));
		System.out.println(jsonPath.get("Temperature"));
		System.out.println(jsonPath.get("Humidity"));
		System.out.println(jsonPath.get("WeatherDescription"));
		System.out.println(jsonPath.get("WindSpeed"));
		System.out.println(jsonPath.get("WindDirectionDegree"));
		
	}
}
