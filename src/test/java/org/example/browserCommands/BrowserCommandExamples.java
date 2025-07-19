package org.example.browserCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BrowserCommandExamples {

    String url = "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";

        WebDriver driver;

        @BeforeSuite
        public void startChromeBrowser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void getCurrentUrl()throws InterruptedException{
            driver.get(url);
            Thread.sleep( 5000);
            String currentURL = driver.getCurrentUrl();
            System.out.println(currentURL);
            if(url.equals(currentURL))
            {
                System.out.println("Current Url is the same as the mentioned URL");
            }
            else {
                System.out.println("Current Url is not the same as the mentioned URL");
            }

        }

        @Test
        public void getPageSource()throws InterruptedException{
            System.out.println(driver.getPageSource());
            //System.out.println(pageSource);
        }
        @AfterSuite
        public void closeChromeBrowser(){
            driver.quit(); //close method close only the current interface
                           // quite method close full interface in the browser

        }
}
