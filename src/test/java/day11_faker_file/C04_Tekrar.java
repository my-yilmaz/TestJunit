package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_Tekrar extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        //3. dummy.txt dosyasını indirelim
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='dummy.txt']")).click();
        Thread.sleep(5000);

        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\dummy.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }
}
