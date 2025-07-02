package com.shoppingApp.pages;

import com.shoppingApp.base.Base;
import com.shoppingApp.base.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPage extends Base {

    @FindBy(xpath = "//div[@class='breadcrumbs']/ol/li[2]")
    public WebElement shoppingCartLabel;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "//tbody/tr")
    List<WebElement> addedItems;

    @FindBy(xpath = "//tbody/tr/td/h4")
    List<WebElement> addedItemsNames;

    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    List<WebElement> deleteIcons;

    public CartPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public int cartItemsCount(){
        int count = 0;
        for(WebElement item : addedItems){
            count++;
        }
        return count;
    }

    public List<String> cartItemsProductNames(){
        List<String> names = new ArrayList<>();
        for (WebElement productName : addedItemsNames){
            names.add(productName.getText());
        }
        Collections.sort(names);
        return names;
    }

    public void clearCart(){
        if (checkoutButton.isDisplayed()) {
            for (WebElement deleteIcon : deleteIcons) {
                deleteIcon.click();
            }
        }
        DriverManager.getDriver().navigate().back();
    }

    public CheckoutPage checkoutProducts(){
        checkoutButton.click();
        return new CheckoutPage();
    }

}
