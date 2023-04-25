package com.testology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class BasicLocatorsTest {



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
        WebElement emailTextBox = chrome_driver.findElement(By.id("login_email"));
        emailTextBox.sendKeys("testology.qa.learning@gmail.com");

        //defining a web Element // initializing the web element// instant finding of element on page
        WebElement password = chrome_driver.findElement(By.id("login_password"));
        password.sendKeys("Testology@123");

        List<WebElement> listofButtons = chrome_driver.findElements(By.tagName("button"));
        WebElement loginButton = listofButtons.get(1);// login button element
        loginButton.click();// clicking on the login button

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String pageTitleText= chrome_driver.getTitle();

        System.out.println("Nikhil");
        System.out.println(pageTitleText);

        chrome_driver.quit();


        //Read blog class name tag
        //My First Blog class name tag
        //name = q on google
    }


}
