package pom.actitime.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	public Properties properties;
	public FileInputStream fis;
	
	@BeforeSuite
	public void executionStart()
	{
		Reporter.log("execution started"  , true);
	}
	
	@BeforeClass
	public void setup() throws IOException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		fis=new FileInputStream(properties_path);
		properties=new Properties();
		properties.load(fis);
		driver.get(properties.getProperty("url"));		
	}
	
	@AfterClass
	public void teardown()
	{
		//driver.quit();
	}
	
	@AfterSuite
	public void executionComplete()
	{
		Reporter.log("execution completed"  , true);
	}
}