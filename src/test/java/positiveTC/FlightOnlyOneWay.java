package positiveTC;

import myPatterns.Base;
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


public class FlightOnlyOneWay extends Base {
    public static final Logger log = LogManager.getLogger(FlightHotel.class.getName());
    public static WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @Test(groups = {"FlightOnly"})
    public void flightOneWay() throws IOException {

        FlightOnlyPage oneWay = new FlightOnlyPage(driver);
        oneWay.getPackages().click();
        oneWay.getFlightOnlyButton().click();
        oneWay.getOneWay().click();
        log.info("One Way grid is displayed");
        ArrayList<String> city1 = ExcelDataProvider.getExceldata("City", "City1");
        ArrayList<String> city2 = ExcelDataProvider.getExceldata("City", "City2");

        oneWay.getFlyingFrom().sendKeys(city1.get(2));
        log.info("Entered data in 'From' field" );
        oneWay.getFlyingTo().sendKeys(city2.get(2));
        log.info("Entered data in 'To' field" );

        oneWay.getDeparting().click();
        myPatterns.Calendar departingDate = new myPatterns.Calendar();
        departingDate.Calendar(driver, oneWay.getDateNextButton(), oneWay.getMonthPath(), "September 2018", oneWay.getDayPath(), "10");
        log.info("Date field is filed");

        Select adultNumber = new Select(oneWay.getAdults());
        adultNumber.selectByValue("2");
        log.info("Numbers of adult is selected");
        Select childNumber = new Select(oneWay.getChildren());
        childNumber.selectByValue("1");
        log.info("Numbers of children is selected");
        Select childAge = new Select(oneWay.getChild1Age());
        childAge.selectByVisibleText("5");
        log.info("Numbers of childAge is selected");

        oneWay.getAdvancedOption1().click();
        oneWay.getNonstop().click();
        log.info("Non Stop is selected");
        Select selectClass = new Select(oneWay.getPreferdClass());
        selectClass.selectByVisibleText("Premium economy");
        oneWay.getSearch().click();
        log.info("Class priority is selected");
        Assert.assertTrue(oneWay.getTitleCityText().size() > 0);


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        driver = null;
        driver = null;
        log.info("TEST FINISHED");
    }



}
