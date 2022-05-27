package day09_handleWindows_testBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_Tekrar extends TestBase {
    // 1- amazon ana sayfaya gidin
    // 2- nutella icin arama yaptirin
    // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
    // 4- yeni tab'da acilan urunun title'ini yazdirin
    // 5- ilk sayfaya gecip url'i yazdiralim

    @Test
    public void Test01(){
        driver.get("https://www.amazon.com");
        String ilkSHD=driver.getWindowHandle();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        WebElement imgTitleElmenti=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(imgTitleElmenti.getText());
        driver.switchTo().window(ilkSHD);
        System.out.println(driver.getCurrentUrl());

    }
}
