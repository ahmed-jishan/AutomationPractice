package org.example.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LocateByXpath {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test  //Locate by id.
    public void openURL() throws InterruptedException {
        driver.get("https://www.facebook.com/login.php?skip_api_login=1&api_key=3088986207874317&kid_directed_site=0&app_id=3088986207874317&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Foauth%3Fresponse_type%3Dcode%26client_id%3D3088986207874317%26scope%3Dpublic_profile%2Bemail%26state%3DHoIw4heMYln6GlM7-NblyFimQI_f3KTjptMYklZ_0tE%253D%26redirect_uri%3Dhttps%253A%252F%252Fwww.rokomari.com%252Fauth%252Flogin%252Foauth2%252Fcode%252Ffacebook%26ret%3Dlogin%26fbapp_pres%3D0%26logger_id%3D0d51597d-9375-4836-b26c-d22d333979fa%26tp%3Dunspecified&cancel_url=https%3A%2F%2Fwww.rokomari.com%2Fauth%2Flogin%2Foauth2%2Fcode%2Ffacebook%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%26state%3DHoIw4heMYln6GlM7-NblyFimQI_f3KTjptMYklZ_0tE%253D%23_%3D_&display=page&locale=en_GB&pl_dbl=0");
        Thread.sleep( 4000);

        WebElement element = driver.findElement(By.xpath ("//div[@id='loginform']/div[1]/input"));//2nd method: //form[@id = 'practiceForm']/div[1]/div/input
        element.sendKeys("iamjishanahmed@gmail.com");
        Thread.sleep(5000);
        WebElement elementP= driver.findElement(By.xpath("//div[@id='loginform']/div[2]/input"));
        elementP.sendKeys("##jishan4249");
        Thread.sleep(5000);

        WebElement elementC= driver.findElement(By.xpath("//div[@class='_xkt']/button"));
        elementC.click();
        Thread.sleep(20000);
//        element.clear();
//        Thread.sleep(8000);
    }

    @AfterSuite
    public void closeChromeBrowser(){

        driver.close();
    }
}
