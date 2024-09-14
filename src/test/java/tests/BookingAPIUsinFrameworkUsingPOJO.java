package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import io.restassured.response.Response;
import model.Booking;
import model.Booking.BookingDates;
import specs.ResponseSpec;

public class BookingAPIUsinFrameworkUsingPOJO extends BaseClass
{

	@Test
	public void createBooking()
	{
		
		Booking booking=new Booking();
		booking.setFirstname("Himanshu");
		booking.setLastname("Kumar");
		booking.setTotalprice(200);
		booking.setDepositpaid(true);
		booking.setAdditionalneeds("Evening Snacks");
		booking.setBookingdates(new BookingDates("2024-10-01", "2024-10-10"));
		
		
		Response resp=sendRequest("Post", "/booking",booking);
		
		resp.then().spec(ResponseSpec.responseSpec());
		
		System.out.println(resp.asPrettyString());
	
		
	}
	
}
