package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import io.restassured.response.Response;
import model.Booking;
import model.Booking.BookingDates;
import specs.ResponseSpec;
import utils.JSONUtils;

public class BookingAPIUsinFrameworkUsingPOJOBuilder extends BaseClass
{

	@Test
	public void createBooking()
	{
		Booking booking=Booking.builder()
		.firstname("Bhagyashree")
		.lastname("API")
		.totalprice(201)
		.depositpaid(true)
		.additionalneeds("lunch")
		.bookingdates(BookingDates.builder().checkin("2024-12-01").checkout("2024-12-15").build())
		.build();
	
		Response resp=sendRequest("Post", "/booking",booking);
		
		resp.then().spec(ResponseSpec.responseSpec());
		
		System.out.println(resp.asPrettyString());
		
		String name=JSONUtils.getString(resp, "booking.firstname");
		
		Assert.assertTrue(name.contains("Bhagyashree"),"Name does not match");
		
		int price=JSONUtils.getInt(resp, "booking.totalprice");
		
		Assert.assertEquals(price, 201,"Price does not match");
		
	}
	
}
