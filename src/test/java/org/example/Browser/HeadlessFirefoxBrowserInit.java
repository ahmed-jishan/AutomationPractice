package org.example.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HeadlessFirefoxBrowserInit {

    WebDriver driver;

    @BeforeSuite
    public void startFirefoxBrowser(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options =  new FirefoxOptions();
        options.addArguments("--headless=new");// to run local server

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void openURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        //Thread.sleep( 5000);
        System.out.println(driver.getTitle());
    }

    @AfterSuite
    public void closeFirefoxBrowser(){
        driver.close();
    }
}
