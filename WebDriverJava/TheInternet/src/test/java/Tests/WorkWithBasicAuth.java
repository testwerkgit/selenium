package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class WorkWithBasicAuth {

    private WebDriver driver;

    @Before
    //Start een WebDriver sessie
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "/vendor/geckodriver.exe");
        driver = new FirefoxDriver();
        //Maximaliseer het browservenster
        driver.manage().window().maximize();
    }

    @Test
    //Ga naar de website waar je moet inloggen
    public void workWithBasicAuthTest() {
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        //Firefox stelt een vraag of je wilt inloggen. Klik op "Ja'
        driver.switchTo().alert().accept();
       //Wacht 2000 miliseconden
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    //Controleer of de tekst 'Congratulations!' aanwezig is
        String pageMessage = driver.findElement(By.cssSelector("p")).getText();
        assertThat(pageMessage, containsString("Congratulations!"));
    }

   @After
    //Sluit de Webdriver
    public void tearDown () {
        driver.quit();
    }
}
