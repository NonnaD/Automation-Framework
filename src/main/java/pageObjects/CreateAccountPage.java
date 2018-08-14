package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateAccountPage {
    public WebDriver driver;

    public CreateAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='sign-up-email']")
    WebElement username;

    @FindBy(xpath = "//*[@id='sign-up-password']")
    WebElement password;

    @FindBy(id = "sign-up-first-name")
    WebElement firstName;

    @FindBy(id = "sign-up-last-name")
    WebElement lastName;

    @FindBy(id = "signup-button")
    WebElement signup;

    @FindBy(id = "hdr-create")
    WebElement createAnAccount;

    @FindBy(id = "hdr-account")
    WebElement signInAccount;

    @FindBy(className = "intro-header")
    List<WebElement> welcomePage;

    @FindBy(className = "msg-error-icon")
    WebElement errorMsg;




    public WebElement getUsername(){
        return username;
    }

    public  WebElement getPassword(){
        return password;
    }

    public  WebElement getFirstName(){
        return firstName;
    }

    public  WebElement getLastName(){
        return lastName;
    }

    public  WebElement getSignup(){
        return signup;
    }

    public  WebElement getSignInAccount(){ return  signInAccount;}

    public WebElement getCreateAnAccount(){ return createAnAccount;}

    public List<WebElement> getWelcomepage() { return welcomePage;}

    public WebElement getErrorMsg(){ return errorMsg;}









}
