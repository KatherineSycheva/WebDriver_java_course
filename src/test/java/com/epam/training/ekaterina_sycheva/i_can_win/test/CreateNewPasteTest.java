package com.epam.training.ekaterina_sycheva.i_can_win.test;

import com.epam.training.ekaterina_sycheva.i_can_win.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewPasteTest {

    private WebDriver driver;
    private String code = "Hello from WebDriver";
    private String titleCode = "helloweb";

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteWithoutAuthorization(){
        MainPage mainPage = new MainPage(this.driver);
        mainPage.openPage();
        mainPage.enterCode(code);
        mainPage.setPasteExpirationTime();
        mainPage.setPasteName(titleCode);
        mainPage.clickCreateNewPasteBtn();
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

}
