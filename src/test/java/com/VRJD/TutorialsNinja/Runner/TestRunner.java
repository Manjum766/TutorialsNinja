package com.VRJD.TutorialsNinja.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "Features" }, 
        glue = { "com.VRJD.TutorialsNinja.StepDefinitions", "com.VRJD.TutorialsNinja.Hooks" },
        stepNotifications = true,
        publish=true,
        plugin = { "pretty","html:test-output/HTMLReport.html", "json:test-output/JSONReport.json",
                   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", }, 
                	tags = "@Sanity", dryRun = false, monochrome = true)

public class TestRunner {

}