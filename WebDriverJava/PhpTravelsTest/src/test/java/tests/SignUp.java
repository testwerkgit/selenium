package tests;

//Alle benodigde imports
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class SignUp {

    private WebDriver driver;

    @Before
    //Start een WebDriver sessie
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "/vendor/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void registreren() {
        //Open de website
        driver.get("http://www.phptravels.net/register");
        //Selecteer het veld 'firstname' met cssSelector en vul daar Henk in
        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Henk");
        //Selecteer het veld 'lastname' by Name en vul daar de Boer in
        driver.findElement(By.name("lastname")).sendKeys("de Boer");
        //Selecteer het veld 'phone' met cssSelector en vul daar 0609060906 in
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys("0609060906");
        //Selecteer het veld 'Email' met Xpath en vul daar jan.de.boer@hotmail.com in
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("henk3.de.boer@hotmail.com");
        //Selecteer het veld 'password' met cssSelector en vul daar henk123 in
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("henk123");
        //Selecteer het veld 'confirmpassword' met cssSelector en vul daar henk123 in
        driver.findElement(By.cssSelector("input[name=confirmpassword]")).sendKeys("henk123");
        //Selecteer de knop 'submit' met cssSelector en klik op de knop
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
        //Klik op de link 'Henk' en daarna op 'Logout' om uit te loggen
        driver.findElement(By.linkText("Henk")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    //Sluit de Webdriver
    public void tearDown () {
        driver.quit();
    }
}