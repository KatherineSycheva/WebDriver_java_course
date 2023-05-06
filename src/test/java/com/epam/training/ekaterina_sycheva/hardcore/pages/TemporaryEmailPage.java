package com.epam.training.ekaterina_sycheva.hardcore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TemporaryEmailPage extends BasePage {

    private static final String PAGE_URL = "https://yopmail.com/";
    protected static final Logger logger = LogManager.getLogger(CalculatorPage.class);

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
        logger.info("Page for email generating opened");
        return this;
    }

    public String generateEmail()  {
        this.openPage();
        emailGenerator.click();
        logger.info("Email generated: {}", generatedEmail.getText());
        return generatedEmail.getText();
    }

    public void clickButtonCheckMail() throws InterruptedException {
        logger.info("Waiting for email from calculator...");
        buttonCheckMail.click();
        numberOfMessagesInMail = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(numberOfMessagesInMail));
        String messages = numberOfMessagesInMail.getText();
        int counterOfClick = 0;
        while ((messages.equals("0 mail")) && (counterOfClick < 100)){
            buttonRefresh.click();
            Thread.sleep(500);
            messages = numberOfMessagesInMail.getText();
        }
        if (messages != "0 mail") {
            logger.info("Email received");
        }
    }

    public String getEstimatedMonthlyCostFromMail() {
        driver = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameInbox));
        mailEstimatedMonthlyCost = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(mailEstimatedMonthlyCost));
        logger.info("Got total estimated cost from email");
        return mailEstimatedMonthlyCost.getText();
    }
}
