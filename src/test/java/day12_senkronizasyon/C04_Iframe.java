package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C04_Iframe extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@id=\"frame\"]"));
        driver.switchTo().frame(iframeElementi);
        driver.findElement(By.linkText("Our Products")).click();

        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[@id=\"camera-img\"]")).click();

        //4. Popup mesajini yazdirin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement popupElementi =wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@id=\"myModal\"]")));
        System.out.println(popupElementi.getText());

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[@id=\"nav-title\"])[1]")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
