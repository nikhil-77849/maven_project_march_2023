package in.techlift;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import in.techlift.pages.LoginPage;


import in.techlift.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

		import org.testng.annotations.BeforeMethod;

		import org.testng.annotations.Test;

		import org.testng.annotations.DataProvider;

	public class DataProviderWithExcel_001 {


		private static WebDriver chromeDriver;
		private LoginPage loginPage;


		@BeforeMethod
		void setup()
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--ignore-certificate-errors");
			chromeDriver = new ChromeDriver(options);
			chromeDriver.manage().window().maximize();
			chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			loginPage = new LoginPage(chromeDriver);


			chromeDriver.get("https://test.techlift.in/login#login");

		}

@DataProvider(name = "Authentication")// unique name

  public static Object[][] credentials() {

        // The number of times data is repeated, test will be executed the same no. of times

        // Here it will execute two times

    Object[][] tableData = ExcelUtils.getTableArray(
            "C:\\Users\\NiksuP\\Documents\\tutorials\\maven_project_march_2023\\src\\test\\resources\\test_data\\TestData.xlsx",
            "Sheet1");

return tableData;
}

  // Here we are calling the Data Provider object with its Name

  @Test(dataProvider = "Authentication")

  public void loginTest(String sUsername, String sPassword,String typeOfData) {

      loginPage.emailInputElement.sendKeys(sUsername);
        loginPage.passwordInputElement.sendKeys(sPassword);

      loginPage.loginButtonElement.click();


      if(typeOfData.equals("invalid")) {
          // applying the isDisplayed assertion for red indicator on entering invalid credentials
          Assert.assertTrue(loginPage.redIndicator.isDisplayed());
      }

      // inform the webDriver to wait the page to load with max time out 10 secs
      if(typeOfData.equals("valid")) {
          WebDriverWait explicitWait = new WebDriverWait(chromeDriver,Duration.ofSeconds(5));
          explicitWait.until(ExpectedConditions.titleIs("Home"));
          // applying the assertion on title of page is changed to Home when valid creds are entered
          Assert.assertTrue(chromeDriver.getTitle().equals("Home"));
      }


      try {
          Thread.sleep(3000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }

  @AfterMethod
    void terminateDriver()
  {
      chromeDriver.quit();
  }



}