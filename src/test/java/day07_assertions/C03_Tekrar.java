package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Tekrar {
    /*
    1. Bir Class olusturalim YanlisEmailTesti
    2. http://automationpractice.com/index.php sayfasina gidelim
    3. Sign in butonuna basalim
    4. Email kutusuna @isareti olmayan bir mail yazip enter’a
       bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("http://automationpractice.com/index.php");
        WebElement signInElementi=driver.findElement(By.xpath("//a[@class='login']"));
        signInElementi.click();
        WebElement emailElementi=driver.findElement(By.xpath("//input[@id='email_create']"));
        emailElementi.sendKeys("aliveli.gmail.com"+ Keys.ENTER);
        WebElement invalid=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(invalid.isDisplayed());



    }
}
