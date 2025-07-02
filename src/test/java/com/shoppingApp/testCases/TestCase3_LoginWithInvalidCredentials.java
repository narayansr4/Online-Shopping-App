package com.shoppingApp.testCases;

import com.shoppingApp.base.Base;
import com.shoppingApp.pages.HomePage;
import com.shoppingApp.pages.LoginPage;
import com.shoppingApp.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3_LoginWithInvalidCredentials extends Base {

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void loginInvalidUser(){
        homePage = new HomePage();
        loginPage = homePage.clickOnLoginLink();
        Assert.assertEquals(loginPage.invalidLogin(),"Your email or password is incorrect!");
    }
}
