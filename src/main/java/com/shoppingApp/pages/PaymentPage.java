package com.shoppingApp.pages;

import com.shoppingApp.base.Base;
import com.shoppingApp.base.DriverManager;
import com.shoppingApp.testDatas.TestData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends Base {

     Actions a = new Actions(DriverManager.getDriver());

    @FindBy(xpath = "//div/ol/li[2]")
    public WebElement paymentLabel;

    @FindBy(name = "name_on_card")
    WebElement cardName;

    @FindBy(name = "card_number")
    WebElement cardNumber;

    @FindBy(name = "cvc")
    WebElement cvc;

    @FindBy(name = "expiry_month")
    WebElement expiryMonth;

    @FindBy(name = "expiry_year")
    WebElement expiryYear;

    @FindBy(xpath = "//button[text()='Pay and Confirm Order']")
    WebElement paymentButton;

    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/p")
    WebElement successText;

    public PaymentPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public void payment(){
        cardName.sendKeys(TestData.cardHolderName);
        cardNumber.sendKeys(TestData.cardNum);
        cvc.sendKeys(TestData.cvc);
        expiryMonth.sendKeys(TestData.expMonth);
        expiryYear.sendKeys(TestData.expYear);
        a.moveToElement(paymentButton).click().build().perform();
        //paymentButton.click();
    }

    public String getSuccessText(){
        return successText.getText();
    }





}
