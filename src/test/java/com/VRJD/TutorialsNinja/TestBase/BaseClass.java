package com.VRJD.TutorialsNinja.TestBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.VRJD.TutorialsNinja.Utilities.CommonUtils;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	public ResourceBundle resourceBundle;
	public String browser;
	public String url;

	public void setUp() {

		logger = LogManager.getLogger(this.getClass());
		resourceBundle = ResourceBundle.getBundle("config");
		browser = resourceBundle.getString("browser");
		url = resourceBundle.getString("url");

		if (browser.equals("Chrome")) {
//			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver();
			logger.info("Browser launched successfully: " + browser);
		} else if (browser.equals("irefox")) {
			driver = new FirefoxDriver();
			logger.info("Browser launched successfully: " + browser);
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
			logger.info("Browser launched successfully: " + browser);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		driver.get(url);
		logger.info("URL Opened: " + url);
	}

}
