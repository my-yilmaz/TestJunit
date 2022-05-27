package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;
import java.util.logging.LoggingPermission;

public class Q2 {
    /*
    ...Exercise2...
    http://www.bestbuy.com 'a gidin,
    Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    Ayrica Relative Locator kullanarak;
        logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
 */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
    WebDriverManager.chromedriver().setup();

    }
    @Before
    public void testtenOnce(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");
    }
    @After
    public void testtenSonra(){
        driver.close();
    }
    @Test
    public void test1(){
        String expectedKelime="Best";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedKelime));


    }
    @Test
    public void test2(){
        WebElement logoElementi=driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(logoElementi.isDisplayed());


    }
    @Test
    public void test3(){
        WebElement mexicoElementi=driver.findElement(By.xpath("//img[@alt='Mexico']"));
        Assert.assertTrue(mexicoElementi.isDisplayed());
    }
}
