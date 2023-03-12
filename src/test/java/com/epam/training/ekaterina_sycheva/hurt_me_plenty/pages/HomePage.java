package com.epam.training.ekaterina_sycheva.hurt_me_plenty.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private static final String url = "https://cloud.google.com/";
    @FindBy(xpath = "//devsite-search[1]")
    private WebElement loupeButton;
    @FindBy(name = "q")
    private WebElement inputField;
    @FindBy(xpath = "//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a")
    private WebElement firstResultOfSearch;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get(url);
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

}
