import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class DemoTest {


    @Test
    void firstTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("");
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));


    }


    /*@Test
    void secondTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("");
        List<WebElement> elementList = driver.findElements(By.xpath("//a"));
        for (WebElement link : elementList)
        {
            given.baseUrl(link).get();
        }

        List<WebElement> rowsElement = driver
                .findElements(By.xpath("//table[contain(@class,'']]//tr"));
        for (WebElement row :rowsElement) {
            List<WebElement>  columnsList = driver
                    .findElements(By.xpath("//td"));
        }
    }*/

    @Test
    public void secondTest() {
        // smallest and largest word

        String str = "The grass is green";
        Map<Integer, String> mapOfStrs = new HashMap<>();
        Set<Integer> setOfLengths = new HashSet<>();
        String[] strs = str.split(" ");
        Arrays.sort(strs);
        System.out.println(strs);
/*
        for(String string : strs)
        {
            mapOfStrs.put(string.length(),string  );
            setOfLengths.add(string.length());
        }
      int smallestLength= (Integer) setOfLengths.toArray()[0];
        int biggestLength=  (Integer)setOfLengths.toArray()[strs.length-1];

        System.out.println(mapOfStrs.get(smallestLength));
        System.out.println(mapOfStrs.get(biggestLength));


*/
    }

}
