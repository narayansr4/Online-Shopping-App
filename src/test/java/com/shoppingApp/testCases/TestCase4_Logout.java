package com.shoppingApp.testCases;

import com.shoppingApp.base.Base;
import com.shoppingApp.pages.HomePage;
import com.shoppingApp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4_Logout extends Base {
    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void logout(){
        HomePage homePage = new HomePage();
        loginPage = homePage.clickOnLoginLink();
        loginPage.login();
        loginPage = homePage.clickOnLogoutLink();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
