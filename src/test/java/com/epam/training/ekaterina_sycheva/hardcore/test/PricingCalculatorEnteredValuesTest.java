package com.epam.training.ekaterina_sycheva.hardcore.test;

import com.epam.training.ekaterina_sycheva.hardcore.model.ComputeEngineCalculator;
import com.epam.training.ekaterina_sycheva.hardcore.pages.CalculatorPage;
import com.epam.training.ekaterina_sycheva.hardcore.pages.HomePage;
import com.epam.training.ekaterina_sycheva.hardcore.service.CalculatorCreator;
import com.epam.training.ekaterina_sycheva.hardcore.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PricingCalculatorEnteredValuesTest extends CommonConditions {

    private CalculatorPage calculatorPage;
    private String textToSearch = TestDataReader.getTestData("testdata.textToSearch");
    private String provisioningModel = TestDataReader.getTestData("testdata.enteredProvisioningModel");
    private String instanceType = TestDataReader.getTestData("testdata.enteredMachineType");
    private String region = TestDataReader.getTestData("testdata.enteredRegion");
    private String localSsd = TestDataReader.getTestData("testdata.enteredLocalSSD");
    private String commitmentTerm =TestDataReader.getTestData("testdata.enteredCommtedUsage");

    @BeforeClass
    private void searchCalculatorPage(){
        HomePage hp = new HomePage(driver);
        calculatorPage = hp.openPage().findText(textToSearch);
        ComputeEngineCalculator calculator = CalculatorCreator.withCredentialsFromProperty();
        calculatorPage.enterValuesToPricingCalculator(calculator);
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
