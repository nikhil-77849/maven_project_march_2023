package in.techlift;

import in.techlift.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTests {

    LoginPage loginPage;
    WebDriver chromeDriver;

    @BeforeTest
    void setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--ignore-certificate-errors");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
        loginPage = new LoginPage(chromeDriver);
        chromeDriver.get("https://test.techlift.in/login#login");
    }

    @Test
    void verifyUserIsAbleToLoginDirectlyFromLoginPage()
    {
        WebDriverWait explicitWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.emailInput));
        loginPage.emailInputElement.sendKeys("testology.qa.learning@gmail.com");
        loginPage.passwordInputElement.sendKeys("Testology@123");
        loginPage.loginButtonElement.click();

        // inform the webDriver to wait the page to load with max time out 10 secs
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // applying the check
        Assert.assertTrue(chromeDriver.getTitle().equals("Home"));

    }



    @AfterTest
    void terminateDriver()
    {
        chromeDriver.quit();
    }
}
