package org.example.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HeadlessEdgeBrowserInit {

    WebDriver driver;

    @BeforeSuite
    public void startEdgeBrowser(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options =  new EdgeOptions();
        options.addArguments("--headless=new");// to run local server

        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void openURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        //Thread.sleep( 5000);
        System.out.println(driver.getTitle());
    }

    @AfterSuite
    public void closeEdgeBrowser(){
        driver.close();
    }
}
