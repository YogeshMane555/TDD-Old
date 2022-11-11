import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestData {

	
	public static void main(String args[]) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		WebDriver rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.get("https://itera-qa.azurewebsites.net/UserRegister/NewUser");		
	
		File file = new File("TDD/TestData/TestData.xls");
		
		FileInputStream is= new FileInputStream(file);
		
		HSSFWorkbook wb=new HSSFWorkbook(is);
		
		HSSFSheet hs=wb.getSheet("SignUP");
		
		HSSFRow row=hs.getRow(0);

		
	}
	
	
}
