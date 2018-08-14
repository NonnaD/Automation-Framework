package pageObjects;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightOnlyPage {

    public WebDriver driver;

    public FlightOnlyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@id='tab-flight-tab-hp']")
    WebElement flightOnlyButton;

    @FindBy(id = "flight-type-roundtrip-label-hp-flight")
    WebElement roundTrip;

    @FindBy(xpath = "//input[@id='flight-origin-hp-flight']")
    WebElement flyingFrom;

    @FindBy(xpath = "//input[@id='flight-destination-hp-flight']")
    WebElement flyingTo;

    @FindBy(id = "flight-departing-single-hp-flight")
    WebElement departing;

    @FindBy(id = "flight-departing-hp-flight")
    WebElement departingRound;

    @FindBy(xpath = "//input[@id='flight-returning-hp-flight']")
    WebElement returning;

    @FindBy(xpath = "//select[@id='flight-adults-hp-flight']")
    WebElement adults;

    @FindBy(xpath = "//select[@id='flight-children-hp-flight']")
    WebElement children;

    @FindBy(xpath = "//a[@id='flight-advanced-options-hp-flight']")
    WebElement advancedOption1;

    @FindBy(xpath = "//input[@id='advanced-flight-nonstop-hp-flight']")
    WebElement nonstop;

    @FindBy(id = "advanced-flight-refundable-hp-flight")
    WebElement refund;

    @FindBy(id = "flight-advanced-preferred-airline-hp-flight")
    WebElement airlinePreference;

    @FindBy(id = "flight-advanced-preferred-class-hp-flight" )
    WebElement preferdClass;

    @FindBy(className = "gcw-submit")
    WebElement search;

    @FindBy(id = "flight-type-one-way-label-hp-flight")
    WebElement oneWay;

    @FindBy(id = "flight-type-multi-dest-label-hp-flight")
    WebElement multiCity;

    @FindBy(id = "flight-2-origin-hp-flight")
    WebElement flyingFrom2;

    @FindBy(id="flight-2-destination-hp-flight")
    WebElement flyingTo2;

    @FindBy(id="flight-2-departing-hp-flight")
    WebElement departing2;

    @FindBy(className = "datepicker-cal-month-header")
    WebElement monthPath1;

    @FindBy(className = "datepicker-next")
    WebElement dateNextButton1;

    @FindBy(id = "flight-age-select-1-hp-flight")
    WebElement child1Age;

    @FindBy(id = "hdr-packages")
    WebElement packages;

    String dayPath1 = "datepicker-day-number";

    @FindBy(className = "title-city-text")
    List<WebElement> titleCityText;



    public WebElement getChild1Age(){ return  child1Age;}
    public WebElement getFlightOnlyButton(){ return flightOnlyButton; }
    public WebElement getFlyingFrom(){ return flyingFrom;}
    public WebElement getRoundTrip(){ return roundTrip; }
    public WebElement getDeparting(){ return departing; }
    public WebElement getDepartingRound(){ return departingRound;}
    public WebElement getFlyingTo(){ return flyingTo;}
    public WebElement getReturning(){ return returning; }
    public WebElement getAdults(){ return adults; }
    public WebElement getChildren(){ return children; }
    public WebElement getAdvancedOption1(){ return advancedOption1;}
    public WebElement getNonstop(){ return nonstop; }
    public WebElement getRefund(){ return  refund; }
    public WebElement getAirlinePreference(){ return airlinePreference; }
    public WebElement getPreferdClass(){ return preferdClass;}
    public WebElement getSearch(){ return search;}
    public WebElement getOneWay(){ return oneWay;}
    public WebElement getMultiCity(){ return multiCity;}
    public WebElement getFlyingFrom2(){ return flyingFrom2; }
    public WebElement getFlyingTo2(){ return flyingTo2; }
    public WebElement getDeparting2(){ return departing2; }
    public WebElement getMonthPath(){ return monthPath1; }
    public String getDayPath(){ return dayPath1; }
    public WebElement getDateNextButton(){ return dateNextButton1;}
    public WebElement getPackages(){ return packages;}
    public List<WebElement> getTitleCityText(){ return titleCityText;}





}
