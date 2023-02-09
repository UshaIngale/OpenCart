package pages;

import org.openqa.selenium.By;

public class RegisterPage {
	By labelRegisterAccount=By.xpath("//h1");
	By myAccount=By.xpath("(//div[@class='nav float-end']//a)[2]");
	By register=By.xpath("(//a[contains(text(),'Register')])[1]");
	By firstName=By.id("input-firstname");
	By lastName=By.id("input-lastname");
	By emailId=By.id("input-email");
	By password=By.id("input-password");
	By newsLetterSubscribeYes=By.id("input-newsletter-yes");
	By newsLetterSubscribeNo=By.id("input-newsletter-no");
	By agreePrivacyPolicy=By.name("agree");
	By btnContinue=By.xpath("//button[@type='submit']");
}
