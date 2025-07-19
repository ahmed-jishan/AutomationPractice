package org.example.Frames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SwitchToDefault {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/nestedframes.php");
        Thread.sleep(5000);

        driver.switchTo().frame("frame1");
        WebElement element = driver.findElement(By.xpath("//h1[contains(text(),'Selenium - Automation Practice Form')]"));
        //element.click();
        System.out.println(element.getText());
        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        WebElement element1 = driver.findElement(By.xpath("//h1[contains(text(),'Nested Frames')]"));
        System.out.println(element1.getText());
        Thread.sleep(5000);

        driver.switchTo().frame("frame1");
        WebElement element2 = driver.findElement(By.xpath("//h1[contains(text(),'Selenium - Automation Practice Form')]"));
        //element.click();
        System.out.println(element2.getText());
        Thread.sleep(3000);
    }
    @AfterSuite
    public void closeChromeBrowser(){
        driver.close();
    }
}
