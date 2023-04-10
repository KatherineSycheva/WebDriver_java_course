package com.epam.training.ekaterina_sycheva.hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TemporaryEmailPage extends BasePage {

    private static final String PAGE_URL = "https://yopmail.com/";
    @FindBy(css = "a[title=\"Генератор Одноразовых адресов электронной почты создаёт новый адрес для вас за один клик!\"]")
    private WebElement emailGenerator;
    @FindBy(id = "geny")
    private WebElement generatedEmail;
    @FindBy(css = ".nw  > :nth-child(3)")
    private WebElement buttonCheckMail;
    @FindBy(id = "refresh")
    private WebElement buttonRefresh;
    @FindBy(css = ".lm")
    private WebElement buttonLetter;
    @FindBy(id = "nbmail")
    private WebElement numberOfMessagesInMail;
    @FindBy(css = "#ifmail")
    private WebElement frameInbox;
    @FindBy(css = "table > tbody > tr:nth-child(1) > td:nth-child(4)")
    private WebElement mailEstimatedMonthlyCost;


    public TemporaryEmailPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public TemporaryEmailPage openPage(){
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public String generateEmail()  {
        this.openPage();
        emailGenerator.click();
        return generatedEmail.getText();
    }

    public void clickButtonCheckMail() throws InterruptedException {
        buttonCheckMail.click();
        numberOfMessagesInMail = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(numberOfMessagesInMail));
        String messages = numberOfMessagesInMail.getText();
        int counterOfClick = 0;
        while ((messages.equals("0 mail")) && (counterOfClick < 1000)){
            buttonRefresh.click();
            Thread.sleep(500);
            messages = numberOfMessagesInMail.getText();
        }
    }

    public String getEstimatedMonthlyCostFromMail() {
        driver = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameInbox));
        mailEstimatedMonthlyCost = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(mailEstimatedMonthlyCost));
        return mailEstimatedMonthlyCost.getText();
    }
}
