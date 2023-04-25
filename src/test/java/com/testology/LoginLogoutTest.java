package com.testology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginLogoutTest {

    private static final String LOGIN_PAGE_URL = "https://test.techlift.in/login#login";
    WebDriver webDriver;// declaring chrome driver at class level
    ChromeOptions options;
    // perform steps before running every test


    private void launchBrowser(String browserName)// pre-requisite - pre-condition for login in to site
    {

        if(browserName.equals("chrome")) {
            options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--ignore-certificate-errors");
            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();
        }
        if(browserName.equals("firefox")) {
          webDriver = new FirefoxDriver();
        }
    }

    @Parameters({"browserName"})
    @Test
    void loginTest(String browserName)// test method receiving the parameter
    {
        launchBrowser(browserName);
        navigateToSite(LOGIN_PAGE_URL);
    enterEmailAddress("testology.qa.learning@gmail.com");
    enterPassword("Testology@123");
    clickOnLoginButton();
    String actualPageTitle= getPageTitle();
        // checking that the page title is equals to Home
        Assert.assertTrue(actualPageTitle.equals("Home1"),"Actual page Title is "+actualPageTitle + "While expected page title was Home1");
    }
        @Test
        void logOutTest()
        {

        }


    @AfterTest
    void terminateBrowser()
    {
webDriver.quit();
    }

    private void enterEmailAddress(String eAddress)
    {
        WebElement emailTextBox= webDriver.findElement(By.xpath("//input[@id='login_email']"));
                emailTextBox.sendKeys(eAddress);
    }

    private void enterPassword(String password)
    {
        WebElement passwordTextBox= webDriver.findElement(By.xpath("//input[@id='login_password']"));
        passwordTextBox.sendKeys(password);
    }

    private void clickOnLoginButton()
    {
        WebDriverWait explicitWait = new WebDriverWait(webDriver,Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath("//button[contains(@class,'btn-login')]")));
        WebElement loginButton= webDriver.findElement(By.xpath("//button[contains(@class,'btn-login')]"));
        loginButton.click();
    }

    private void navigateToSite(String url)
    {

        webDriver.get(url);// navigating to the site
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));// wait for page load
    }

    private String getPageTitle()
    {
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));// wait for page load
        WebDriverWait explicitWait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-module-name,'Education')]")));

        return webDriver.getTitle();
    }
}
