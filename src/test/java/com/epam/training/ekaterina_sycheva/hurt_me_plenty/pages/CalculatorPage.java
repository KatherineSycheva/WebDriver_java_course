package com.epam.training.ekaterina_sycheva.hurt_me_plenty.pages;

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


    @FindBy(xpath = "//*[@id=\"cloud-site\"]/devsite-iframe/iframe")
    private WebElement calculatorFrame;
    @FindBy(id = "myFrame")
    private  WebElement innerCalculatorFrame;
    @FindBy(xpath = "//*[@id=\"mainForm\"]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]")
    private WebElement computeEngine;
    @FindBy(name = "quantity")
    private WebElement inputNumberOfInstances;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[3]/div[1]/md-input-container/md-select/md-select-value")
    private WebElement operatingSystemsList;
    @FindBy(xpath = "/html/body/div[4]/md-select-menu/md-content/md-option[1]")
    private WebElement selectOperatingSystemType;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[4]/div[1]/md-input-container/md-select/md-select-value")
    private WebElement provisioningModelsList;
    @FindBy(xpath = "/html/body/div[5]/md-select-menu/md-content/md-option[1]")
    private WebElement selectProvisioningModel;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[6]/div[1]/md-input-container/md-select/md-select-value")
    private WebElement seriesList;
    @FindBy(xpath = "/html/body/div[6]/md-select-menu/md-content/md-option[1]")
    private WebElement selectSeries;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[7]/div[1]/md-input-container/md-select")
    private WebElement machineTypeList;
    @FindBy(xpath = "/html/body/div[7]/md-select-menu/md-content/md-optgroup[3]/md-option[4]")
    private WebElement selectMachineType;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[13]/div[1]/md-input-container/md-checkbox")
    private WebElement checkboxAddGPU;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[14]/div/div[1]/div[1]/md-input-container[1]/md-select")
    private WebElement gpuTypeList;
    @FindBy(xpath = "/html/body/div[8]/md-select-menu/md-content/md-option[4]")
    private WebElement selectGpuType;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[14]/div/div[1]/div[1]/md-input-container[2]/md-select")
    private WebElement numberOfGpuList;
    @FindBy(xpath = "/html/body/div[9]/md-select-menu/md-content/md-option[2]")
    private WebElement selectNumberOfGpu;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[15]/div[1]/md-input-container/md-select")
    private WebElement localSSDList;
    @FindBy(xpath = "/html/body/div[10]/md-select-menu/md-content/md-option[3]")
    private WebElement selectLocalSSD;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[16]/div[1]/md-input-container/md-select")
    private WebElement datacenterLocationList;
    @FindBy(xpath = "/html/body/div[11]/md-select-menu/md-content/md-optgroup/md-option[14]")
    private WebElement selectDatacenterLocation;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[19]/div[1]/md-input-container/md-select")
    private WebElement commitedUsageList;
    @FindBy(xpath = "/html/body/div[12]/md-select-menu/md-content/md-option[2]")
    private WebElement selectCommitedUsage;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[20]/button")
    private WebElement buttonAddToEstimate;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/md-content/md-list/md-list-item[4]/div[1]")
    private WebElement enteredProvisioningModel;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/md-content/md-list/md-list-item[5]/div[1]")
    private WebElement enteredInstanceType;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/md-content/md-list/md-list-item[1]/div[1]")
    private WebElement enteredRegion;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/md-content/md-list/md-list-item[8]/div[1]")
    private WebElement enteredLocalSSD;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/md-content/md-list/md-list-item[3]/div[1]")
    private WebElement enteredCommitmentTerm;
    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/div[1]/h2/b")
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
        openList.click();
        WebElement visibleSelectValue = new WebDriverWait(frameDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(selectValue));
        visibleSelectValue.click();
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
        checkboxAddGPU.click();
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
        buttonAddToEstimate.click();
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
