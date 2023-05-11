package com.epam.training.ekaterina_sycheva.hardcore.test;

import com.epam.training.ekaterina_sycheva.hardcore.driver.DriverSingleton;
import com.epam.training.ekaterina_sycheva.hardcore.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeTest()
    public void setup() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest(alwaysRun = true)
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
