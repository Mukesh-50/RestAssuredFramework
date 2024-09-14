package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ReportListener implements ITestListener 
{

	ExtentReports extent=ExtentManager.getInstance();

	ExtentTest extentTest;

	@Override
	public synchronized void onFinish(ITestContext context) 
	{
		extent.flush();
		
		System.out.println("*** Generating Report ***");
	}
	
	@Override
	public synchronized void onTestStart(ITestResult result) 
	{
		System.out.println("*** Creating Test For Report ***");
		
		extentTest=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) 
	{
		extentTest.pass("Test Passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) 
	{
		extentTest.fail("Test Failed "+result.getThrowable().getMessage());
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) 
	{
		extentTest.skip("Test Skipped "+result.getThrowable().getMessage());
	}
	
}
