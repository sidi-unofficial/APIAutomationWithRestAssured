package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_REQUEST
{
	@Test
	void getWeatherDetails()
	{
		
		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object which we will get when we hit the GET request
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
		//Will get response in Json object which we will have to convert into string
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is " +responseBody);
		
		//To get Status Code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is " +statusCode);
		Assert.assertEquals(statusCode, 200);
		//To get Status Line
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is " +statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}
