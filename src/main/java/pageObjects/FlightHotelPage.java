package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightHotelPage {
    public WebDriver driver;

    public FlightHotelPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tab-package-tab-hp")
    WebElement flightHotel;

    @FindBy(id = "package-origin-hp-package")
    WebElement origin;

    @FindBy(id = "package-destination-hp-package" )
    WebElement destination;

    @FindBy(id = "package-departing-hp-package")
    WebElement departing;

    @FindBy(id = "package-returning-hp-package")
    WebElement returning;

    @FindBy(id = "package-rooms-hp-package")
    WebElement rooms;

    @FindBy(id = "package-1-adults-hp-package")
    WebElement adults;

    @FindBy(id = "package-1-children-hp-package")
    WebElement children;

    @FindBy(id = "package-advanced-options-hp-package")
    WebElement advancedOptions;

    @FindBy(id = "package-advanced-preferred-class-hp-package")
    WebElement priotityClass;

    @FindBy(id = "search-button-hp-package")
    WebElement searchButton;

    @FindBy(className = "datepicker-cal-month-header")
    WebElement monthPath1;

    @FindBy(className = "datepicker-next")
    WebElement dateNextButton1;

    @FindBy(id = "flight-age-select-1-hp-flight")
    WebElement child1Age;

    @FindBy(id = "hdr-packages")
    WebElement packages;

    @FindBy(className = "section-header-main")
    List<WebElement> validateMes;



    String dayPath1 = "datepicker-day-number";


    public WebElement getFlightHotel(){ return  flightHotel; }
    public WebElement getOrigin(){ return  origin; }
    public WebElement getDestination(){ return destination;}
    public WebElement getDeparting(){ return departing;}
    public WebElement getReturning(){ return returning;}
    public WebElement getRooms(){ return rooms;}
    public WebElement getAdults(){ return adults;}
    public WebElement getChildren(){ return  children;}
    public WebElement getAdvancedOptions(){ return advancedOptions;}
    public WebElement getPriotityClass(){ return priotityClass;}
    public WebElement getSearchButton(){ return searchButton;}
    public WebElement getMonthPath1(){ return  monthPath1;}
    public WebElement getDateNextButton1(){ return  dateNextButton1;}
    public WebElement getChild1Age(){ return child1Age;}
    public WebElement getPackages(){ return packages;}
    public List<WebElement> getValidateMes(){ return  validateMes;}
    public String getDayPath1(){ return  dayPath1;};








}
