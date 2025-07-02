package com.shoppingApp.testCases;

import com.shoppingApp.base.Base;
import com.shoppingApp.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase8_VerifyPayment extends Base {

    @Test
    public void verifyPayment(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickOnLoginLink();
        ProductsPage productsPage = loginPage.login();
        productsPage.addMultipleProductToCart();
        CartPage cartPage = homePage.clickOnCartLink();
        CheckoutPage checkoutPage = cartPage.checkoutProducts();
        PaymentPage paymentPage = checkoutPage.placeOrder();
        Assert.assertTrue(paymentPage.paymentLabel.isDisplayed());
        paymentPage.payment();
        Assert.assertEquals(paymentPage.getSuccessText(),"Congratulations! Your order has been confirmed!");


    }
}
