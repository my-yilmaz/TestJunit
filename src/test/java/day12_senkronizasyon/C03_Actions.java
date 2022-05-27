package day12_senkronizasyon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;


public class C03_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // 1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOverMeFirstElmenti = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverOverMeFirstElmenti).perform();

        // 3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();

        // 4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        // 5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6. "Click and hold" kutusuna basili tutun
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement clickAndHoldElementi = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@id='click-box']")));
        actions.clickAndHold(clickAndHoldElementi).perform();

        // 7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldElementi.getText());

        // 8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMe = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(doubleClickMe).perform();
    }
}
