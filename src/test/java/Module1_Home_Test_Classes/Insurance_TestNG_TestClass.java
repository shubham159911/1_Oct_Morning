package Module1_Home_Test_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.BaseClass;
import Library_Files.UtilityClass;
import Module1_Home.Insurance_Broker_Insurance_Webpage;
import Module1_Home.Insurance_Login;

public class Insurance_TestNG_TestClass extends BaseClass 
{
	
	//public WebDriver driver;
	//InitializeBrowser() 
	
	Insurance_Login Login;
	Insurance_Broker_Insurance_Webpage Broker;
	
	int TestCaseID;

	@BeforeClass
	public void OpenBrowser() 
	{
		InitializeBrowser();
		
		 //Create Object Of POM-I Class
		Login=new Insurance_Login(driver);
		
		//Create object of POM-II Class
        Broker=new Insurance_Broker_Insurance_Webpage(driver);

	}
	
	
	@BeforeMethod
	public void loginToApp() throws IOException 
	{
		Login.EnterEmail(UtilityClass.getDatafromPF("Email")); //shubham@gmail.com
		
		Login.EnterPassowrd(UtilityClass.getDatafromPF("Password"));  //Shu@123
		
		Login.ClickLoginBtn();
		
	}
	
	@Test(priority=1)                                 //Test Case/method
	public void VerifyEmailAddress() throws EncryptedDocumentException, IOException 
	{
	
		TestCaseID=100;
		
		//verify Email Address
		String ActualEmail=Broker.getEmail();  

		String ExpectedEmail=UtilityClass.getdataFromExcelsheet(2, 0);  
	
		Assert.assertEquals(ActualEmail,ExpectedEmail);		
	}
	
	@Test(priority=2) 
	public void VerifyTitle() throws EncryptedDocumentException, IOException
	{    
		TestCaseID=101;
		
		String ActualTitle=driver.getTitle(); 
		
		String ExpectedTitle=UtilityClass.getdataFromExcelsheet(3, 0);  //Insurance Broker System1
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	
	@AfterMethod                          //Fail
	public void LogoutFromApp(ITestResult Result) throws IOException   //Pass Fail
	{       //Fail                   //Fail
		if(Result.getStatus()==ITestResult.FAILURE) 
		{
			UtilityClass.CaptureScreenshot(driver, TestCaseID);  //101
		}
		
		
		
		Broker.ClickLogoutBtn();
	}
	
	@AfterClass
	public void CloseBrowser() 
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
}