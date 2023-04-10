package com.epam.training.ekaterina_sycheva.hardcore.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {

    private static final String RESOURCE_PATH = "src\\test\\resources\\";
    private static WebDriver driver;

    public static WebDriver getDriver()  {
        String browser = System.getProperty("browser");
        if (driver == null)  {
            switch (browser) {
                case "edge": {
                    System.setProperty("webdriver.edge.driver", RESOURCE_PATH + "msedgedriver.exe");
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(options);
                    break;
                }
                case "chrome": {
                    System.setProperty("webdriver.chrome.driver", RESOURCE_PATH + "chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
                }
/*
                case "firefox": {
                    System.setProperty("webdriver.chrome.driver", RESOURCE_PATH + "geckodriver.exe");
                    FirefoxOptions options = new FirefoxOptions();
                    options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                    driver = new FirefoxDriver(options);
                    break;
                }
*/
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static String getTab(){
        return driver.getWindowHandle();
    }

    public static void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public static void swichToTab(String tabName) {
        driver.switchTo().window(tabName);
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
