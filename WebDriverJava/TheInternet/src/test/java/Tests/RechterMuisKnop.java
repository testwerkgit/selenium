package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RechterMuisKnop {
    WebDriver driver;

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
    public void rightClickTest() throws InterruptedException {
        //Ga naar de website
        driver.get("http://the-internet.herokuapp.com/context_menu");
        //Selecteer 'de vierkant' by id 'hot-spot'
        WebElement menu = driver.findElement(By.id("hot-spot"));
        //Klik met rechtermuisknop in de vierkant, druk vier keer pijltje naar beneden en op enter
        //LET OP!!! Vanaf hier lijkt het niet te werken. Kun jij het oplossen?
        Actions action = new Actions(driver);
        action.contextClick(menu).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        //Selecteer de alert venster en controleer op aanwezigheid tekst 'You selected a context menu'
        Alert alert = driver.switchTo().alert();
        assertThat(alert.getText(), is(equalTo("You selected a context menu")));
    }

   @After
   //SLuit de webdriver
    public void tearDown() throws Exception {
        driver.quit();
    }
}