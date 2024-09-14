package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import config.ConfigManager;
import io.restassured.response.Response;
import model.Booking;
import model.Booking.BookingDates;
import model.BookingWrapper;
import specs.ResponseSpec;
import utils.JSONUtils;

public class E2ETestForBooking extends BaseClass
{

	int bookingid;
	
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
		
		BookingWrapper bookingresponse=JSONUtils.deserialize(resp, BookingWrapper.class);
	
		bookingid=bookingresponse.getBookingid();
		
		String firstname=bookingresponse.getBooking().getFirstname();
		
		String lastname=bookingresponse.getBooking().getLastname();
		
		System.out.println(firstname);
		System.out.println(lastname);
		
		Assert.assertNotNull(firstname);
		
		Assert.assertNotNull(lastname);
	}
	
	
	@Test(priority = 1,dependsOnMethods = "createBooking")
	public void updateBooking()
	{
		Booking booking=Booking.builder()
				.firstname("Mukesh")
				.lastname("Otwani")
				.totalprice(301)
				.depositpaid(true)
				.additionalneeds("lunch")
				.bookingdates(BookingDates.builder().checkin("2024-12-01").checkout("2024-12-15").build())
				.build();
		
		Map<String, Object> headers=new HashMap<String, Object>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put("Cookie", "token="+ConfigManager.getPropertyFromConfig("token"));
		
		Response resp=sendRequest("PUT", "/booking/"+bookingid, booking, headers);
		
		System.out.println(resp.asPrettyString());
		
		Booking bookingresponse=JSONUtils.deserialize(resp, Booking.class);
		
		Assert.assertEquals(bookingresponse.getFirstname(), "Mukesh");
		Assert.assertEquals(bookingresponse.getLastname(), "Otwani");
		
	}
	
	
	@Test(priority = 2,dependsOnMethods = "createBooking")
	public void deleteBooking()
	{
		/*
		 *  curl -X DELETE \
			  https://restful-booker.herokuapp.com/booking/1 \
			  -H 'Content-Type: application/json' \
			  -H 'Cookie: token=abc123'
		 * 
		 */
		
		Map<String, Object> headers=new HashMap<String, Object>();
		
		headers.put("Content-Type", "application/json");
		
		headers.put("Cookie", "token="+ConfigManager.getPropertyFromConfig("token"));
		
		Response resp=sendRequest("DELETE", "/booking/"+bookingid,null,headers);
		
		resp.then().spec(ResponseSpec.responseSpecFor201());
		
		/*
		 *  make get call to same booking id and verify it returns 404 for delete booking
		 * 
		 */
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
