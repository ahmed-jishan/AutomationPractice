package org.example.webElementCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class IsDisplayedMethod {

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
        Thread.sleep( 4000);

        WebElement element = driver.findElement(By.xpath ("//input[@placeholder='First Name']"));//2nd method: //form[@id = 'practiceForm']/div[1]/div/input

        try {
            if (element.isDisplayed()) {
                System.out.println(element.getCssValue("color"));
                Thread.sleep(8000);
            }
        }
        catch (Exception e){
            System.out.println("Element is not Displayed");
        }
    }

    @AfterSuite
    public void closeChromeBrowser(){

        driver.close();
    }
}
