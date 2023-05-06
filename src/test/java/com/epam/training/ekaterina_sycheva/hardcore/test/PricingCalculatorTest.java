package com.epam.training.ekaterina_sycheva.hardcore.test;

import com.epam.training.ekaterina_sycheva.hardcore.model.ComputeEngineCalculator;
import com.epam.training.ekaterina_sycheva.hardcore.pages.TemporaryEmailPage;
import com.epam.training.ekaterina_sycheva.hardcore.pages.CalculatorPage;
import com.epam.training.ekaterina_sycheva.hardcore.pages.HomePage;
import com.epam.training.ekaterina_sycheva.hardcore.service.CalculatorCreator;
import com.epam.training.ekaterina_sycheva.hardcore.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PricingCalculatorTest extends CommonConditions {

    private CalculatorPage calculatorPage;
    private TemporaryEmailPage temporaryEmailPage;
    private String textToSearch = new TestDataReader().readProperty("testdata.textToSearch");
    private String email;
    private String temporaryEmailPageHandle;

    public String sendTotalEstimatedCostToMail() {
        temporaryEmailPage = new TemporaryEmailPage(driver);
        email = temporaryEmailPage.openPage().generateEmail();
        temporaryEmailPageHandle = CommonConditions.getTabId();
        CommonConditions.openNewTab();
        calculatorPage = new HomePage(driver).findText(textToSearch);
        ComputeEngineCalculator calculator = CalculatorCreator.withCredentialsFromProperty();
        calculatorPage.enterValuesToPricingCalculator(calculator);
        calculatorPage.clickEmailEstimate();
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

}
