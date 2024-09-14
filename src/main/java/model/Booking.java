package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking 
{
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private String additionalneeds;
	private BookingDates bookingdates;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class BookingDates
	{
		private String checkin;
		private String checkout;
	}
	
}
