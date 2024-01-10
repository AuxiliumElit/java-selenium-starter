package com.example.javaseleniumstarter.testCasesJUnit;

import com.example.javaseleniumstarter.pageObjects.ContactUsPage;
import com.example.javaseleniumstarter.pageObjects.HomePage;
import com.example.javaseleniumstarter.testComponents.BaseUITest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import net.minidev.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;

import static io.restassured.RestAssured.given;

@SpringBootTest
class DemoJUnitTests extends BaseUITest {

    public Logger log = LogManager.getLogger(DemoJUnitTests.class);
    RequestSpecification httpRequest;
    ResponseBody body;
    int statusCode;
    String responseBody;
    JsonPath jsonPath;
    Response response;

    @Tag("Smoke")
    @Tag("Regression")
    @Tag("API")
    @DisplayName("API Demo Test for GET request")
    @Test
    @Order(2)
    void demoAPITestForGetRequest() {
        log.info("Start API Demo Test to GET request");
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = given();

        response = httpRequest.get("products");

        statusCode = response.getStatusCode();
        log.info(statusCode);
        Assertions.assertEquals(statusCode, 200);
        body = response.getBody();
        responseBody = body.asString();
        log.info(responseBody);
        jsonPath = response.jsonPath();
        log.info(jsonPath.getJsonObject("rating[0].rate").toString());
        log.info("Completed API Demo Test to GET request");
        log.trace("Trace Message!");
        log.debug("Debug Message!");
        log.info("Info Message!");
        log.warn("Warn Message!");
        log.error("Error Message!");
        log.fatal("Fatal Message!");
    }

    @Tag("Regression")
    @Tag("API")
    @DisplayName("API Demo Test Version 2 for GET Request")
    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void demoAPITestForGetRequest2() {
        log.info("Start API Demo Test 2 to GET request");
        RestAssured.baseURI = "https://fakestoreapi.com/";

        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("products")
                .then()
                .extract()
                .response();

        statusCode = response.getStatusCode();
        log.info(statusCode);
        Assertions.assertEquals(statusCode, 200);
        body = response.getBody();
        responseBody = body.asString();
        log.info(responseBody);
        jsonPath = response.jsonPath();
        log.info(jsonPath.getJsonObject("rating[0].rate").toString());
        log.info("Completed API Demo Test 2 to GET request");
    }

    @Tag("Regression")
    @Tag("API")
    @DisplayName("API Demo Test for POST request")
    @Test
    void demoAPITestForPostRequest() throws JSONException {
        log.info("Start API Demo Test for POST request");
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "shoes");
        requestParams.put("price", 14.5);
        requestParams.put("description", "Lorem Ipsum");
        requestParams.put("image", "https://i.pravatar.cc");
        requestParams.put("category", "electronic");

        httpRequest.body(requestParams.toJSONString());
//        httpRequest.contentType("application/json");
//        httpRequest.header("Authorization", "Token Value");
        response = httpRequest.post("products");

        statusCode = response.getStatusCode();
        log.info(statusCode);
        Assertions.assertEquals(statusCode, 200);
        body = response.getBody();
        responseBody = body.asString();
        log.info(responseBody);
        log.info("Completed API Demo Test for POST request");
    }

    @Tag("Regression")
    @Tag("API")
    @DisplayName("API Demo Test for PUT request")
    @Test
    void demoAPITestForPutRequest() throws JSONException {
        log.info("Start API Demo Test for PUT request");
        executePutRequest(6);
        log.info("Completed API Demo Test for PUT request");
    }

    @Tag("Regression")
    @Tag("UI")
    @DisplayName("UI Demo Test with Selenium")
    @Test
    @Order(1)
    void runDemoUiTestWithJunit() throws InterruptedException, IOException {
        log.info("Start UI Demo Test with Selenium");
        WebDriver driver = launchApplication();
        HomePage onHomePage = new HomePage(driver);
        onHomePage.clickContactUsHeaderButton();
        ContactUsPage onContactUsPage = new ContactUsPage(driver);
        onContactUsPage.enterNameInContactForm("Super Test");
        onContactUsPage.enterPhoneInContactForm("2671233454");
        Thread.sleep(3000);
        getScreenshot("DemoTest", driver);
        closeApplication();
        log.info("Completed UI Demo Test with Selenium");
    }


    public void executePutRequest(int productId) {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "shoes");
        requestParams.put("price", 12.5);
        requestParams.put("description", "Lorem Ipsum");
        requestParams.put("image", "https://i.pravatar.cc");
        requestParams.put("category", "electronic");

        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.put("products/" + productId);

        statusCode = response.getStatusCode();
        log.info(statusCode);
        Assertions.assertEquals(statusCode, 200);

        body = response.getBody();
        responseBody = body.asString();
        log.info(responseBody);

        jsonPath = response.jsonPath();
        log.info(jsonPath.getJsonObject("id").toString());
        log.info(response.getStatusLine());
    }
}
