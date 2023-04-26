package in.techlift;

import in.techlift.pages.HomePage;
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

public class HomePageTests {



    LoginPage loginPage;
    HomePage homePage;
    WebDriver chromeDriver;

    @BeforeTest
    void setup()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--ignore-certificate-errors");
        chromeDriver = new ChromeDriver(options);

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
