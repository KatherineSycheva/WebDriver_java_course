package com.epam.training.ekaterina_sycheva.hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TemporaryEmailPage {

    WebDriver driver;
    private static final String url = "https://yopmail.com/";
    @FindBy(css = "a[title=\"Генератор Одноразовых адресов электронной почты создаёт новый адрес для вас за один клик!\"]")
    private WebElement emailGenerator;
    @FindBy(id = "geny")
    private WebElement generatedEmail;
    @FindBy(css = ".nw  > :nth-child(3)")
    private WebElement buttonCheckMail;
    @FindBy(id = "refresh")
    private WebElement buttonRefresh;
    @FindBy(xpath = "/html/body/div[2]/div[2]/button")
    private WebElement buttonLetter;
    @FindBy(id = "nbmail")
    private WebElement numberOfMessagesInMail;
    private WebElement mailEstimatedMonthlyCost;
    @FindBy(xpath = "/html/body/div[1]/div/main/div[2]/div[3]/div/div[1]/iframe")
    private WebElement frameInbox;


    public TemporaryEmailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get(url);
    }

    public void clickEmailGenerator() {
        emailGenerator.click();
    }

    public String getGeneratedEmail() {
        return generatedEmail.getText();
    }

    public String generateEmail()  {
        this.openPage();
        this.clickEmailGenerator();
        return this.getGeneratedEmail();
    }

    public void clickButtonCheckMail() {
        buttonCheckMail.click();
        numberOfMessagesInMail = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(numberOfMessagesInMail));
        String messages = numberOfMessagesInMail.getText();
        while (messages.equals("0 mail")){
            buttonRefresh.click();
            messages = numberOfMessagesInMail.getText();
        }
    }

    public String getEstimatedMonthlyCostFromMail() {
        WebDriver frameDriver = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameInbox));
        mailEstimatedMonthlyCost = new WebDriverWait(frameDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/div/div/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")));
        return mailEstimatedMonthlyCost.getText();
    }



}
