package in.techlift;

import in.techlift.pages.HomePage;
import in.techlift.pages.LoginPage;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class HomePageBrowserStackTests {

    public static final String OS="mac";
    public static final String AUTOMATE_USERNAME = System.getenv("BROWSERSTACK_USERNAME") != null ? System.getenv("BROWSERSTACK_USERNAME") : "BROWSERSTACK_USERNAME";
    public static final String AUTOMATE_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY") != null ? System.getenv("BROWSERSTACK_ACCESS_KEY") : "BROWSERSTACK_ACCESS_KEY";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";


    LoginPage loginPage;
    HomePage homePage;
    WebDriver chromeDriver;

    @BeforeTest
    void setup()
    {
        //ChromeOptions options = new ChromeOptions();
       // options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--ignore-certificate-errors");
        DesiredCapabilities capabilities;
        if(OS=="windows") {
             capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("browserVersion", "latest");
            //capabilities.setCapability("browserstack.local", "true");
            capabilities.setCapability("project", "Testology Project");
            capabilities.setCapability("build", "testology_build_1");
            capabilities.setCapability("browserstack.networkLogs", "true");
            capabilities.setCapability("name", "Home page must have a title");

            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("os", "Windows");
            browserstackOptions.put("osVersion", "10");

            browserstackOptions.put("acceptInsecureCerts", "true");
            capabilities.setCapability("bstack:options", browserstackOptions);
            capabilities.setCapability("resolution", "1024x768");

        }
        else
        {
             capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Safari");
            capabilities.setCapability("project", "Testology Project");
            capabilities.setCapability("build", "testology_build_1");

            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("os", "OS X");
            browserstackOptions.put("osVersion", "High Sierra");
            browserstackOptions.put("browserVersion", "11.0");
            browserstackOptions.put("resolution", "1024x768");
            browserstackOptions.put("local", "false");
            browserstackOptions.put("seleniumVersion", "4.8.0");
            capabilities.setCapability("bstack:options", browserstackOptions);
        }


// You can also set an environment variable - "BROWSERSTACK_ACCESS_KEY".

        try {
            chromeDriver = new RemoteWebDriver(new URL(URL) ,capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        chromeDriver.manage().window().maximize();
        loginPage = new LoginPage(chromeDriver);
        homePage = new HomePage(chromeDriver);

    }

    @Test
    void verifyUserIsAbleToNavigateToLoginPageAndLogin()
    {
        chromeDriver.get("https://test.techlift.in");

        WebDriverWait explicitWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(homePage.loginLink));
    chromeDriver.findElement(homePage.loginLink).click();

explicitWait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.emailInput));

        chromeDriver.findElement(loginPage.emailInput).sendKeys("testology.qa.learning@gmail.com");
chromeDriver.findElement(loginPage.passwordInput).sendKeys("Testology@123");
chromeDriver.findElement(loginPage.loginButton).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    void terminateDriver()
    {
        chromeDriver.quit();
    }


}
