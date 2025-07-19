package org.example.scroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SpecificLocator {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test  //Locate by id.
    public void openURL() throws InterruptedException {
        //driver.get("https://www.rokomari.com/book/author/1247/kazi-nazrul-islam");
        driver.get("https://www.rokomari.com/book/8112/serstho-golpo");
        Thread.sleep( 4000);//div[@id='js--categoryIds']

        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        WebElement element = driver.findElement(By.xpath("//div[@id='js--categoryIds']"));
//        jse.executeScript("arguments[0].scrollIntoView()",element);
//        Thread.sleep(2000);
          WebElement element2= driver.findElement(By.xpath("//div[@class='details-btn']/div/div/a[2]"));
          WebElement element3= driver.findElement(By.xpath("//figure[@class='stock-available']"));
          jse.executeScript("arguments[0].scrollIntoView()",element3);
          Thread.sleep(5000);
//        jse.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", element2);
//        Thread.sleep(5000);
//        WebElement element3 = driver.findElement(By.xpath("//label[contains(text(),'গল্প সমগ্র')]"));
//        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", element3);
//        Thread.sleep(2000); // Allow scrolling to complete

        // Click on the desired element
        element2.click();
        Thread.sleep(5000);
//        System.out.println("Successfully clicked on 'গল্প সমগ্র'");
    }

    @AfterSuite
    public void closeChromeBrowser(){

        driver.close();
    }
}
