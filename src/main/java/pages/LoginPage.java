package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Utility;
public class LoginPage {
	Utility utility;
	public WebDriver driver;
	 By linkLogin=By.xpath("(//a[@href='https://www.opencart.com/index.php?route=account/login'])[2]");
	 By txtEmail=By.id("input-email");
	 By txtPassword=By.id("input-password");
	 By btnLogin=By.xpath("(//button[@type='submit'])[1]");
	 By linkForgotPassword=By.linkText("https://www.opencart.com/index.php?route=account/forgotten");
	 By txtEmailForForgotPassword=By.id("input-email");
	 By btnSubmitForForgotPassword=By.xpath("//button[@type='submit']");
	 By labelAccount=By.xpath("h1");
	 By pin=By.id("input-pin");
	 By btnContinue=By.xpath("//*[@id='account-security']//div[2]/button");
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void loginToApplication(String username, String password) {
		utility=new Utility();
		utility.clickOnWebElement(driver, linkLogin, "Clicked on Login Link");
		utility.enterText(driver, txtEmail, username);
		utility.enterText(driver, txtPassword, password);
		utility.clickOnWebElement(driver, btnLogin , "Clicked on Login Button");
		utility.enterText(driver,pin, "2310");
		utility.clickOnWebElement(driver, btnContinue, "Clicked on Continue button");
	}

}
