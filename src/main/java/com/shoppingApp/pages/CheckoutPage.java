package com.shoppingApp.pages;

import com.shoppingApp.base.Base;
import com.shoppingApp.base.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Base {

    Actions a = new Actions(DriverManager.getDriver());

    @FindBy(xpath = "//div/ol/li[2]")
    public WebElement checkoutLabel;

    @FindBy(xpath = "//a[text()='Place Order']")
    WebElement placeOrderButton;

    public CheckoutPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public PaymentPage placeOrder(){
        a.moveToElement(placeOrderButton).click().build().perform();
        return new PaymentPage();
    }
}
