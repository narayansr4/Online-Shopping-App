package com.shoppingApp.pages;

import com.shoppingApp.base.Base;
import com.shoppingApp.base.DriverManager;
import com.shoppingApp.testDatas.TestData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends Base {

    @FindBy(id = "search_product")
    WebElement searchProductTextbox;

    @FindBy(id = "submit_search")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    List<WebElement> productCards;

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='productinfo text-center']/h2")
    List<WebElement> productPrices;

    @FindBy(xpath = "//div[@class='productinfo text-center']/a")
    List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[@class='modal-body'] //a[@href='/view_cart']")
    WebElement viewCartButton;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShoppingButton;

    public ProductsPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public void searchProduct(){
        searchProductTextbox.sendKeys("winter top");
        searchButton.click();
    }

    public void addProductToCart(){
        for (int i = 0; i < productNames.size(); i ++){
            if (productNames.get(i).getText().equalsIgnoreCase(TestData.productToBeAdded)){
                addToCartButtons.get(i).click();
                break;
            }
        }
    }

    public void addMultipleProductToCart(){
        for (int i = 0; i < productNames.size(); i ++){
            if (TestData.productsToBeAdded.contains(productNames.get(i).getText())){
                addToCartButtons.get(i).click();
                continueShoppingButton.click();

            }
        }
    }

    public CartPage goToCartPage(){
        viewCartButton.click();
        return new CartPage();
    }



}
