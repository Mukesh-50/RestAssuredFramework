package listeners;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.GenericUtils;

public class ExtentManager 
{

	static ExtentReports extent;
	
	
	
	public static ExtentReports getInstance()
	{
		System.out.println("*** Generating Report Instance ***");
		if(extent==null)
		{
			extent=createInstance();
			
			return extent;
		}
		else
		{
			return extent;
		}
		
	}
	
	public static ExtentReports createInstance()
	{
		String path=System.getProperty("user.dir")+"/Reports/APIAutomation_"+GenericUtils.getDateAndTime()+".html";
		
		System.out.println("*** Reports can be found at "+path+" ***");
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		//reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("API Automation Test Results");
		reporter.config().setDocumentTitle("Automation Report");
		
		ExtentReports extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		return extent;
	}
	
	
	
}
