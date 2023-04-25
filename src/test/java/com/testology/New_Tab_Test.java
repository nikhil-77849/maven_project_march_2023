package com.testology;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class New_Tab_Test {
 
  @Test
  void MultipleTabTest(){

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--ignore-certificate-errors");

    WebDriver chromeDriver;
//default or original window is opened
    chromeDriver=  new ChromeDriver(options);// which reference you are getting here


    chromeDriver.manage().window().maximize();
chromeDriver.get("https://test.techlift.in");


Map<String,String> windowTabHandles = new HashMap<>();


    //Store the ID of the original window

      windowTabHandles.put("1",chromeDriver.getWindowHandle() );
    //Check we don't have other windows open already
    assert chromeDriver.getWindowHandles().size() == 1;

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

// Opens a new tab and switches to new tab
    chromeDriver.switchTo().newWindow(WindowType.TAB);

    //navigating to w3schools in new tab
chromeDriver.get("https://w3schools.com");


      windowTabHandles.put("2",chromeDriver.getWindowHandle() );


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

      //check the title of the web page opened in current new tab
    Assert.assertTrue(chromeDriver.getTitle().equals("W3Schools Online Web Tutorials"));
    //driver switching back to original tab
    chromeDriver.switchTo().window(windowTabHandles.get("1"));

      //check the title of the web page opened in original tab
    Assert.assertTrue(chromeDriver.getTitle().equals("Techlift Test"));

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //closing the current tab
chromeDriver.close();
    chromeDriver.switchTo().window(windowTabHandles.get("2"));
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    chromeDriver.close();// closing tab 2
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    chromeDriver.quit();// Termination of web driver process
  }
 
}