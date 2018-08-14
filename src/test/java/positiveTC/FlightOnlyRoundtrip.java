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

public class FlightOnlyRoundtrip extends Base {
    public static final Logger log = LogManager.getLogger(FlightHotel.class.getName());
    public static WebDriver driver;
    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }


    @Test(groups = {"FlightOnly"})
    public void flightOnlyRoundtrip() throws IOException {
      FlightOnlyPage flightOnlyPage = new FlightOnlyPage(driver);
      flightOnlyPage.getPackages().click();
      flightOnlyPage.getFlightOnlyButton().click();
      flightOnlyPage.getRoundTrip().click();
      log.info("Roundtrip grid is displayed");

      ArrayList<String> city1 = ExcelDataProvider.getExceldata("City", "City1");
      ArrayList<String> city2 = ExcelDataProvider.getExceldata("City", "City2");


            flightOnlyPage.getFlyingFrom().sendKeys(city1.get(1));
        log.info("Entered data in 'FROM' field");
            flightOnlyPage.getFlyingTo().sendKeys(city2.get(1));
            log.info("Entered data in 'TO' field");


         flightOnlyPage.getDepartingRound().click();
         myPatterns.Calendar calendar1 = new myPatterns.Calendar();
         calendar1.Calendar(driver, flightOnlyPage.getDateNextButton(), flightOnlyPage.getMonthPath(), "September 2018", flightOnlyPage.getDayPath(), "15");


         flightOnlyPage.getReturning().click();
         myPatterns.Calendar calendar2 = new myPatterns.Calendar();
         calendar2.Calendar(driver, flightOnlyPage.getDateNextButton(), flightOnlyPage.getMonthPath(), "September 2018", flightOnlyPage.getDayPath(), "25");
         log.info("Date fileds are filed");


         Select selectAdult = new Select(flightOnlyPage.getAdults());
         selectAdult.selectByValue("2");
         log.info("Numbers of adult is selected");
         Select selectChild = new Select(flightOnlyPage.getChildren());
         selectChild.selectByValue("1");
         log.info("Numbers of children is selected");
         Select selectChildAge = new Select(flightOnlyPage.getChild1Age());
         selectChildAge.selectByVisibleText("4");
         log.info("Numbers of childAge is selected");


         flightOnlyPage.getSearch().click();
         Assert.assertTrue(flightOnlyPage.getTitleCityText().size() > 0);



    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        driver = null;
        log.info("TEST FINISHED");

    }



}
