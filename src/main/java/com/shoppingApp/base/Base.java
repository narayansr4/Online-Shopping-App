package com.shoppingApp.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Base {

    public static Properties prop;

    public Base(){
        prop = new Properties();
        FileInputStream fis;
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\shoppingApp\\config\\config.properties";
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @BeforeMethod
    public void initialize(){
        String browserName = prop.getProperty("browser");

        switch (browserName){
            case "chrome"  :
                             ChromeOptions options = new ChromeOptions();
                             options.addArguments("--incognito");
                             WebDriver driver = new ChromeDriver(options);
                             DriverManager.setDriver(driver);
                             break;

            case "edge"    :  ChromeOptions options2 = new ChromeOptions();
                              options2.addArguments("--incognito");
                              WebDriver driver2 = new EdgeDriver();
                              DriverManager.setDriver(driver2);
                              break;
            default:
                System.out.println("Invalid Browser");
        }

        DriverManager.getDriver().manage().deleteAllCookies(); //driver.manage().deleteAllCookies()
        DriverManager.getDriver().get(prop.getProperty("url"));
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void teardown(){
        DriverManager.quitDriver(); //driver.quit();
    }


}
