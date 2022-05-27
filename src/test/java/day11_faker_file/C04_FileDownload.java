package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. code.txt dosyasını indirelim
    //4. dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void tast01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='dummy.txt']")).click();
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\dummy.txt";
        Thread.sleep(5000);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
