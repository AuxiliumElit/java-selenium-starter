package com.example.javaseleniumstarter.pageObjects;

import com.example.javaseleniumstarter.uiComponents.CommonComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactUsPage extends CommonComponents {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(name = "name")
    WebElement nameTextField;

    @FindBy(name = "phone")
    WebElement phoneTextField;

    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    public void enterNameInContactForm(String name) {
        waitForWebElementToAppear(nameTextField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nameTextField);
        nameTextField.sendKeys(name);
    }

    public void enterPhoneInContactForm(String phoneNumber) {
        waitForWebElementToAppear(phoneTextField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", phoneTextField);
        phoneTextField.sendKeys(phoneNumber);
    }

    public void clickRandomLocatorToAppear() {
        waitForElementToAppear(productsBy);
    }


//    public List<WebElement> getProductList() {
//        waitForWebElementToAppear(productsBy);
//        return products;
//    }

//    public WebElement getProductByName(String productName) {
//        WebElement prod = getProductList().stream().filter(product ->
//                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//        return prod;
//    }
//
//
//    public void addProductToCart(String productName) throws InterruptedException {
//        WebElement prod = getProductByName(productName);
//        prod.findElement(addToCart).click();
//        waitForElementToAppear(toastMessage);
//        waitForElementToDisappear(spinner);
//    }
}
