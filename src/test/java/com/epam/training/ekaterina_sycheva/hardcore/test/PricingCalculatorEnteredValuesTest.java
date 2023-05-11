package com.epam.training.ekaterina_sycheva.hardcore.test;

import com.epam.training.ekaterina_sycheva.hardcore.model.ComputeEngineCalculator;
import com.epam.training.ekaterina_sycheva.hardcore.pages.CalculatorPage;
import com.epam.training.ekaterina_sycheva.hardcore.pages.HomePage;
import com.epam.training.ekaterina_sycheva.hardcore.service.CalculatorCreator;
import com.epam.training.ekaterina_sycheva.hardcore.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class PricingCalculatorEnteredValuesTest extends CommonConditions {
    private TestDataReader testDataReader = new TestDataReader();
    private CalculatorPage calculatorPage;
    private String textToSearch = testDataReader.readProperty("testdata.textToSearch");
    private String provisioningModel = testDataReader.readProperty("testdata.enteredProvisioningModel");
    private String instanceType = testDataReader.readProperty("testdata.enteredMachineType");
    private String region = testDataReader.readProperty("testdata.enteredRegion");
    private String localSsd = testDataReader.readProperty("testdata.enteredLocalSSD");
    private String commitmentTerm = testDataReader.readProperty("testdata.enteredCommtedUsage");

    @BeforeClass
    private void searchCalculatorPage(){
        HomePage hp = new HomePage(driver);
        calculatorPage = hp.findText(textToSearch);
        ComputeEngineCalculator calculator = CalculatorCreator.withCredentialsFromProperty();
        calculatorPage.openPage().switchToInnerCalculatorFrame();
        calculatorPage.enterValuesToPricingCalculator(calculator);
    }

    @BeforeMethod
    private void switchToFrame() {
        calculatorPage.switchToInnerCalculatorFrame();
    }

    @Test
    public void checkProvisioningModel(){
        Assert.assertEquals(calculatorPage.getEnteredProvisioningModel(), provisioningModel);
    }

    @Test
    public void checkInstanceType() {
        Assert.assertEquals(calculatorPage.getEnteredInstanceType(), instanceType);
    }

    @Test
    public void checkEnteredRegion() {
        Assert.assertEquals(calculatorPage.getEnteredRegion(), region);
    }

    @Test
    public void checkEnteredLocalSSD() {
        Assert.assertEquals(calculatorPage.getEnteredLocalSSD(), localSsd);
    }

    @Test
    public void checkEnteredCommitmentTerm() {
        Assert.assertEquals(calculatorPage.getCommitmentTerm(), commitmentTerm);
    }

}
