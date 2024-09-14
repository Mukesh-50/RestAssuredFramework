package utils;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class JSONUtils 
{
	/*
	 *  String
	 *  int
	 *  boolean
	 *  Map<String,String>, Map<String,Object>, Map<String,Integer>
	 *  List,  List<String> , List<Map> 
	 *  Object
	*/
	
	private static ObjectMapper objectMapper=new ObjectMapper();
	
	
	public static <T> T deserialize(Response res,Class<T> cls)
	{
		
			try 
			{
				return objectMapper.readValue(res.asString(), cls);
				
			} catch (Exception e) 
			{
				System.out.println("Exception while parsing or mapping "+e.getMessage());
				
				return null;
			} 
		
	}
	
	
	public static <K,V> Map<K, V> getMap(Response resp,String jsonPath)
	{
		return resp.jsonPath().getMap(jsonPath);
	}
	
	public static <T> List<T> getList(Response resp,String jsonPath)
	{
		return resp.jsonPath().getList(jsonPath);
		
	}
	
	public static String getString(Response resp,String jsonPath)
	{
		String value=resp.jsonPath().getString(jsonPath);
		
		return value;
	}
	
	public static int getInt(Response resp,String jsonPath)
	{
		int value=resp.jsonPath().getInt(jsonPath);
		
		return value;
	}
	
	public static boolean getBoolean(Response resp,String jsonPath)
	{
		boolean value=resp.jsonPath().getBoolean(jsonPath);
		
		return value;
	}

}
