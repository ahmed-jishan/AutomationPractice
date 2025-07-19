package org.example.CopyPaste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CopyandPaste {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test  //Locate by id.
    public void openURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep( 5000);

        Actions action = new Actions(driver);

        WebElement name= driver.findElement(By.id("name"));
        name.sendKeys("Jishan Ahmed");
        Thread.sleep(5000);

        //Sellect All script
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();


        //Copy
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        //Tab
//        action.keyDown(Keys.CONTROL);
          //action.sendKeys(Keys.TAB);
//        action.keyUp(Keys.CONTROL);
          //action.build().perform();

        //Paste by click another field
          WebElement mobile = driver.findElement(By.xpath("//label[@for='mobile']"));
          mobile.click();

        //Paste
        action.keyDown(Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        Thread.sleep(6000);
    }

    @AfterSuite
    public void closeChromeBrowser(){

        driver.close();
    }
}

