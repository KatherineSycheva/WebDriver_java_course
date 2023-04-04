package com.epam.training.ekaterina_sycheva.hardcore.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private final String PAGE_URL = "https://cloud.google.com/";
    @FindBy(css = ".devsite-top-logo-row-middle > devsite-search")
    private WebElement loupeButton;
    @FindBy(name = "q")
    private WebElement inputField;
    @FindBy(xpath = "(//a/b[text()=\"Google Cloud Platform Pricing Calculator\"])[1]")
    private WebElement firstResultOfSearch;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage(){
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public void openSearchField() {
        WebElement loupeButtonVisible  = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(loupeButton));
        loupeButtonVisible.click();
    }

    public void enterTextToSearchField(String text) {
        inputField.sendKeys(text + Keys.ENTER);
    }

    public void clickFirstResultOfSearch() {
        WebElement visibleFirstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(firstResultOfSearch));
        visibleFirstResult.click();
    }

    public CalculatorPage findText(String textToFind) {
        this.openPage();
        this.openSearchField();
        this.enterTextToSearchField(textToFind);
        this.clickFirstResultOfSearch();
        return new CalculatorPage(driver);
    }

}
