package com.epam.training.ekaterina_sycheva.hardcore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private final WebDriver driver;
    private WebDriver frameDriver;


    @FindBy(css = "devsite-iframe > iframe")
    private WebElement calculatorFrame;
    @FindBy(id = "myFrame")
    private  WebElement innerCalculatorFrame;
    @FindBy(css = "md-tab-item:has(div[title=\"Compute Engine\"])")
    private WebElement computeEngine;
    @FindBy(name = "quantity")
    private WebElement inputNumberOfInstances;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.os\"]")
    private WebElement operatingSystemsList;
    @FindBy(css = "md-option[value=\"free\"]")
    private WebElement selectOperatingSystemType;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.class\"]")
    private WebElement provisioningModelsList;
    @FindBy(css = "md-option[value=\"regular\"]")
    private WebElement selectProvisioningModel;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.series\"]")
    private WebElement seriesList;
    @FindBy(css = "md-option[value=\"n1\"]")
    private WebElement selectSeries;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.instance\"]")
    private WebElement machineTypeList;
    @FindBy(css = "md-option[value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]")
    private WebElement selectMachineType;
    @FindBy(css = "md-checkbox[ng-model=\"listingCtrl.computeServer.addGPUs\"]")
    private WebElement checkboxAddGPU;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.gpuType\"]")
    private WebElement gpuTypeList;
    @FindBy(css = "md-option[value=\"NVIDIA_TESLA_V100\"]")
    private WebElement selectGpuType;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.gpuCount\"]")
    private WebElement numberOfGpuList;
    @FindBy(css = "md-option[ng-repeat=\"item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]\"][value=\"1\"]")
    private WebElement selectNumberOfGpu;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.ssd\"]")
    private WebElement localSSDList;
    @FindBy(css = "md-option[ng-repeat=\"item in listingCtrl.dynamicSsd.computeServer\"][value=\"2\"]")
    private WebElement selectLocalSSD;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.location\"]")
    private WebElement datacenterLocationList;
    @FindBy(css = "md-option[value=\"europe-west3\"][ng-repeat=\"item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer\"]")
    private WebElement selectDatacenterLocation;
    @FindBy(css = "md-select[ng-model=\"listingCtrl.computeServer.cud\"]")
    private WebElement commitedUsageList;
    @FindBy(css = ".md-select-menu-container.md-active.md-clickable > ._md > ._md > md-option[value=\"1\"]")
    private WebElement selectCommitedUsage;
    @FindBy(xpath = "(//button[contains(text(), \"Add to Estimate\")])[1]")
    private WebElement buttonAddToEstimate;
    @FindBy(css = ".cpc-cart-total > .md-title > .ng-binding")
    private WebElement totalEstimatedCost;
    @FindBy(id = "Email Estimate")
    private WebElement buttonEmailEstimate;
    @FindBy(css = "input[ng-model=\"emailQuote.user.email\"]")
    private WebElement fieldEmailEstimate;
    @FindBy(xpath = "md-dialog-actions > button:nth-child(2)")
    private WebElement buttonSendEmail;


    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        frameDriver = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(calculatorFrame));
        frameDriver.switchTo().frame(innerCalculatorFrame);
    }

    private void clickComputeEngineButton() {
        computeEngine = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(computeEngine));
        computeEngine.click();
    }

    private void enterDropDownListValuesToCalculator(WebElement openList, WebElement selectValue) {
        openList.click();
        WebElement visibleSelectValue = new WebDriverWait(frameDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(selectValue));
        visibleSelectValue.click();
    }

    public String getTotalEstimatedCost() {
        String cost = totalEstimatedCost.getText().strip();
        cost = cost.substring(22, 34);
        return cost;
    }

    public void enterValuesToPricingCalculator(String numberOfInstances) {
        this.clickComputeEngineButton();
        inputNumberOfInstances.sendKeys(numberOfInstances);
        this.enterDropDownListValuesToCalculator(operatingSystemsList, selectOperatingSystemType);
        this.enterDropDownListValuesToCalculator(provisioningModelsList, selectProvisioningModel);
        this.enterDropDownListValuesToCalculator(seriesList, selectSeries);
        this.enterDropDownListValuesToCalculator(machineTypeList, selectMachineType);
        checkboxAddGPU.click();
        this.enterDropDownListValuesToCalculator(gpuTypeList, selectGpuType);
        this.enterDropDownListValuesToCalculator(numberOfGpuList, selectNumberOfGpu);
        this.enterDropDownListValuesToCalculator(localSSDList, selectLocalSSD);
        this.enterDropDownListValuesToCalculator(datacenterLocationList, selectDatacenterLocation);
        this.enterDropDownListValuesToCalculator(commitedUsageList, selectCommitedUsage);
        buttonAddToEstimate.click();
        buttonEmailEstimate.click();
    }

    public void sendEstimatedCostToMail(String email) {
        fieldEmailEstimate.sendKeys(email);
        buttonSendEmail.click();
    }
}
