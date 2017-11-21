package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Checkboxes {
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
    //Ga naar de website met checkboxes
    public void checkboxOption2Test() throws Exception {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        //Vink de tweede checkbox uit (standaard is die uitgevinkt)
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        //Controleer of de checkbox is uitgevinkt
        WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        assertThat(checkbox.isSelected(), is(false));
    }

  @After
  //Sluit de Webdriver
    public void tearDown() throws Exception {
        driver.quit();
    }
}