package tests;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import utils.ExtentReports.ExtentTestManager;

public class Test1 extends PageFactoryInitializer
{	
//	@DataProvider(name = "role")
//	   public static Object[][] roles() {
//	       return new Object[][] {{"Developer"},{"Team Lead"},{"QA"},{"Business Analyst"},{"DevOps Eng"},{"PMO"} };
//	   }
//	
//	@BeforeMethod
//	public void BeforeMethod(Object[] testData, ITestContext ctx){
//		if (testData.length > 0) {
//		      ctx.setAttribute("description", "Lead Id-->" + testData[1]);
//		   } else
//			   ctx.setAttribute("description", "No Lead Id");
//	}
	
	@Test(priority = 0, description = "Google test description")
	public void testGoogle0() throws Exception
	{
		ExtentTestManager.startTest("Google Test", "Google test description");
		googleHomePage()
		.verifyPageTitle();
	}
}
