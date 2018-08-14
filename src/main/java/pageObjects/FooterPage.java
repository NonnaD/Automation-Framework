package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FooterPage {
    public WebDriver driver;

    public FooterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }



    @FindBy(id = "resp-footer")
    WebElement footer;

    @FindBy(className = "section-links")
    WebElement sectionList;

    @FindBy(className = "nav-item-top-dest")
    WebElement topDestinations;

    @FindBy(className = "widget-toggle-btn")
    WebElement topDestinationButton;


    public WebElement getFooter(){ return footer;}
    public WebElement getSectionList(){ return sectionList;}
    public WebElement getTopDestinations(){ return topDestinations; }
    public WebElement getTopDestinationButton(){ return topDestinationButton;}


}
