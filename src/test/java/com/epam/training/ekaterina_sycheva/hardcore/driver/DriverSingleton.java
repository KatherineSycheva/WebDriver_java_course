package com.epam.training.ekaterina_sycheva.hardcore.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver()  {
        String browser = System.getProperty("browser");
        if (driver == null)  {
            switch (browser) {
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(options);
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                    driver = new FirefoxDriver(options);
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
                }
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
