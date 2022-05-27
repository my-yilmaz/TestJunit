package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Tekrar extends TestBase {

    /*
    1.Tests packagenin altina bir class oluşturun : C05_UploadFile
    2.https://the-internet.herokuapp.com/upload adresine gidelim
    3.chooseFile butonuna basalim
    4.Yuklemek istediginiz dosyayi secelim.
    5.Upload butonuna basalim.
    6.“File Uploaded!” textinin goruntulendigini test edelim.
     */

    @Test
    public void Test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\dummy.txt";
        dosyaSecButonu.sendKeys(dosyaYolu);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(5000);
        WebElement yaziElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());

    }
}
