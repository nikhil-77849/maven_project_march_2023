package com.testology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class XpathFirstTest {


    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--ignore-certificate-errors");
        WebDriver chrome_driver = new ChromeDriver(options);
        chrome_driver.get("https://test.techlift.in/login#login");// navigating to login page

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //get the reference from HTML element from web page and store in the emailTextBox Selenium WebElement
        WebElement emailTextBox = chrome_driver.findElement(By.xpath("//input[@id='login_email']"));
        emailTextBox.sendKeys("testology.qa.learning@gmail.com");

        WebElement password = chrome_driver.findElement(By.xpath("//input[@id='login_password']"));
        password.sendKeys("Testology@123");
// login button element
        WebElement loginButton = chrome_driver.findElement(By.xpath("//button[contains(@class,'btn-login')]"));

        loginButton.click();// clicking on the login button

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
