package com.testology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LoginUsingXpathTest {
    public static void main(String[] args) {
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--ignore-certificate-errors");
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        chromeDriver.get("https://test.techlift.in/login#login");

WebElement emailInputBox= chromeDriver.findElement(By.xpath("//div[@class='password-field']/preceding-sibling::input"));
        emailInputBox.sendKeys("testology.qa.learning@gmail.com");

        WebElement passwordInputBox= chromeDriver.findElement(By.xpath("//input[@id='login_password']"));
        passwordInputBox.sendKeys("Testology@123");

        WebElement loginButton = chromeDriver.findElement(By.xpath("//div[@class='password-field']/following-sibling::button"));
        loginButton.click();

      WebElement educationDropDown=  chromeDriver.findElement(By.xpath("//div[contains(@data-module-name,'Education')]"));
        educationDropDown.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.quit();
    }
}
