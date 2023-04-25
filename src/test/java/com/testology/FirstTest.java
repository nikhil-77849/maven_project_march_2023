package com.testology;


import org.openqa.selenium.WebDriver;


import org.openqa.selenium.edge.EdgeDriver;


public class FirstTest {


    public static void main(String agrs[]) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\NiksuP\\Documents\\tutorials\\maven_project_march_2023\\src\\test\\resources\\drivers\\chromedriver.exe");
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");*/

//        WebDriver driver = new ChromeDriver(options);// creating a new instance of chrome driver// starting browser
//WebDriver driver = new FirefoxDriver();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();// Maximize the window size
        driver.get("https://www.google.co.in");// loading the webpage in the browser
        //wait for 10 seconds to load the page successfully
        String title = driver.getTitle();// getting the page title google
        System.out.println("printing title");
        System.out.println(title);
        driver.quit();// close the browser
    }

}