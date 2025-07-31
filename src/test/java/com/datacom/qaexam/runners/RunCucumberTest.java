package com.datacom.qaexam.runners;
import org.junit.platform.suite.api.*;

/**
 * This is the main test runner class to run all Cucumber feature files via "mvn clean test" that can be used in CICD pipeline.
 * Note it executes all scenarios in parallel by default.
 */
@Suite
@IncludeEngines("cucumber")
@SelectPackages("features") // run all feature files under src/test/resources/features
@ConfigurationParameter(key = "cucumber.glue", value = "com.datacom.qaexam") // search for step definitions and hooks under com.datacom.qaexam
@ConfigurationParameter(key = "cucumber.execution.parallel.enabled", value = "true") // To run cucumber scenarios in parallel via mvn clean test
public class RunCucumberTest {
}
