package com.VRJD.TutorialsNinja.Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.VRJD.TutorialsNinja.TestBase.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@AfterStep
	public void as(Scenario scenario) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.toString());
	}

	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		if ((scenario.isFailed())) {
			byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", scenarioName);
		}
		driver.quit();
	}

}
