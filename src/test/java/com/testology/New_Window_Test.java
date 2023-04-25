package com.testology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class New_Window_Test {
 
  @Test
  void MultipleWindowTest(){

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--ignore-certificate-errors");

    WebDriver chromeDriver;
//default or original window is opened
    chromeDriver=  new ChromeDriver(options);// which reference you are getting here


    chromeDriver.manage().window().maximize();
chromeDriver.get("https://test.techlift.in");


Map<String,String> windowHandles = new HashMap<>();


    //Store the ID of the original window

    windowHandles.put("1",chromeDriver.getWindowHandle() );
    //Check we don't have other windows open already
    assert chromeDriver.getWindowHandles().size() == 1;

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

// Opens a new window and switches to new window
    chromeDriver.switchTo().newWindow(WindowType.WINDOW);

    //navigating to w3schools in new window
chromeDriver.get("https://w3schools.com");
    //chromeDriver.switchTo().newWindow(WindowType.TAB);

    windowHandles.put("2",chromeDriver.getWindowHandle() );


    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }




   /* //Loop through until we find a new window handle
    for (String windowHandle : chromeDriver.getWindowHandles()) {
      if(!originalWindow.contentEquals(windowHandle)) {
        chromeDriver.switchTo().window(windowHandle);
        break;
      }
    }*/
    Assert.assertTrue(chromeDriver.getTitle().equals("W3Schools Online Web Tutorials"));
    //driver switching back to original window
    chromeDriver.switchTo().window(windowHandles.get("1"));

    Assert.assertTrue(chromeDriver.getTitle().equals("Techlift Test"));

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //closing the current window
chromeDriver.close();
    chromeDriver.switchTo().window(windowHandles.get("2"));
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    chromeDriver.close();// closing window 2
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    chromeDriver.quit();// Termination of web driver // browser
  }
 
}