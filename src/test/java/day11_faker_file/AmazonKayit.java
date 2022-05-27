package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AmazonKayit extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //Amazon sitesine gidelim
        driver.get("https://www.amazon.com/");
        //account menusunden "Start here." linkine tiklayalim
        Actions actions = new Actions(driver);
        WebElement accountLinki = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountLinki).perform();
        driver.findElement(By.xpath("(//a[@rel='nofollow'])[2]")).click();
        // isim kutusunu locate edelim ve...
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='customerName']"));

        // geriye kalan alanlari TAB ile dolasiğ Faker classi kullanarak dolduralim.

        Faker faker = new Faker();
        String fakePassword = faker.internet().password();

        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName() + " " + faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(3000);

    }
}
