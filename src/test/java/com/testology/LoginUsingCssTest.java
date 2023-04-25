package com.testology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginUsingCssTest {

    public static void main(String[] args) {
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--ignore-certificate-errors");

        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://test.techlift.in/login#login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement emailInputBox= chromeDriver.findElement(By.cssSelector("input#login_email"));
        emailInputBox.sendKeys("testology.qa.learning@gmail.com");

        WebElement passwordInputBox= chromeDriver.findElement(By.cssSelector("input#login_password"));
        passwordInputBox.sendKeys("Testology@123");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement loginButton = chromeDriver.findElement(By.cssSelector("button.btn-login"));
        loginButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.quit();
    }

}
