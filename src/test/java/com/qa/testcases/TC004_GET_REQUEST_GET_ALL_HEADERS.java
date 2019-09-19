package com.qa.testcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_REQUEST_GET_ALL_HEADERS {
	
	@Test
	void getALlHeaders()
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
		
		//We need all headers which was part of response
		Headers allHeaders = response.getHeaders();
		
		//Since Headers contains Key and Value, We need to store them in Map i.e. HashMap
		for(Header header : allHeaders)
		{
			System.out.println(header.getName()+"->"+header.getValue());
		}
	}

}
