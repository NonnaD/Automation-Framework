package positiveTC;

import myPatterns.Base;
import myPatterns.Calendar;
import myPatterns.ExcelDataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ThingsToDoPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ThingsToDo extends Base {
    public static final Logger log = LogManager.getLogger(ThingsToDo.class.getName());
    public static WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @Test
    public void  thingsToDo() throws IOException {
        ThingsToDoPage things = new ThingsToDoPage(driver);
        things.getPackages().click();
        things.getThingsToDo().click();

        ArrayList<String> city = ExcelDataProvider.getExceldata("City", "City1");

        things.getDestination().sendKeys(city.get(2), Keys.ARROW_RIGHT);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //driver.findElement(By.className("close")).click();
        log.info("Entered data in the Destenation field");
        things.getDestination().sendKeys(Keys.TAB);

        Calendar date = new Calendar();
        things.getFrom().click();
        date.Calendar(driver, things.getDateNextButton1(), things.getMonthPath1(), "September 2018", things.getDayPath1(), "10");
        things.getTo().click();
        log.info("Entered data in the From field");
        date.Calendar(driver, things.getDateNextButton1(), things.getMonthPath1(), "September 2018", things.getDayPath1(), "11");
        things.getSearchButton().click();
        log.info("Entered data in the TO field");

        Assert.assertTrue(things.getValidateMes().size() > 0);



    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        driver = null;
        log.info("TEST FINISHED");
    }
}
