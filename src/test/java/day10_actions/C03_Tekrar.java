package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Tekrar extends TestBase {
    /*
   1- Yeni bir class olusturalim: MouseActions1
   2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
   3- Cizili alan uzerinde sag click yapalim
   4- Alert’te cikan yazinin “You selected a context menu” oldugunu
   test edelim.
   5- Tamam diyerek alert’i kapatalim
   6- Elemental Selenium linkine tiklayalim
   7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    */
    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WebElement cizgiliAlanaElementi = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(cizgiliAlanaElementi).perform();

        String expectedYazi = "You selected a context menu";
        String actualyazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi, actualyazi);

        driver.switchTo().alert().accept();

        String ilkSHD = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> windowHS = driver.getWindowHandles();
        String ikinciSHD = "";
        for (String each : windowHS
        ) {
            if (!each.equals(ilkSHD)) {
                ikinciSHD = each;
            }
        }
        driver.switchTo().window(ikinciSHD);
        WebElement yaziElementi = driver.findElement(By.tagName("h1"));
        expectedYazi = "Elemental Selenium";
        actualyazi = yaziElementi.getText();
        Assert.assertEquals(expectedYazi, actualyazi);
    }
}
