package day13_cookies_webTables;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_Tekrar extends TestBase {

    @Test
    public void test() {
        girisYap();
        //          ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sutunBasliklariListesi.size() = " + sutunBasliklariListesi.size());

        //          ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        //          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satirListesi.size() = " + satirListesi.size());

        //          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement webElement : satirListesi) {
            System.out.println(webElement.getText());
        }
        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> dorduncuSatirList = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement webElement : dorduncuSatirList) {
            System.out.println(webElement.getText());
        }
        //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        List<WebElement> basliklerListesi = driver.findElements(By.xpath("//thead//tr[1]/th"));
        int emailSutunNo = 0;
        for (int i = 0; i < basliklerListesi.size(); i++) {
            if (basliklerListesi.get(i).getText().equals("Email")) {
                emailSutunNo = i;
            }
        }

        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//td[" + (emailSutunNo + 1) + "]"));
        for (WebElement t : emailSutunListesi) {
            System.out.println(t.getText());
        }

    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}
