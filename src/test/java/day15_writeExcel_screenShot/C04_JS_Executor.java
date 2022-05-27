package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {
    @Test
    public void JSExecutorTest() throws InterruptedException {
        driver.get("https://www.amazon.com");
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signElementi=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true);",signElementi);
        Thread.sleep(3000);

        System.out.println(" Elveda JUnit");
    }
}
