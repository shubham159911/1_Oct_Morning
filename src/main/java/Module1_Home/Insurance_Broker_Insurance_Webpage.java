package Module1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Broker_Insurance_Webpage 
{
	
	//POM-II
	
//1. Data members/Global Variables should be declared globally with access level private by using @findby Annotation
	
	@FindBy(xpath="//h4[text()='shubham@gmail.com']")  private  WebElement Signedinas;  //private WebElement Signedinas=driver.findElement(by.xpath("//h4[text()='saradeg41@gmail.com']"));
	                                  
	@FindBy(xpath="//input[@class='btn btn-danger']")   private  WebElement  LogoutBtn;  //private WebElement LogoutBtn=driver.findElement(by.xpath("//input[@class='btn btn-danger']"));
	

	//2. Initialize within a constructor with access level public using pagefactory
	
	public Insurance_Broker_Insurance_Webpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//3. Utilize within a method with access level public

	public String getEmail()  
	{
		String ActualEmailAddress=Signedinas.getText(); 
		
		return ActualEmailAddress; 
		
	}
	
	public void ClickLogoutBtn() 
	{
		LogoutBtn.click();
	}
	
}