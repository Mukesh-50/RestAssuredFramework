package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import io.restassured.response.Response;
import model.Booking;
import model.Booking.BookingDates;
import model.BookingWrapper;
import utils.JSONUtils;

public class E2ETestForBookingDDT extends BaseClass
{

	int bookingid;
	
	@Test(dataProvider = "bookingDetails",dataProviderClass = CustomDataProvider.class)
	public void createBooking(String fname,String lastName,int price,boolean status,String type,String checkin,String checkout)
	{
		Booking booking=Booking.builder()
		.firstname(fname)
		.lastname(lastName)
		.totalprice(price)
		.depositpaid(status)
		.additionalneeds(type)
		.bookingdates(BookingDates.builder().checkin(checkin).checkout(checkout).build())
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
	
	
}
