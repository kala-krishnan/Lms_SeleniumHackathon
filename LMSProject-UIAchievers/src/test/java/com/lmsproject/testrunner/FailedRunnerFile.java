package com.lmsproject.testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		plugin = {"pretty","html:target/cucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
		monochrome=false,  //console output color
		features = "@target/failed_scenarios.txt", //location of feature files
		glue= {"com.lmsproject.apphooks","com.lmsproject.stepdefinitions"} )


public class FailedRunnerFile extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }

}


  