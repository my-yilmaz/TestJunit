package practise;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Q10_Iframe extends TestBase {
      /*
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
    // web sitesini maximize yapin
    // ikinci emojiye tıklayın
    // tüm ikinci emoji öğelerini tıklayın
    // parent iframe e geri donun
    // formu doldurun,(Formu istediğiniz metinlerle doldurun)
    //  apply button a basin
 */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        WebElement ikinciEmoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        ikinciEmoji.click();
        List<WebElement> emojiler=driver.findElements(By.xpath("//div[@id='nature']"));
        //emojiler.stream().forEach(t->t.click());
        for (WebElement each:emojiler
        ) {
            each.click();
        }
        Thread.sleep(5000);
        driver.switchTo().parentFrame();
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        WebElement formElementi=driver.findElement(By.id("jquery-script-menu"));
        actions.click(formElementi)
                .sendKeys("muhammed yılmaz ilk kısım")
                .sendKeys(Keys.TAB)
                .sendKeys("muhammed yılmaz")
                .sendKeys(Keys.TAB)
                .sendKeys("muhammed yılmaz")
                .sendKeys(Keys.TAB)
                .sendKeys("muhammed yılmaz")
                .sendKeys(Keys.TAB)
                .sendKeys("muhammed yılmaz")
                .sendKeys(Keys.TAB)
                .sendKeys("muhammed yılmaz")
                .sendKeys(Keys.TAB)
                .sendKeys("muhammed yılmaz")
                .sendKeys(Keys.TAB)
                .sendKeys("muhammed yılmaz")
                .sendKeys(Keys.TAB)
                .sendKeys("muhammed yılmaz")
                .sendKeys(Keys.TAB)
                .sendKeys("muhammed yılmaz")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
