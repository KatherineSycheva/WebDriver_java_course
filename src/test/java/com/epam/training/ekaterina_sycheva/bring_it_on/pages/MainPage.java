package com.epam.training.ekaterina_sycheva.bring_it_on.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private static final String url = "https://pastebin.com/";
    @FindBy(id="postform-text")
    private WebElement codeTextArea;
    @FindBy(xpath = "//*[@id=\"select2-postform-format-container\"]")
    private WebElement dropDownSyntaxHighlighting;
    @FindBy(xpath = "/html/body/span[2]/span/span[2]/ul/li[2]/ul/li[1]")
    private WebElement selectSyntaxHighlighting;
    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']/parent::span")
    private WebElement dropDownPasteExpiration;
    @FindBy(xpath="//li[text()='10 Minutes']")
    private WebElement selectPasteExpiration;
    @FindBy(id="postform-name")
    private WebElement titleInputField;
    @FindBy(css = "[class=\"btn -big\"]")
    private WebElement createNewPasteBtn;
    @FindBy(css = "[class=\"bash\"]")
    private WebElement pastedCode;
    @FindBy(css = "div[class=\"left\"] > a:nth-child(1)")
    private WebElement codeSyntax;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get(url);
    }

    public void enterCode(String code){
        WebElement visibleCodeTextArea = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(codeTextArea));
        visibleCodeTextArea.sendKeys(code);
    }

    public void setSyntaxHighlighting(){
        dropDownSyntaxHighlighting.click();
        selectSyntaxHighlighting.click();
    }

    public void setPasteExpirationTime() {
        dropDownPasteExpiration.click();
        selectPasteExpiration.click();
    }

    public void setPasteName(String pasteName){
        titleInputField.sendKeys(pasteName);
    }

    public void clickCreateNewPasteBtn(){
        createNewPasteBtn.click();
    }

    public void createNewPaste(String code, String titleCode){
        MainPage mainPage = new MainPage(this.driver);
        mainPage.openPage();
        mainPage.enterCode(code);
        mainPage.setPasteExpirationTime();
        mainPage.setSyntaxHighlighting();
        mainPage.setPasteName(titleCode);
        mainPage.clickCreateNewPasteBtn();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getPastedCode() {
        return pastedCode.getText();
    }

    public String getCodeSyntax() {
        WebElement visibleCodeSyntax = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(codeSyntax));
        return visibleCodeSyntax.getText();
    }

}
