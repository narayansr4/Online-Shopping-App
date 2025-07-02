package com.shoppingApp.pages;

import com.shoppingApp.base.Base;
import com.shoppingApp.base.DriverManager;
import com.shoppingApp.testDatas.TestData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends Base {

    @FindBy(id = "id_gender1")
    WebElement mr;

    @FindBy(id = "id_gender2")
    WebElement mrs;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement day;

    @FindBy(id = "months")
    public WebElement month;

    @FindBy(id = "years")
    public WebElement year;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;

    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/p[1]")
    public WebElement successMsg;

    public SignUpPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public void selectTitle(String gender){
        if (gender.equalsIgnoreCase("male")){
            mr.click();
        }
        else if (gender.equalsIgnoreCase("female")){
            mrs.click();
        }
        else System.out.println("Invalid Gender");
    }

    public void setDay(String day){
        Select select = new Select(this.day);
        select.selectByValue(day);
    }

    public void setMonth(String month){
        Select select = new Select(this.month);
        select.selectByVisibleText(month);
    }

    public void setYear(String year){
        Select select = new Select(this.year);
        select.selectByValue(year);
    }

    public void registerNewUser(){
        selectTitle(TestData.gender);
        password.sendKeys(TestData.password);
        setDay(TestData.day);
        setMonth(TestData.month);
        setYear(TestData.year);
        firstName.sendKeys(TestData.firstName);
        lastName.sendKeys(TestData.lastName);
        company.sendKeys(TestData.company);
        address.sendKeys(TestData.address);
        state.sendKeys(TestData.state);
        city.sendKeys(TestData.city);
        zipcode.sendKeys(TestData.zipcode);
        mobileNumber.sendKeys(TestData.mobileNum);
        createAccountButton.click();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void clickOnContinue(){
        continueButton.click();
    }

}
