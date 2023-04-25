package in.techlift.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    @FindBy(xpath = "//h1")
    WebElement Header;
    @FindBy(xpath = "//*[@id='signupModalButton']")
    WebElement getStarted;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public By exploreLink = By.xpath("//a[contains(text(),'Explore')]");

    public By loginLink = By.xpath("//a[contains(text(),'Login')]");

}
