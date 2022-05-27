package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Tekrar extends TestBase {

    @Test
    public void test01() {
        // 1- https://demoqa.com/droppable adresine gidelim
        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        driver.get("https://demoqa.com/droppable");
        Actions actions=new Actions(driver);

        WebElement dragMeElementi=driver.findElement(By.xpath("//*[text()='Drag me']"));
        WebElement dropHereElementi=driver.findElement(By.xpath("//*[text()='Drop here']"));
        actions.dragAndDrop(dragMeElementi,dropHereElementi).perform();
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String ExceptedYazi="Dropped!";
        String ActualYazi=sonucYazisi.getText();
        Assert.assertEquals(ExceptedYazi,ActualYazi);





    }
}
