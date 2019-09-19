//Added Just new comments

package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_REQUEST_Authorization 
{
	@Test
	public void Authorization()
	{
		//Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Before sending the request we need to provide Authentication i.e. passing Credentials
		//Basic Authentication
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");
		
		//Provide what kind of authentication it is
		RestAssured.authentication = authScheme;
		
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object which we will get when we hit the GET request
		Response response = httpRequest.request(Method.GET, "/");
		
		//Will get response in Json object which we will have to convert into string
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is " +responseBody);
		
		//To get Status Code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
	
			
	}

}
