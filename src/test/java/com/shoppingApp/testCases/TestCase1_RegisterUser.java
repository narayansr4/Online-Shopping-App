package com.shoppingApp.testCases;

import com.shoppingApp.base.Base;
import com.shoppingApp.pages.HomePage;
import com.shoppingApp.pages.LoginPage;
import com.shoppingApp.pages.SignUpPage;
import com.shoppingApp.testDatas.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1_RegisterUser extends Base {
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;

    @Test
    public void registerUser(){
        homePage = new HomePage();
        loginPage = homePage.clickOnLoginLink();

        loginPage.signUpName.sendKeys(TestData.signUpName);
        loginPage.signUpEmail.sendKeys(TestData.signUpEmail);
        signUpPage = loginPage.clickOnSignUpButton();

        //Register User
        signUpPage.registerNewUser();
        Assert.assertTrue(signUpPage.successMsg.getText().contains("successfully created"));
        System.out.println("Success message shown for Registration");
        signUpPage.clickOnContinue();

        Assert.assertEquals(homePage.getLoggedUserName(), TestData.firstName);
        System.out.println("User Name Matched!");

        //Delete User
        homePage.clickOnDeleteAccountLink();
        Assert.assertTrue(homePage.accountDeletedMsg.getText().contains("permanently deleted"));
        System.out.println("Account Deleted msg shown");


    }

}
