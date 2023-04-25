package com.testology;

import in.techlift.pages.HomePage;
import in.techlift.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingIframe {


    WebDriver chromeDriver;

    @BeforeTest
    void setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--ignore-certificate-errors");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("C:\\Users\\NiksuP\\Downloads\\iframePage.html");
    }

    @Test
    void iframeTest()
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //switching to Iframe using Id
        chromeDriver.switchTo().frame("webPageIframe");
        String paragraph1Text =chromeDriver.findElement(By.xpath("//p[@id='sachin']")).getText();
        System.out.println(paragraph1Text);

        chromeDriver.switchTo().defaultContent();//switching focus/access back to parent webpage content

        WebElement iframe2Element = chromeDriver.findElement(By.xpath("//iframe[@id='iframe2']"));
        chromeDriver.switchTo().frame(iframe2Element);

        WebElement buttonElement = chromeDriver.findElement(By.xpath("//button[contains(text(),'Turn on the light')]"));

        buttonElement.click();

        chromeDriver.switchTo().defaultContent();

        chromeDriver.switchTo().frame(0);
        String paragraph3Text =chromeDriver.findElement(By.xpath("//p[@id='Sania']")).getText();
        System.out.println(paragraph3Text);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        chromeDriver.close();
    }


}
