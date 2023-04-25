package in.techlift.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // declared web element without chrome driver
@FindBy(xpath = "//input[contains(@id,'login_email')]")
    public WebElement emailInputElement;

    // declared web element without chrome driver
    @FindBy(xpath = "//input[contains(@id,'login_password')]")
    public WebElement passwordInputElement;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElement loginButtonElement;

    @FindBy(xpath = "//span[contains(@class,'indicator red')]")
    public WebElement redIndicator;

    // constructor of login page class
    public LoginPage(WebDriver chromeDriver)
    {
        PageFactory.initElements(chromeDriver,this);
        // here this keyword represents the current object of LoginPage class
        // used to pass the context of class for which the elements need to be initialised
    }


    //locators of web elements
   public By emailInput = By.xpath("//input[contains(@id,'login_email')]");

   public By passwordInput = By.xpath("//input[contains(@id,'login_password')]");

    public By loginButton = By.xpath("//button[contains(text(),'Login')]");

}
