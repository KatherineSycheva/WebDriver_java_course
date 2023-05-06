package com.epam.training.ekaterina_sycheva.hardcore.test;

import com.epam.training.ekaterina_sycheva.hardcore.driver.DriverSingleton;
import com.epam.training.ekaterina_sycheva.hardcore.service.TestDataReader;
import com.epam.training.ekaterina_sycheva.hardcore.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(TestDataReader.class);

    @BeforeTest()
    public void setup() {
        logger.debug("Receiving driver...");
        driver = DriverSingleton.getDriver();
        logger.debug("Driver received");
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser() {
        logger.debug("Closing browser...");
        DriverSingleton.closeDriver();
        logger.debug("Broser closed");
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
