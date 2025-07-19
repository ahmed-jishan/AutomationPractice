package org.example.windowTab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchToTab {

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
    public void switchingTab() throws InterruptedException{

        String parenTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        String childTab = driver.getWindowHandle();
        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(5000);

        driver.switchTo().window(parenTab);
        Thread.sleep(5000);
        driver.switchTo().window(childTab);
        Thread.sleep(5000);

    }

    @AfterSuite
    public void closeChromeBrowser(){
        driver.close();
    }
}
