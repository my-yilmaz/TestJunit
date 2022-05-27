package day09_handleWindows_testBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_Tekrar extends TestBase {
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
    // “The Internet” olduğunu doğrulayın.

    @Test
    public void Test01(){
        driver.get("https://the-internet.herokuapp.com/windows");


        String expectedText="Opening a new window";
        WebElement textElementi= driver.findElement(By.xpath("//h3"));
        String actualText=textElementi.getText();
        Assert.assertEquals(expectedText,actualText);

        String expectedTitle="The Internet";
        String actualTtile=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTtile);

        String ilkSHD=driver.getWindowHandle();
        System.out.println("ilkSHD = " + ilkSHD);

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandleSeti=driver.getWindowHandles();
        System.out.println("windowHandleSeti = " + windowHandleSeti);
String ikinciSHD="";
        for (String each:windowHandleSeti
             ) {
            if (!each.equals(ilkSHD)){
                ikinciSHD=each;
            }
        }
        driver.switchTo().window(ikinciSHD);

        expectedTitle="New Window";
        actualTtile=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTtile);

        expectedText="New Window";
        WebElement yaziElementi=driver.findElement(By.xpath("//h3"));
        actualText= yaziElementi.getText();

        Assert.assertEquals(expectedText,actualText);
        driver.switchTo().window(ilkSHD);
        expectedTitle="The Internet";
        actualTtile=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTtile);


    }

}
