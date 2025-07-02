package com.shoppingApp.pages;

import com.shoppingApp.base.Base;
import com.shoppingApp.base.DriverManager;
import com.shoppingApp.testDatas.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.Properties;

public class LoginPage extends Base {

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPassword;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//form[@action='/login']/p")
    WebElement errorMsg;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement signUpName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signUpEmail;

    @FindBy(xpath = "//button[text()='Signup']")
    public WebElement signUpButton;




    public LoginPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public  SignUpPage clickOnSignUpButton(){
        signUpButton.click();
        return new SignUpPage();
    }

    public ProductsPage login(){
        loginEmail.sendKeys(prop.getProperty("email"));
        loginPassword.sendKeys(prop.getProperty("password"));
        loginButton.click();
        HomePage homePage = new HomePage();
        ProductsPage productsPage =  homePage.clickOnProductsLink();
        return new ProductsPage();
    }

    public String invalidLogin(){
        loginEmail.sendKeys(TestData.invalidEmail);
        loginPassword.sendKeys(TestData.invalidPassword);
        loginButton.click();
        //WebElement errorMsg = driver.findElement(RelativeLocator.with(By.tagName("p")).below(loginButton));
        return errorMsg.getText();
    }





}
