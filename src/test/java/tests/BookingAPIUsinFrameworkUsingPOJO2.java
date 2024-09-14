package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import io.restassured.response.Response;
import model.Booking;
import model.Booking.BookingDates;
import specs.ResponseSpec;

public class BookingAPIUsinFrameworkUsingPOJO2 extends BaseClass
{

	@Test
	public void createBooking()
	{
		
		Booking booking=new Booking("Jayanta", "Mandal", 200, false, "Breakout", new BookingDates("2024-10-01", "2024-10-10"));
	
		Response resp=sendRequest("Post", "/booking",booking);
		
		resp.then().spec(ResponseSpec.responseSpec());
		
		System.out.println(resp.asPrettyString());
	
		
	}
	
}
