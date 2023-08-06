package pom.actitime.testcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pom.actitime.generics.BaseTest;
import pom.actitime.pages.ActitimeLoginPage;


@Listeners(pom.actitime.generics.Screenshot.class)
public class TC_01_ActitimeLoginLogout extends BaseTest
{
	@Test
	public void loginlogout() throws IOException, InterruptedException
	{
		ActitimeLoginPage loginPage=new ActitimeLoginPage(driver);
		loginPage.loginMethod();
	}
	
	@Test(dependsOnMethods = "loginlogout")
	public void titlevalidation()
	{
		ActitimeLoginPage loginPage=new ActitimeLoginPage(driver);
		loginPage.validateTitle();
	}
}