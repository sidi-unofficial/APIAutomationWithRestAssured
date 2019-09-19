package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_REQUEST_VALIDATE_SingleJSONResponse 
{
	@Test
	void validateSingleJSonResponse()
	{
		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
				
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
				
		//Response Object which we will get when we hit the GET request
		Response response = httpRequest.request(Method.GET, "/Mumbai");
				
		//Will get response in Json object which we will have to convert into string
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is " +responseBody);
		
		Assert.assertEquals(responseBody.contains("Mumbai"), true);
		
		
	}

}
