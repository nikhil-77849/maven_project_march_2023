package com.testology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class LoginUsingRelativeLocatorsTest {


    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--ignore-certificate-errors");
        WebDriver chrome_driver = new ChromeDriver(options);
        chrome_driver.get("https://test.techlift.in/login#login");// navigating to login page


        //get the reference from HTML element from web page and store in the emailTextBox Selenium WebElement


        WebElement loginLabel = chrome_driver.findElement(By.cssSelector("span[data-text='Login']"));

        WebElement emailTextBox = chrome_driver.findElement(with(By.cssSelector("input#login_email")).below(loginLabel));
        emailTextBox.sendKeys("testology.qa.learning@gmail.com");

        WebElement loginButton = chrome_driver.findElement(By.xpath("//button[contains(@class,'btn-login')]"));


        WebElement password = chrome_driver.findElement(with(By.xpath("//input[@id='login_password']")).above(loginButton));
        password.sendKeys("Testology@123");



        // login button element

        loginButton.click();// clicking on the login button
        WebDriverWait explicitWait = new WebDriverWait(chrome_driver, Duration.ofSeconds(2));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-module-name,'Education')]")));

        WebElement educationDropDown=  chrome_driver.findElement(By.xpath("//div[contains(@data-module-name,'Education')]"));
        educationDropDown.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        String pageTitleText = chrome_driver.getTitle();

        System.out.println("Nikhil");
        System.out.println(pageTitleText);

        chrome_driver.quit();


    }

}
