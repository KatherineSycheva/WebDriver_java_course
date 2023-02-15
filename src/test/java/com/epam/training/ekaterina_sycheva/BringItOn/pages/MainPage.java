package com.epam.training.ekaterina_sycheva.BringItOn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private static final String url = "https://pastebin.com/";
    @FindBy(id="postform-text")
    private WebElement codeTextArea;
    @FindBy(id="select2-postform-expiration-container")
    private WebElement clickDropDownPasteExpiration;
    @FindBy(xpath="//li[text()='10 Minutes']")
    private WebElement selectPasteExpiration;
    @FindBy(id="postform-name")
    private WebElement titleInputField;
    @FindBy(css = "[class=\"btn -big\"]")
    private WebElement createNewPasteBtn;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get(url);
    }

    public void enterCode(String code){
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(codeTextArea));
        firstResult.sendKeys(code);
    }

    public void setPasteExpirationTime(){
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 500);
        actions.build().perform();
        clickDropDownPasteExpiration.click();
        selectPasteExpiration.click();
    }

    public void setPasteName(String pasteName){
        titleInputField.sendKeys(pasteName);
    }

    public void clickCreateNewPasteBtn(){
        createNewPasteBtn.click();
    }


}
