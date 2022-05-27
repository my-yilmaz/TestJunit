package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class C05_WindowHandle extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        //2."Login Portal" a kadar asagi inin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        //3."Login Portal" a tiklayin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement loginPortalElementi=wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h1[text()='LOGIN PORTAL']")));
        loginPortalElementi.click();
                //driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();


        Set<String> windowHandleSeti = driver.getWindowHandles();
        String ikinciSayfaHandleDegeri = "";
        for (String each : windowHandleSeti
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaHandleDegeri = each;
            }
        }

        //4.Diger window'a gecin
        driver.switchTo().window(ikinciSayfaHandleDegeri);

        //5."username" ve "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//input[@id=\"text\"]"))
                .sendKeys("ifareme");
        action.sendKeys(Keys.TAB)
                .sendKeys("123456").perform();

        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[@id=\"login-button\"]")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedYazi="validation failed";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHandleDegeri);

        //10.Ilk sayfaya donuldugunu test edin
        String expectedUrl="http://webdriveruniversity.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
