package com.epam.training.ekaterina_sycheva.hurt_me_plenty.pages;

import org.openqa.selenium.JavascriptExecutor;
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
    @FindBy(css = "md-tab-item[md-tab-id=\"1\"]")
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
    @FindBy(xpath = "//md-card-content[2]/md-card/md-card-content/div/div/div/div[1]/h2/b")
    private WebElement totalEstimatedCost;


    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        frameDriver = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(calculatorFrame));
        frameDriver.switchTo().frame(innerCalculatorFrame);
    }

    public void clickComputeEngineButton() {
        computeEngine = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(computeEngine));
        computeEngine.click();
    }


    private void enterDropDownListValuesToCalculator(WebElement openList, WebElement selectValue) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", openList);
        WebElement visibleSelectValue = new WebDriverWait(frameDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(selectValue));
        executor.executeScript("arguments[0].click();", visibleSelectValue);
    }

    public void enterNumberOfInstances(int numberInstances) {
        inputNumberOfInstances.sendKeys(String.valueOf(numberInstances));
    }

    public void enterTypeOfOperatingSystem() {
        enterDropDownListValuesToCalculator(operatingSystemsList, selectOperatingSystemType);
    }

    public void enterProvisioningModel() {
        enterDropDownListValuesToCalculator(provisioningModelsList, selectProvisioningModel);
    }

    public void enterSeries() {
        enterDropDownListValuesToCalculator(seriesList, selectSeries);
    }

    public void enterMachineType() {
        enterDropDownListValuesToCalculator(machineTypeList, selectMachineType);
    }

    public void setCheckboxAddGPU() {
        //checkboxAddGPU.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", checkboxAddGPU);
    }

    public void enterGpuType() {
        enterDropDownListValuesToCalculator(gpuTypeList, selectGpuType);
    }

    public void enterNumberOfGpus() {
        enterDropDownListValuesToCalculator(numberOfGpuList, selectNumberOfGpu);
    }

    public void enterLocalSSD() {
        enterDropDownListValuesToCalculator(localSSDList, selectLocalSSD);
    }

    public void enterDatacenterLocation() {
        enterDropDownListValuesToCalculator(datacenterLocationList, selectDatacenterLocation);
    }

    public void enterCommitedUsage() {
        enterDropDownListValuesToCalculator(commitedUsageList, selectCommitedUsage);
    }

    public void clickButtonAddToEstimate(){
        buttonAddToEstimate = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(buttonAddToEstimate));
        //buttonAddToEstimate.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", buttonAddToEstimate);
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

    public String getTotalEstimatedCost() {
        return totalEstimatedCost.getText();
    }

}
