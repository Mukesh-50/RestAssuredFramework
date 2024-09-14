package specs;

import config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

	public static RequestSpecification spec() 
	{

		RequestSpecBuilder req= new RequestSpecBuilder()
				.setBaseUri(ConfigManager.getPropertyFromConfig("baseURL"))
				.setContentType(ContentType.JSON);
				
		if(ConfigManager.getPropertyFromConfig("requestlogs").equalsIgnoreCase("true"))
		{
			req.log(LogDetail.ALL);
		}
		
		RequestSpecification reqspec=req.build();
		
		return reqspec;

	}

}
