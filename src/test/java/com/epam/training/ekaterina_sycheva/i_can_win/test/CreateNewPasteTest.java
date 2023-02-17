package com.epam.training.ekaterina_sycheva.i_can_win.test;

import com.epam.training.ekaterina_sycheva.i_can_win.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewPasteTest {

    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteWithoutAuthorization(){
        String code = "Hello from WebDriver";
        String titleCode = "helloweb";
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
