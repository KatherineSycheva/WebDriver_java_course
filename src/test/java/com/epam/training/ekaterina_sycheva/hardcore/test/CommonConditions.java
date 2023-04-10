package com.epam.training.ekaterina_sycheva.hardcore.test;

import com.epam.training.ekaterina_sycheva.hardcore.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {

    protected WebDriver driver;

    @BeforeMethod()
    public void setup() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }

    public static String getTabId(){
        return DriverSingleton.getTab();
    }

    public static void openNewTab() {
        DriverSingleton.openNewTab();
    }

    public static void switchToTab(String tabName) {
        DriverSingleton.swichToTab(tabName);
    }

}
