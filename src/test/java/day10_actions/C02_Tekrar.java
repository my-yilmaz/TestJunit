package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Tekrar extends TestBase {
    // amazon anasayfa'ya gidip
    // account menusunden create a list linkine tiklayalim

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        Actions actions=new Actions(driver);

        WebElement accountLinki=driver.findElement(By.xpath("//*[text()='Hello, Sign in']"));
        actions.moveToElement(accountLinki).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        Thread.sleep(5000);
    }
}
