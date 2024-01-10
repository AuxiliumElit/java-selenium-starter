package com.example.javaseleniumstarter.testCasesTestNg;

import com.example.javaseleniumstarter.pageObjects.ContactUsPage;
import com.example.javaseleniumstarter.pageObjects.HomePage;
import com.example.javaseleniumstarter.testComponents.BaseUITest;
import com.example.javaseleniumstarter.testComponents.Retry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DemoTestTestNg2 extends BaseUITest {

    public Logger log = LogManager.getLogger(DemoTestTestNg2.class);
    WebDriver driver;
    HomePage onHomePage;
    ContactUsPage onContactUsPage;

    @BeforeMethod(alwaysRun = true)
    public void startTest() throws IOException {
        driver = launchApplication();
        onHomePage = new HomePage(driver);
        onContactUsPage = new ContactUsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeTest() {
        closeApplication();
    }

    //Test depends on other test. Example
    //@Test(dependsOnMethods = {"runDemoTestWithTestNg5"})
    @Test
    public void runDemoTestWithTestNg4() throws InterruptedException, IOException {
        log.info("Demo test has been started");
        onHomePage.clickContactUsHeaderButton();
        onContactUsPage.enterNameInContactForm("Super Test 1");
        onContactUsPage.enterPhoneInContactForm("2671233444");
        log.info("Demo test has been completed");
    }

    @Test(groups = {"ContactUsPageSmokeTest"})
    public void runDemoTestWithTestNg5() throws InterruptedException, IOException {
        log.info("Demo test has been started");
        onHomePage.clickContactUsHeaderButton();
        onContactUsPage.enterNameInContactForm("Super Test 2");
        onContactUsPage.enterPhoneInContactForm("2671233555");
        log.info("Demo test has been completed");
    }

    @Test(retryAnalyzer = Retry.class)
    public void runDemoTestWithTestNg6() throws InterruptedException, IOException {
        log.info("Demo test has been started");
        onHomePage.clickContactUsHeaderButton();
        onContactUsPage.enterNameInContactForm("Super Test 3");
        onContactUsPage.enterPhoneInContactForm("2671233666");
        onContactUsPage.clickRandomLocatorToAppear();
        log.info("Demo test has been completed");
    }
}
