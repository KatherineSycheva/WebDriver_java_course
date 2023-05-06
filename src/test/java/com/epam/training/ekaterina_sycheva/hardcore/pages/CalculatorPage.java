package com.epam.training.ekaterina_sycheva.hardcore.pages;

import com.epam.training.ekaterina_sycheva.hardcore.model.ComputeEngineCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage extends BasePage {
    private WebDriver frameDriver;
    protected static final Logger logger = LogManager.getLogger(CalculatorPage.class);


    @FindBy(css = "devsite-iframe > iframe")
    private WebElement calculatorFrame;
    @FindBy(id = "myFrame")
    private  WebElement innerCalculatorFrame;
    @FindBy(css = "#tab-item-1")
    private WebElement computeEngine;
    @FindBy(name = "quantity")
    private WebElement inputNumberOfInstances;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.os\"]")
    private WebElement operatingSystemsList;
    String selectOperatingSystemTypeCSS = "md-option[value=\"free\"]";
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.class\"]")
    private WebElement provisioningModelsList;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.series\"]")
    private WebElement seriesList;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.instance\"]")
    private WebElement machineTypeList;
    @FindBy(css = "md-checkbox[ng-model=\"listingCtrl.computeServer.addGPUs\"]")
    private WebElement checkboxAddGPU;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.gpuType\"]")
    private WebElement gpuTypeList;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.gpuCount\"]")
    private WebElement numberOfGpuList;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.ssd\"]")
    private WebElement localSSDList;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.location\"]")
    private WebElement datacenterLocationList;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.cud\"]")
    private WebElement commitedUsageList;
    @FindBy(xpath = "(//button[contains(text(), \"Add to Estimate\")])[1]")
    private WebElement buttonAddToEstimate;
    @FindBy(css = ".cpc-cart-total > .md-title > .ng-binding")
    private WebElement totalEstimatedCost;
    @FindBy(id = "Email Estimate")
    private WebElement buttonEmailEstimate;
    @FindBy(css = "input[ng-model=\"emailQuote.user.email\"]")
    private WebElement fieldEmailEstimate;
    @FindBy(css = "form[name=\"emailForm\"] > md-dialog-actions > button:nth-child(2)")
    private WebElement buttonSendEmail;
    @FindBy(xpath = "//md-list/md-list-item[4]/div[1]")
    private WebElement enteredProvisioningModel;
    @FindBy(xpath = "//md-list/md-list-item[5]/div[1]")
    private WebElement enteredInstanceType;
    @FindBy(xpath = "//md-list/md-list-item[1]/div[1]")
    private WebElement enteredRegion;
    @FindBy(xpath = "//md-list/md-list-item[7]/div[1]")
    private WebElement enteredLocalSSD;
    @FindBy(xpath = "//md-list/md-list-item[3]/div[1]")
    private WebElement enteredCommitmentTerm;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        frameDriver = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(calculatorFrame));
        frameDriver.switchTo().frame(innerCalculatorFrame);
    }

    @Override
    public CalculatorPage openPage()
    {
        logger.info("Calculator page opened");
        return this;
    }

    private void clickComputeEngineButton() {
        computeEngine = new WebDriverWait(frameDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(computeEngine));
        computeEngine.click();
    }

    private void enterDropDownListValuesToCalculator(WebElement openList, String selectValue) {
        openList.click();
        WebElement visibleSelectValue = new WebDriverWait(frameDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectValue)));
        visibleSelectValue.click();
    }

    public String getTotalEstimatedCost() {
        String cost = totalEstimatedCost.getText().strip();
        cost = cost.substring(22, 34);
        logger.info("Total estimated cost computed");
        return cost;
    }

    public void enterValuesToPricingCalculator(ComputeEngineCalculator calculator) {
        logger.info("Entering test data to calculator:\n {}",calculator.toString());
        this.clickComputeEngineButton();
        inputNumberOfInstances.sendKeys(calculator.getNumberOfInstances());
        this.enterDropDownListValuesToCalculator(operatingSystemsList, calculator.getOperatingSystemType());
        this.enterDropDownListValuesToCalculator(provisioningModelsList, calculator.getProvisioningModel());
        this.enterDropDownListValuesToCalculator(seriesList, calculator.getSeries());
        this.enterDropDownListValuesToCalculator(machineTypeList, calculator.getMachineType());
        if (calculator.getGpu() != null) {
            checkboxAddGPU.click();
        }
        this.enterDropDownListValuesToCalculator(localSSDList, calculator.getLocalSSD());
        this.enterDropDownListValuesToCalculator(datacenterLocationList, calculator.getDatacenterLocation());
        this.enterDropDownListValuesToCalculator(commitedUsageList, calculator.getCommitedUsage());
        buttonAddToEstimate.click();
        logger.info("Values entered");
    }

    public void clickEmailEstimate() {
        buttonEmailEstimate.click();
    }

    public void sendEstimatedCostToMail(String email) {
        fieldEmailEstimate.sendKeys(email);
        buttonSendEmail.click();
        logger.info("Email sent");
    }

    public String getEnteredProvisioningModel() {
        return enteredProvisioningModel.getText().substring(19).strip();
    }

    public String getEnteredInstanceType() {
        String contentInstanceType =  enteredInstanceType.getText();
        return contentInstanceType.substring(15, contentInstanceType.length() - 30).strip();
    }

    public String getEnteredRegion() {
        return enteredRegion.getText().substring(8).strip();
    }

    public String getEnteredLocalSSD() {
        String localSSDText = enteredLocalSSD.getText().strip();
        return localSSDText.substring(11, localSSDText.length() - 31).strip();
    }

    public String getCommitmentTerm() {
        return enteredCommitmentTerm.getText().strip().substring(17);
    }
}
