package com.epam.training.ekaterina_sycheva.hurt_me_plenty.test;

import com.epam.training.ekaterina_sycheva.hurt_me_plenty.pages.CalculatorPage;
import com.epam.training.ekaterina_sycheva.hurt_me_plenty.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PricingCalculatorTest {

    private WebDriver driver;
    private HomePage homePage;
    private CalculatorPage calculatorPage;
    private String textToSeach = "Google Cloud Platform Pricing Calculator";
    private String provisioningModel = "Regular";
    private String instanceType = "n1-standard-8";
    private String region = "Frankfurt";
    private String localSsd = "2x375 GiB";
    private String commitmentTerm = "1 Year";
    private String totalEstimatedCost = "Total Estimated Cost: USD 1,081.20 per 1 month";

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.openPage();
    }


    public CalculatorPage searchText() {
        homePage.openSearchField();
        homePage.enterTextToSearchField(textToSeach);
        homePage.clickFirstResultOfSearch();
        return new CalculatorPage(driver);
    }

    @BeforeTest(alwaysRun = true)
    public void enterValuesToPricingCalculator() {
        calculatorPage = this.searchText();
        calculatorPage.clickComputeEngineButton();
        calculatorPage.enterNumberOfInstances(4);
        calculatorPage.enterTypeOfOperatingSystem();
        calculatorPage.enterProvisioningModel();
        calculatorPage.enterSeries();
        calculatorPage.enterMachineType();
        calculatorPage.setCheckboxAddGPU();
        calculatorPage.enterGpuType();
        calculatorPage.enterNumberOfGpus();
        calculatorPage.enterLocalSSD();
        calculatorPage.enterDatacenterLocation();
        calculatorPage.enterCommitedUsage();
        calculatorPage.clickButtonAddToEstimate();
    }

    @Test(enabled=false)
    public void checkProvisioningModel(){
        Assert.assertEquals(calculatorPage.getEnteredProvisioningModel(), provisioningModel,
                "Provisioning model is " + calculatorPage.getEnteredProvisioningModel() + " instead of " + provisioningModel);
    }

    @Test
    public void checkInstanceType() {
        Assert.assertEquals(calculatorPage.getEnteredInstanceType(), instanceType,
                "Instance type is \"" + calculatorPage.getEnteredInstanceType() + "\" instead of \"" + instanceType + "\"");
    }

    @Test(enabled=false)
    public void checkEnteredRegion() {
        Assert.assertEquals(calculatorPage.getEnteredRegion(), region,
                "Region is \"" + calculatorPage.getEnteredInstanceType() + "\" instead of \"" + instanceType + "\"");
    }

    @Test(enabled=false)
    public void checkEnteredLocalSSD() {
        Assert.assertEquals(calculatorPage.getEnteredLocalSSD(), localSsd,
                "Local SSD is \"" + calculatorPage.getEnteredLocalSSD() + "\" instead of \"" + localSsd + "\"");
    }

    @Test(enabled=false)
    public void checkEnteredCommitmentTerm() {
        Assert.assertEquals(calculatorPage.getCommitmentTerm(), commitmentTerm,
                "Commitment term is \"" + calculatorPage.getCommitmentTerm() + "\" instead of \"" + commitmentTerm + "\"");
    }

    @Test(enabled=false)
    public void checkTotalEstimatedCost(){
        Assert.assertEquals(calculatorPage.getTotalEstimatedCost(), totalEstimatedCost);
    }


    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;

    }
}
