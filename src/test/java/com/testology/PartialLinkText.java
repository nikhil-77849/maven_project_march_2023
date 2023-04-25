package com.testology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class PartialLinkText {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--ignore-certificate-errors");
    WebDriver chromeDriver  =  new ChromeDriver(options);// which reference you are getting here

    
    chromeDriver.manage().window().maximize();
    
    //Navigating to test.techlift.in
    chromeDriver.get("https://test.techlift.in/");

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //locating an element via link text now and clicking on that stay
    chromeDriver.findElement(By.partialLinkText("Read")).click();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    chromeDriver.quit();
  }

}