package positiveTC;

import myPatterns.Base;
import myPatterns.Calendar;
import myPatterns.ExcelDataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.FlightOnlyPage;

import java.io.IOException;
import java.util.ArrayList;

public class FlightOnlyMultiCity extends Base {
    public static final Logger log = LogManager.getLogger(FlightHotel.class.getName());
    public static WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

    }


    @Test(groups = {"FlightOnly"})
    public void multyCity() throws IOException {
        FlightOnlyPage multyCity = new FlightOnlyPage(driver);
        multyCity.getPackages().click();
        multyCity.getFlightOnlyButton().click();
        multyCity.getMultiCity().click();
        log.info("Multy City grid is displayed");

        ArrayList<String> from = ExcelDataProvider.getExceldata("City", "City1");
        ArrayList<String> to = ExcelDataProvider.getExceldata("City", "City2");
        multyCity.getFlyingFrom().sendKeys(from.get(3));
        log.info("Entered data in 'From' field" );
        multyCity.getFlyingTo().sendKeys(to.get(3));
        log.info("Entered data in 'To' field" );

        multyCity.getDeparting().click();
        Calendar calendar1 = new Calendar();
        calendar1.Calendar(driver, multyCity.getDateNextButton(), multyCity.getMonthPath(), "September 2018", multyCity.getDayPath(), "10");
        log.info("Departing date is selected");

        Select adult = new Select(multyCity.getAdults());
        adult.selectByVisibleText("2");
        log.info("Numbers of adult is selected");
        Select child = new Select(multyCity.getChildren());
        child.selectByVisibleText("1");
        log.info("Numbers of children is selected");
        Select childAge = new Select(multyCity.getChild1Age());
        childAge.selectByVisibleText("4");
        log.info("Numbers of childAge is selected");

        multyCity.getFlyingFrom2().sendKeys(from.get(4));
        log.info("Entered data in 'From2' field" );
        multyCity.getFlyingTo2().sendKeys(to.get(4));
        log.info("Entered data in 'To2' field" );

        multyCity.getDeparting2().click();
        calendar1.Calendar(driver, multyCity.getDateNextButton(), multyCity.getMonthPath(), "September 2018", multyCity.getDayPath(), "15");
        log.info("Departing2 date is selected");
        multyCity.getSearch().click();
        Assert.assertTrue(multyCity.getTitleCityText().size() > 0);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        driver = null;
        log.info("TEST FINISHED");

    }
}
