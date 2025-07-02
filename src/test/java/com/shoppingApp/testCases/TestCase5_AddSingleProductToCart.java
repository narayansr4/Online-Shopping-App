package com.shoppingApp.testCases;

import com.shoppingApp.base.Base;
import com.shoppingApp.pages.CartPage;
import com.shoppingApp.pages.HomePage;
import com.shoppingApp.pages.LoginPage;
import com.shoppingApp.pages.ProductsPage;
import com.shoppingApp.testDatas.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase5_AddSingleProductToCart extends Base {
    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Test
    public void addProductIntoCart() throws InterruptedException {
        homePage = new HomePage();
        loginPage = homePage.clickOnLoginLink();
        productsPage = loginPage.login();
        productsPage.addProductToCart();
        cartPage = productsPage.goToCartPage();
        Assert.assertTrue(cartPage.shoppingCartLabel.isDisplayed());
        Assert.assertEquals(cartPage.cartItemsCount(), TestData.productsToBeAdded.size());
        //cartPage.clearCart();

    }
}
