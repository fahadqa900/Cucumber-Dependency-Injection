package com.metlife.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/feature/Login.feature"}
        ,glue = {"com.metlife.steps","com.metlife.base"}
//        ,dryRun = true
        ,publish = false
        ,plugin = {"html:target/cucumber-report.html"}
        ,tags = "@valid"
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
