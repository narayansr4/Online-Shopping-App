package com.shoppingApp.testCases;

import com.shoppingApp.base.Base;
import com.shoppingApp.pages.*;
import com.shoppingApp.testDatas.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase7_CheckoutProducts extends Base {

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;

    @Test
    public void checkoutProductsFromCart() {

        homePage = new HomePage();
        loginPage = homePage.clickOnLoginLink();
        productsPage = loginPage.login();
        productsPage.addMultipleProductToCart();
        cartPage = homePage.clickOnCartLink();
        checkoutPage = cartPage.checkoutProducts();
        Assert.assertTrue(checkoutPage.checkoutLabel.isDisplayed());

        //To clear cart before every test:
        homePage.clickOnCartLink();
        cartPage.clearCart();


    }
}
