package utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	public WebDriver driver;

	public void clickOnWebElement(WebDriver driver, By element, String message) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(element));// wait until element is
																								// available for click
			ele.click(); // perform click operation on element
			System.out.println(message); // print the message in console
		} catch (Exception e) {
			e.printStackTrace(); // catch exception if any and print error iin console
		}
	}

	public void enterText(WebDriver driver, By locator, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));// wait until element is available for
																				// click
			WebElement element = driver.findElement(locator);
			element.sendKeys(text);
			System.out.println("Entered Text : " + text);
//			element.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			JavascriptExecutor jse = ((JavascriptExecutor) driver);
			WebElement element = driver.findElement(locator);
			jse.executeScript("arguments[0].value='text';", element);
			//e.printStackTrace(); // catch exception if any and print error iin console
		}

	}

	public void selectOptionFromList(WebDriver driver, String with, By locator) {
//	        List<WebElement> element= driver.findElements(isOrIsntList);
		// webElementClick(driver,driver.findElement(nameFilterWith),"Click on name
		// filter with option list 'is' or 'isn't'");
		List<WebElement> element = driver.findElements(locator);
		for (WebElement we : element) {
//	            String nm=we.getText();
			if (we.getText().equals(with)) {
				System.out.println(we.getText() + " : " + with);
				we.click();
			}
		}
	}

	public String getTextFromElement(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		return wait.until(ExpectedConditions.presenceOfElementLocated(element)).getText();

	}

	public WebElement getWebElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));// wait until element is available for click
		return driver.findElement(locator);
	}
}
