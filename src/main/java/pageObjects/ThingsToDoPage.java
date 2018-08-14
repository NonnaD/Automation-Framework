package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ThingsToDoPage {
    public WebDriver driver;

    public ThingsToDoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }



    @FindBy(id = "tab-activity-tab-hp")
    WebElement thingsToDo;

    @FindBy(id = "activity-destination-hp-activity")
    WebElement destination;

    @FindBy(id = "activity-start-hp-activity")
    WebElement from;

    @FindBy(id = "activity-start-hp-activity")
    List<WebElement> listFrom;

    @FindBy(id = "activity-end-hp-activity")
    WebElement to;

    @FindBy(xpath = "//*[@id='gcw-activities-form-hp-activity']/div[5]/label/button")
    WebElement search;

    @FindBy(className = "datepicker-cal-month-header")
    WebElement monthPath1;

    @FindBy(className = "datepicker-next")
    WebElement dateNextButton1;

    @FindBy(id = "flight-age-select-1-hp-flight")
    WebElement child1Age;

    @FindBy(id = "hdr-packages")
    WebElement packages;

    @FindBy(id = "titleHeading")
    List<WebElement> validateMes;


    String dayPath1 = "datepicker-day-number";



    public WebElement getThingsToDo(){ return thingsToDo;}
    public WebElement getDestination(){ return  destination;}
    public WebElement getFrom(){ return  from;}
    public WebElement getTo(){ return to; }
    public WebElement getSearchButton(){ return search;}
    public WebElement getMonthPath1(){ return monthPath1;}
    public WebElement getDateNextButton1(){ return dateNextButton1;}
    public WebElement getChild1Age(){ return child1Age;}
    public WebElement getPackages(){ return packages;}
    public String getDayPath1(){ return dayPath1;}
    public List<WebElement> getValidateMes(){ return validateMes;}
    public List<WebElement> getListFrom(){ return listFrom;}




}
