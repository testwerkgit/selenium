package tests;

//Alle benodigde imports
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class Login {

    private WebDriver driver;

    @Before
    //Start een WebDriver sessie
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "/vendor/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void inloggen() {
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
    }
    @After
    //Sluit de Webdriver
    public void tearDown () {
        driver.quit();
    }
}
