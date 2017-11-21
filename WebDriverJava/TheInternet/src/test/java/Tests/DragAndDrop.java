package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class DragAndDrop {

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
    //Ga naar de website waar je objecten kan verslepen
    public void workWithBasicAuthTest() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        //Selecteer object 'column-a' by id en stop die in 'From'
        WebElement From = driver.findElement(By.id("column-a"));
        //Selecteer object 'column-b' by id en stop die in 'To'
        WebElement To = driver.findElement(By.id("column-b"));
        //Voer een drag en drop actie uit
        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(From)

                .moveToElement(To)

                .release(To)

                .build();

        dragAndDrop.perform();
    }

   @After
    //Sluit de Webdriver
    public void tearDown () {
        driver.quit();
    }
}