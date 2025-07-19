package org.example.scroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ScrollDown {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test  //Locate by id.
    public void openURL() throws InterruptedException {
        driver.get("https://www.automationpractice.pl/index.php");
        Thread.sleep( 4000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String script = "window.scrollTo(0, document.body.scrollHeight);";
        jse.executeScript(script);
        Thread.sleep(8000);
    }

    @AfterSuite
    public void closeChromeBrowser(){

        driver.close();
    }
}
