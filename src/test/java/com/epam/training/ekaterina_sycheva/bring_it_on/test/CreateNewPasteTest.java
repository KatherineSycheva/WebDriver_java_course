package com.epam.training.ekaterina_sycheva.bring_it_on.test;

import com.epam.training.ekaterina_sycheva.bring_it_on.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CreateNewPasteTest {

    private WebDriver driver;
    private String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force\n";
    private String titleCode = "how to gain dominance among developers";
    private MainPage mainPage;

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        mainPage.createNewPaste(code, titleCode);
    }

    @Test
    public void browserTitleEqualPasteName() {
        Assert.assertTrue(mainPage.getPageTitle().contains(titleCode), "Title of created page doesn't equal to entered. Must be: " + code + " received: " + mainPage.getPageTitle());
    }

    @Test
    public void syntaxCodeEqualBash() {
        Assert.assertEquals(mainPage.getCodeSyntax(), "Bash", "Syntax doesn't equal to entered");
    }

    @Test
    public void codeEqualsEntered(){
        Assert.assertEquals(mainPage.getPastedCode().strip(), code.strip(),
                "Code on the page doesn't equal to entered. Must be: \n" + code + "\nbut received: \n" +  mainPage.getPastedCode());
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

}
