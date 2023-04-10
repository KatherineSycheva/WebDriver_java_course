package com.epam.training.ekaterina_sycheva.hardcore.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    protected abstract BasePage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
