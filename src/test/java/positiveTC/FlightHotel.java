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
import pageObjects.FlightHotelPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class FlightHotel extends Base {
    public static final Logger log = LogManager.getLogger(FlightHotel.class.getName());
    public static WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @Test
    public void flightHotel() throws IOException {
        FlightHotelPage fhotel = new FlightHotelPage(driver);
        fhotel.getPackages().click();
        fhotel.getFlightHotel().click();
        log.info("Flight an Hotel grid is displayed");

        ArrayList<String> from = ExcelDataProvider.getExceldata("City", "City1");
        ArrayList<String> to = ExcelDataProvider.getExceldata("City", "City2");
        //System.out.println(from.size());

        fhotel.getOrigin().sendKeys(from.get(0));
        log.info("Entered data in 'Origin' field" );
        fhotel.getDestination().sendKeys(to.get(0));
        log.info("Entered data in 'Destination' field" );

        myPatterns.Calendar date = new myPatterns.Calendar();
        fhotel.getDeparting().click();
        date.Calendar(driver, fhotel.getDateNextButton1(), fhotel.getMonthPath1(), "September 2018", fhotel.getDayPath1(), "12");
        fhotel.getReturning().click();
        date.Calendar(driver, fhotel.getDateNextButton1(), fhotel.getMonthPath1(), "September 2018", fhotel.getDayPath1(), "17");
        log.info("Date fields are filed");

        Select room = new Select(fhotel.getRooms());
        room.selectByVisibleText("1");
        log.info("Numbers of adult is selected");
        Select adult = new Select(fhotel.getAdults());
        adult.selectByVisibleText("2");
        log.info("Numbers of children is selected");
        Select child = new Select(fhotel.getChildren());
        child.selectByVisibleText("0");
        log.info("Numbers of childAge is selected");


        //fhotel.getAdvancedOptions().click();
        Select classPriority = new Select(fhotel.getPriotityClass());
        classPriority.selectByVisibleText("Premium economy");
        fhotel.getSearchButton().click();
        log.info("Class priority is selected");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Assert.assertTrue(fhotel.getValidateMes().size() > 0);


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        driver = null;
        log.info("TEST FINISHED");
    }
}
