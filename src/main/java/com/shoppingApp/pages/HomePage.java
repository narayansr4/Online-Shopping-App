package com.shoppingApp.pages;

import com.shoppingApp.base.Base;
import com.shoppingApp.base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    @FindBy(xpath = "//a[@href='/login']")
    WebElement loginLink;

    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsLink;

    @FindBy(xpath = "//div[@class='shop-menu pull-right'] //a[@href='/view_cart']")
    WebElement cartLink;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[4]")
    public WebElement logoutLink;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[5]")
    WebElement deleteAccountLink;

    @FindBy(xpath = "//li/a/b")
    WebElement loggedInUserName;

    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/p[1]")
    public WebElement accountDeletedMsg;

    public HomePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public LoginPage clickOnLoginLink(){
        loginLink.click();
        return new LoginPage();
    }

    public ProductsPage clickOnProductsLink(){
        productsLink.click();
        return new ProductsPage();
    }

    public LoginPage clickOnLogoutLink(){
        logoutLink.click();
        return new LoginPage();
    }


    public CartPage clickOnCartLink(){
        cartLink.click();
        return new CartPage();
    }

    public void clickOnDeleteAccountLink(){
        deleteAccountLink.click();
    }

    public String getLoggedUserName(){
        return loggedInUserName.getText();
    }

    public String getAccountDeletedMsg(){
        return accountDeletedMsg.getText();
    }
}
