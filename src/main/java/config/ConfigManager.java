package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager 
{
	
	
	
	public static void updatePropertyfile(String key,String name)
	{
		
		Properties pro=new Properties();
		
		try 
		{
			
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/config.properties")));
			
			pro.setProperty(key, name);
			
			FileOutputStream fileoutput=new FileOutputStream(new File(System.getProperty("user.dir")+"/Config/config.properties"));
			
			pro.store(fileoutput, null);
			
			System.out.println("Config file updated");
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Could not find the file "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not load/operate this file "+e.getMessage());
		}
		
	}
	

	public static String getPropertyFromConfig(String keyName)
	{
		
		System.out.println("**** Loading Config File *******");
		
		String value=null;
		
		Properties pro=new Properties();
		
		//File src=new File(System.getProperty("user.dir")+"/Config/config.properties");
		
		try 
		{
			//FileInputStream fileInput=new FileInputStream(src);
			
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/config.properties")));
			
			value=pro.getProperty(keyName);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Could not find the file "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not load/operate this file "+e.getMessage());
		}
		
		
		return value;
	}

}
