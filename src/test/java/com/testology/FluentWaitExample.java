package com.testology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FluentWaitExample {


    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        // inform the webDriver to wait the page to load with max time out 10 secs
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebElement buttonElement = chromeDriver.findElement(By.xpath("//button[contains(text(),'Click me to start timer')]"));
        buttonElement.click();

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(chromeDriver)
                .pollingEvery(Duration.ofSeconds(5)).withTimeout(Duration.ofSeconds(15));

        fluentWait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'WebDriver')]"))));
        WebElement textLabel = chromeDriver.findElement(By.xpath("//p[contains(text(),'WebDriver')]"));
        System.out.println("Printing the value of Text label");
        System.out.println(textLabel.getText());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.quit();

}
}
