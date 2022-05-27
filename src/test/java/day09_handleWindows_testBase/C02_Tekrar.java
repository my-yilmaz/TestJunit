package day09_handleWindows_testBase;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {

    // 1- amazon anasayfaya gidelim
    // 2- url'in  amazon icerdigini test edelim
    // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
    // 4- title'in Best Buy icerdigini test edelim
    // 5- ilk sayfaya donup sayfada java aratalim
    // 6- arama sonuclarinin Java icerdigini test edelim
    // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
    // 8- logonun gorundugunu test edelim
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        String ilkSHD=driver.getWindowHandle();

        String istenenKelime="amazon";
        String actualKelime=driver.getCurrentUrl();
        Assert.assertTrue(actualKelime.contains(istenenKelime));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSHD=driver.getWindowHandle();

        String expectedKelime="Best Buy";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedKelime));

        driver.switchTo().window(ilkSHD);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        String arananKelime="Java";
        WebElement aramaSonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualKelimeStr=aramaSonucu.getText();
        Assert.assertTrue(actualKelimeStr.contains(arananKelime));
        driver.switchTo().window(ikinciSHD);
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());


    }
}
