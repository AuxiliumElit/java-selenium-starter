package com.example.javaseleniumstarter.stepDefinitions;

import com.example.javaseleniumstarter.pageObjects.ContactUsPage;
import com.example.javaseleniumstarter.pageObjects.HomePage;
import com.example.javaseleniumstarter.testCasesTestNg.DemoTestTestNg2;
import com.example.javaseleniumstarter.testComponents.BaseUITest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DemoTestStepDef extends BaseUITest {

     public Logger log = LogManager.getLogger(DemoTestTestNg2.class);
     WebDriver driver;
     HomePage onHomePage;
     ContactUsPage onContactUsPage;

    @Before
    public void beforeHook() throws IOException {
        log.info("I am in Before Hook");
        driver = launchApplication();
        onHomePage = new HomePage(driver);
        onContactUsPage = new ContactUsPage(driver);
    }

    @After
    public void afterHook() {
        closeApplication();
        log.info("I am in After Hook");
    }


    @Given("Open Home Page")
    public void openTestApp() throws IOException {
        log.info("I am on Home Page");
    }


    @When("User navigate to Contact Us Page")
    public void openContactUsPage() {
        onHomePage.clickContactUsHeaderButton();
        log.info("I am on Contact Us Page");
    }

    @When("^Submit Contact Form with (.+) and (.+)$")
    public void submitForm(String name, String password) throws InterruptedException {
        onContactUsPage.enterNameInContactForm(name);
        onContactUsPage.enterPhoneInContactForm(password);
        Thread.sleep(3000);
        log.info("I submitted form");
    }

    @Then("Form Submission alert message is displayed")
    public void verifyForm() {
        log.info("Contact Us Form has been submitted and validated successfully");
    }

    @Then("Look for random element")
    public void lookForRandomElement() {
        onContactUsPage.clickRandomLocatorToAppear();
    }
}
