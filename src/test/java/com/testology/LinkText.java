package com.testology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class LinkText {
 
  public static void main(String[] args) {

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--ignore-certificate-errors");
    WebDriver chromeDriver  =  new ChromeDriver(options);// which reference you are getting here

//
    chromeDriver.manage().window().maximize();
    
    // navigate to the website test.techlift.in
    chromeDriver.get("https://test.techlift.in");

    //locating an element via link text in Selenium now, and clicking on that stay
    WebElement exploreLink = chromeDriver.findElement(By.linkText("Explore"));
    exploreLink.click();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    chromeDriver.quit();// Termination of web driver // browser
  }
 
}