package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class BookingAPIs 
{
 
	/*
	 *  baseURL
	 *  headers - Map
	 *  Body - String, file, Object
	 *  Status Codes - Optionals
	 *  Response Object
	 *  Token Management - Config file, Env Variable
	 *  Token Generation - Utility
	 *  RestClient
	 *  Specification
	 *  Listeners - report
	 *  
	 *  
	 */
	
	@Test
	public void createBooking()
	{
		baseURI="https://restful-booker.herokuapp.com/booking";
		    
		Response resp=given()
			.contentType(ContentType.JSON)
			.body("{\n"
					+ "    \"firstname\" : \"Jim\",\n"
					+ "    \"lastname\" : \"Brown\",\n"
					+ "    \"totalprice\" : 111,\n"
					+ "    \"depositpaid\" : true,\n"
					+ "    \"bookingdates\" : {\n"
					+ "        \"checkin\" : \"2018-01-01\",\n"
					+ "        \"checkout\" : \"2019-01-01\"\n"
					+ "    },\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\n"
					+ "}")
			.post()
			.then()
			.assertThat()
			.statusCode(200)
			.extract()
			.response();
		
		System.out.println(resp.asPrettyString());
	}

}
