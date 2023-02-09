package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.Utility;

public class LoginTest extends BaseTest {
	LoginPage loginPage;
	Utility utility;
	public WebDriver driver;

	@BeforeClass
	public void setup() {
		init(); // launching the browser
		driver = super.driver;
		loginPage = new LoginPage(driver);
		utility=new Utility();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "loginData")
	public void verifyLogin(String username, String password) {
	
		loginPage.loginToApplication(username, password);
		Assert.assertEquals(driver.getTitle() , "OpenCart - Your Account");
 
	}

	@DataProvider
	public Object[][] loginData() {
		return new Object[][] { { prop.getProperty("email"), prop.getProperty("password") } };

	}

}
