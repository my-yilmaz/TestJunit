package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Tekrar {

    //  ● Bir class olusturun: IframeTest
    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //   ● Bir metod olusturun: iframeTest
    //      ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //      ve  konsolda    yazdirin.
    //      ○ Text Box’a “Merhaba Dunya!” yazin.
    //      ○ TextBox’in altinda bulunan “Elemental Selenium”
    //      linkinin textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement titleElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(titleElementi.isEnabled());
        System.out.println(titleElementi.getText());

        WebElement iFrameElemnti = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElemnti);
        WebElement metinKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));
        metinKutusu.clear();
        metinKutusu.sendKeys("Merhaba Dunya");

        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        WebElement seleniumYazisi = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(seleniumYazisi.isDisplayed());
        System.out.println(seleniumYazisi.getText());

    }
}

