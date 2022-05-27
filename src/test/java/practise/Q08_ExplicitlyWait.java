package practise;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.sql.DriverManager;
import java.time.Duration;

public class Q08_ExplicitlyWait extends TestBase {


/*
    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //maximize the window
    //click on action dialog button
    //if need use explicitly wait
    //click on the ok button
    //accept the alert message
 */

    @Test
    public void Test() {
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[@id='action']"))).click();
       WebElement yaziElementi=wait.until(ExpectedConditions.
               visibilityOfElementLocated(By.xpath("//div[@class='modal-footer']")));
        Assert.assertTrue(yaziElementi.isDisplayed());
       driver.findElement(By.xpath("//button[@class='btn btn-info btn-sm']")).click();
       driver.switchTo().alert().accept();



    }
}


