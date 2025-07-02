package com.shoppingApp.testComponents;

import com.shoppingApp.base.Base;
import com.shoppingApp.base.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot extends Base {
    public static String captureScreenshot(String testcaseName){

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH.mm.ss");
        String formattedDate = dateTime.format(formatter);

        String path = System.getProperty("user.dir") + "\\screenshots\\" + testcaseName + formattedDate + ".png";
        TakesScreenshot sc = (TakesScreenshot) DriverManager.getDriver();
        File img = sc.getScreenshotAs(OutputType.FILE);

        File destFile = new File(path);
        try {
            FileHandler.copy(img,destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "../screenshots/" + testcaseName + formattedDate + ".png";
    }
}
