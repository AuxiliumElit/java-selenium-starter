package com.example.javaseleniumstarter.features;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/com/example/javaseleniumstarter/features",glue= "com/example/javaseleniumstarter/stepDefinitions",
        monochrome=true, tags = "@DemoTest", plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
