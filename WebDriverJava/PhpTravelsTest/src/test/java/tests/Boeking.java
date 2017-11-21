package tests;

//Alle benodigde imports
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.support.ui.Select;

public class Boeking {
    private WebDriver driver;

    @Before
    //Start een WebDriver sessie
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "/vendor/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void inloggenEnBoeken() {
        //Open de website
        driver.get("http://www.phptravels.net/login");
        //Selecteer het veld 'username' met cssSelector en vul daar henk.de.boer@hotmail.com in
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("henk.de.boer@hotmail.com");
        //Selecteer het veld 'password' by Name en vul daar de Boer in
        driver.findElement(By.name("password")).sendKeys("henk123");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        //Wacht 3000 milliseconden
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Controleer of de welkomsbericht wordt weergegeven
        assertTrue("Geen naam weergegeven",
                driver.findElement(By.cssSelector(".RTL")).isDisplayed());
        //Zoek de linktekst 'Hotels' en klik daarop
        driver.findElement(By.linkText("Hotels")).click();
        //Wacht 3000 milliseconden
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("5")).click();
        driver.findElement(By.id("Resort")).click();
        driver.findElement(By.id("Night Club")).click();
        driver.findElement(By.id("searchform")).click();

        assertTrue("Geen hotel gevonden",
                driver.findElement(By.linkText("Jumeirah Beach Hotel")).isDisplayed());

        driver.findElement(By.linkText("Jumeirah Beach Hotel")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Select(driver.findElement(By.xpath("(//select[@name='roomscount'])[3]"))).selectByVisibleText("2");
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("2")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("339.90", driver.findElement(By.id("displaytotal")).getText());
        driver.findElement(By.cssSelector("button[name=logged]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//center/button")).click();
        driver.switchTo().alert().accept();
        assertEquals("Reserved", driver.findElement(By.xpath("//center/b")).getText());
        }

    @After
    //Sluit de Webdriver
    public void tearDown () {
        driver.quit();
    }
}
