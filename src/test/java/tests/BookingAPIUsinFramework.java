package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import io.restassured.response.Response;
import specs.ResponseSpec;

public class BookingAPIUsinFramework extends BaseClass
{

	@Test
	public void createBooking()
	{
		
		String payload="{\n"
				+ "    \"firstname\" : \"Jim\",\n"
				+ "    \"lastname\" : \"Brown\",\n"
				+ "    \"totalprice\" : 111,\n"
				+ "    \"depositpaid\" : true,\n"
				+ "    \"bookingdates\" : {\n"
				+ "        \"checkin\" : \"2018-01-01\",\n"
				+ "        \"checkout\" : \"2019-01-01\"\n"
				+ "    },\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\n"
				+ "}";
		
		Response resp=sendRequest("Post", "/booking", payload);
		
		resp.then().spec(ResponseSpec.responseSpec());
	
		System.out.println(resp.asPrettyString());
		
	}
	
}
