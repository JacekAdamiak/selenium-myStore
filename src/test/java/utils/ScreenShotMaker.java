package utils;

import driver.manager.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShotMaker {

    @Attachment(value = "Page screenshot test failure", type="image/png")
    public static byte[] makeScreenShot() {
        byte[] screenshotFile = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshotFile;
    }

//    public static void finalScreenShot(){
//        File screenShotFile = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
////        byte[] screenShotFile = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
//
//
//        try {
//            FileHandler.copy(screenShotFile, new File("ScreenShot.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    C:\Users\zamow\Documents\JAVA\JavaSTART\SELENIUM\selenium-myStore\
}
