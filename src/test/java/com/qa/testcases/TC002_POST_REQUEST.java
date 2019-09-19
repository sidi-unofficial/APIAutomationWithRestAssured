package com.qa.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_REQUEST
{
	@Test
	void RegistrationSuccessful()
	{
		
		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//This will be post request and we will be sending the data to server along with some parameters. So before creating any request we need to have body
		//Following is Request PayLoad which will be sent along with POST Request
		JSONObject requestParams = new  JSONObject();
		requestParams.put("FirstName", "Sidhesh");
		requestParams.put("LastName", "Lotlikar");
		requestParams.put("UserName", "Sidhesh.Lotlikar");
		requestParams.put("Password", "Sidhesh.Lotlikar");
		requestParams.put("Email", "sidhesh.lotlikar@abc.com");
		
		//We would also send Header with the POST request
		httpRequest.header("Content-Type", "application/json");
		
		//Now the body has to be converted to JSON while we send the POST request 
		httpRequest.body(requestParams.toJSONString());  			//Attach data to reqeust
		
		//Now we will send the POST request that will be the combination of HEADER and BODY
		//This will actually sent the request to the database.
		Response response = httpRequest.request(Method.POST, "/register");
		
		//Will get response in Json object which we will have to convert into string
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is " +responseBody);
		
		//To get Status Code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is " +statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//To get Success Code and do validation
		String successCode = response.jsonPath().get("SuccessCode"); //Since the data is available is Json format we used jsonPath
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}

}
