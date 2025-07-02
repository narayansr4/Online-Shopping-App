package com.shoppingApp.testCases;

import com.shoppingApp.base.Base;
import com.shoppingApp.pages.CartPage;
import com.shoppingApp.pages.HomePage;
import com.shoppingApp.pages.LoginPage;
import com.shoppingApp.pages.ProductsPage;
import com.shoppingApp.testDatas.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestCase6_AddMultipleProductsToCart extends Base {
    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Test
    public void addProductsIntoCart() {

        homePage = new HomePage();
        loginPage = homePage.clickOnLoginLink();
        productsPage = loginPage.login();
        productsPage.addMultipleProductToCart();
        cartPage = homePage.clickOnCartLink();

        Assert.assertTrue(cartPage.shoppingCartLabel.isDisplayed());
        Assert.assertEquals(cartPage.cartItemsCount(), TestData.productsToBeAdded.size());

        List<String> duplicateProductsTobeAdded = new ArrayList<>(TestData.productsToBeAdded);
        Collections.sort(duplicateProductsTobeAdded);
        Assert.assertEquals(cartPage.cartItemsProductNames(),duplicateProductsTobeAdded);
        cartPage.clearCart();

    }
}
