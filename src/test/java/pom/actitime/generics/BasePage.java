package pom.actitime.generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class BasePage
{
	//Select Class
	public void selectbyvisibletext(WebElement element , String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	//Actions Class
	public void movetoelement(WebDriver driver , WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	public void clickonelement(WebDriver driver , WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
	
	//Alert Interface
	public void alertaccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	//Robot Class
	public void robotenter() throws AWTException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//ChromeOptions Class
	public void headless()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
	}
	
	//JavascriptExecutor Interface
	public void javascriptclick(WebDriver driver , WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void javascriptenter(WebDriver driver , WebElement element , String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(value, element);
	}
	
	//WebDriverWait Class
	public void webdriverwaittitleis(WebDriver driver , String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public void webdriverwaittitlecontains(WebDriver driver , String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void webdriverwaitvisibilityof(WebDriver driver , WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void webdriverwaitvisibilitybylocator(WebDriver driver , By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void webdriverwaitstaleness(WebDriver driver , WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	//WebDriver Interface
	public void gettitle(WebDriver driver , String expectedTitle)
	{
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle , "title is not matching");
	}
}