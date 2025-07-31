package com.datacom.qaexam.runners;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features") // run all feature files under src/test/resources/features
@ConfigurationParameter(key = "cucumber.glue", value = "com.datacom.qaexam") // search for step definitions and hooks under com.datacom.qaexam
@ConfigurationParameter(key = "cucumber.execution.parallel.enabled", value = "true") // To run cucumber scenarios in parallel via mvn clean test
public class RunCucumberTest {


}
