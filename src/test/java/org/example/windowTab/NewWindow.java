package org.example.windowTab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NewWindow {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (priority =0)
    public void openURL() throws InterruptedException {
        driver.get("https://mvnrepository.com/");
        Thread.sleep( 5000);
    }

    @Test (priority = 1)
    public void createnewWindow() throws InterruptedException{
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(5000);
    }

    @AfterSuite
    public void closeChromeBrowser(){
        driver.close();
    }
}
