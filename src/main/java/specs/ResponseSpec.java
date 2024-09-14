package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec 
{
	
	// add condition for logs if true in config file generate logs else skip
	
	public static ResponseSpecification responseSpec()
	{
		
		ResponseSpecification resp=new ResponseSpecBuilder()
		.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.build();
		
		return resp;
	}
	
	public static ResponseSpecification responseSpecFor201()
	{
		
		ResponseSpecification resp=new ResponseSpecBuilder()
		.expectStatusCode(201)
		.build();
		
		return resp;
	}
	
	public static ResponseSpecification responseSpecFor404()
	{
		
		ResponseSpecification resp=new ResponseSpecBuilder()
		.expectStatusCode(404)
		.build();
		
		return resp;
	}

}
