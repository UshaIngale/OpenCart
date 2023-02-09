package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver = null;
	public static FileInputStream fis = null;
	public static Properties prop = null;
	public BaseTest() {
		String fileName = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("File Not Found : " + fileName);
		}

		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in loading properties file : " + fileName);
		}
	}
	
	public void init() {
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else
			throw new RuntimeException("Invalid BrowserName : " + browserName);
		driver.get(url);
		int timeOut = Integer.parseInt(prop.getProperty("timeout"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
		boolean maximize = Boolean.parseBoolean(prop.getProperty("maximize"));
		if (maximize)
			driver.manage().window().maximize();
	}

}
