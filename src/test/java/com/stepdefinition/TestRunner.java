package com.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
                   glue   = "com.stepdefinition",
                   plugin = {"html:target","json:target/reports.json"},
                   dryRun = false,
               monochrome = true,
                     tags = {"@smoke1,@sanity1"})

public class TestRunner {
	


}
