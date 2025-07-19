package org.example.assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HardAssertionExaple {

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
        Thread.sleep(8000);
        String expectedTitle = "Selenium Practice - Student Registration Form";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement element = driver.findElement(By.xpath ("//input[@placeholder='First Name']"));//2nd method: //form[@id = 'practiceForm']/div[1]/div/input
        element.sendKeys("Jishan");
        Thread.sleep(8000);
//        element.clear();
//        Thread.sleep(8000);
    }

    @AfterSuite
    public void closeChromeBrowser(){

        driver.close();
    }
}
