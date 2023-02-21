package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class UtilityClass
{
	
	
	//Automation TE:@Shubham
	//Date:15/02/2023
	//Day:Wed
	//Title: Fetch data from property file
	
	@Test                          //EM      //PSW
	public static String getDatafromPF(String key) throws IOException 
	{
		
		//To reach upto property File
		FileInputStream file=new  FileInputStream("C:\\Users\\shubh\\eclipse-workspace\\1st_Oct_Maven\\PropFile.properties");
		
		//create object of propertites class
		Properties prop=new Properties();
		
		//To open Property File
		prop.load(file);
		
		//To fetch data from Property file
		    String Value1=prop.getProperty(key);   //Email shubham@gmail.com
		                                         // Password   //Shu@123
	       	return Value1;  //shubham@gmail.com     //Shubham@123

	}
	
	//Automation TE:@Shubham
	//Date:17/02/2023
	//Day:Friday
	//Title: Fetch data from Excelsheet
	
	@Test                                        //3           //0
	public static String getdataFromExcelsheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
	{
		//To reach upto Excelsheet
		  FileInputStream file=new  FileInputStream("C:\\Users\\shubh\\eclipse-workspace\\1st_Oct_Maven\\Testdata\\Excel Data.xlsx");  
		  
		  Sheet  Sh=WorkbookFactory.create(file).getSheet("Sheet11");
		                         //3                 //0
		String  Value2=Sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();   //Insurance Broker System
		
		return Value2; //Insurance Broker System
		
	}
	
	
	@Test                                                      
	public static void CaptureScreenshot(WebDriver driver, int TestCaseID) throws IOException 
	{
          File  Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     
	     System.out.println(Source);
	                                                            
	     File Destination=new File("C:\\Users\\shubh\\eclipse-workspace\\1st_Oct_Maven\\Screenshot\\"+TestCaseID+".jpg");
	     
	     FileHandler.copy(Source,Destination);
	}
	
	

}