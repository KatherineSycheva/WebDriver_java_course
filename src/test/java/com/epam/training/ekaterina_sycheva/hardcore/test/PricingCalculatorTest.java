package com.epam.training.ekaterina_sycheva.hardcore.test;

import com.epam.training.ekaterina_sycheva.hardcore.pages.TemporaryEmailPage;
import com.epam.training.ekaterina_sycheva.hardcore.pages.CalculatorPage;
import com.epam.training.ekaterina_sycheva.hardcore.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PricingCalculatorTest extends CommonConditions {

    private HomePage homePage;
    private CalculatorPage calculatorPage;
    private TemporaryEmailPage temporaryEmailPage;
    private String textToSeach = "Google Cloud Platform Pricing Calculator";
    private String numberOfInstances = "4";
    private String email;
    private String temporaryEmailPageHandle;

/*
    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        temporaryEmailPage = new TemporaryEmailPage(driver);
        temporaryEmailPageHandle = driver.getWindowHandle();
        email = temporaryEmailPage.generateEmail();
        driver.switchTo().newWindow(WindowType.TAB);
        homePage = new HomePage(driver);
        calculatorPage = homePage.findText(textToSeach);
        calculatorPageHandle = driver.getWindowHandle();
    }
*/

    public String sendTotalEstimatedCostToMail() {
        temporaryEmailPage = new TemporaryEmailPage(driver);
        email = temporaryEmailPage.openPage().generateEmail();
        temporaryEmailPageHandle = CommonConditions.getTabId();
        CommonConditions.openNewTab();
        calculatorPage = new HomePage(driver).openPage().findText(textToSeach);
        calculatorPage.enterValuesToPricingCalculator(numberOfInstances);
        String totalEstimatedCost = calculatorPage.getTotalEstimatedCost();
        calculatorPage.sendEstimatedCostToMail(email);
        return totalEstimatedCost;
    }

    public String getTotalEstimatedCostInMail() throws InterruptedException {
        CommonConditions.switchToTab(temporaryEmailPageHandle);
        driver.switchTo().window(temporaryEmailPageHandle);
        temporaryEmailPage.clickButtonCheckMail();
        return temporaryEmailPage.getEstimatedMonthlyCostFromMail();
    }

    @Test
    public void costInMailEqualCostInCalculator() throws InterruptedException {
        String costInCalculator = sendTotalEstimatedCostToMail();
        String costInMail = getTotalEstimatedCostInMail();
        Assert.assertEquals(costInCalculator, costInMail);
    }

/*    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }*/
}
