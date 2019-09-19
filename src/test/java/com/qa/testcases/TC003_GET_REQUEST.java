package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_REQUEST {
	
	@Test
	void googleMapTest()
	{
		
		//Specify Base URI
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object which we will get when we hit the GET request
		Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Will get response in Json object which we will have to convert into string
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is " +responseBody);
		
		//Capture details of headers from response
		String contentType = response.header("Content-Type");
		System.out.println("Content Type from header is " +contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		String contentEncoding = response.header("Content-Encoding");
		System.out.println("Content Encoding from header is " +contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
	}


}
