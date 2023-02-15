package com.epam.training.ekaterina_sycheva.test;

import com.epam.training.ekaterina_sycheva.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewPasteTest {

    private WebDriver driver;
    private String code = "Hello from WebDriver";
    private String titleCode = "helloweb";

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
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
