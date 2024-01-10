package com.example.javaseleniumstarter.pageObjects;

import com.example.javaseleniumstarter.uiComponents.CommonComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonComponents {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement passwordEle;

    @FindBy(id="login")
    WebElement submit;
    @FindBy(xpath="//header/nav[1]/div[1]/div[1]/div[2]/div[1]/a[1]")
    WebElement contactUsHeaderButton;

    public void clickContactUsHeaderButton(){
        waitForWebElementToAppear(contactUsHeaderButton);
        contactUsHeaderButton.click();

    }


//    public ProductCatalogue loginApplication(String email,String password)
//    {
//        userEmail.sendKeys(email);
//        passwordEle.sendKeys(password);
//        submit.click();
//        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
//        return productCatalogue;
//    }

    public String getErrorMessage()
    {
        waitForWebElementToAppear(contactUsHeaderButton);
        return contactUsHeaderButton.getText();
    }

    public void goToHome()
    {
        driver.get("https://auxiliumelit.com/");
    }
}
