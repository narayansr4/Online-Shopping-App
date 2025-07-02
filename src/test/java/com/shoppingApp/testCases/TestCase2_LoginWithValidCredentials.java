package com.shoppingApp.testCases;

import com.shoppingApp.base.Base;
import com.shoppingApp.pages.HomePage;
import com.shoppingApp.pages.LoginPage;
import com.shoppingApp.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2_LoginWithValidCredentials extends Base {

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void loginUser() throws InterruptedException {
        homePage = new HomePage();
        loginPage = homePage.clickOnLoginLink();
        loginPage.login();
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
    }
}
