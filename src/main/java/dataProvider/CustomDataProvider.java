package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider 
{

	@DataProvider(name="bookingDetails")
	public static Object[][] getData()
	{
		System.out.println("Generating Booking Details via DataProvider");
		
		Object [][]arr=new Object[2][7];
		arr[0][0]="Mohit";
		arr[0][1]="Gupta";
		arr[0][2]=401;
		arr[0][3]=true;
		arr[0][4]="dinner";
		arr[0][5]="2024-12-01";
		arr[0][6]="2024-12-10";
		
		arr[1][0]="Lalit";
		arr[1][1]="Mali";
		arr[1][2]=410;
		arr[1][3]=false;
		arr[1][4]="lunch";
		arr[1][5]="2024-12-15";
		arr[1][6]="2024-12-25";
		
		arr[2][0]="Samir";
		arr[2][1]="Arora";
		arr[2][2]=510;
		arr[2][3]=true;
		arr[2][4]="BF";
		arr[2][5]="2024-12-30";
		arr[2][6]="2024-12-31";
		
		System.out.println("Booking Details Generated");
	
		return arr;
	}
	
	
}
