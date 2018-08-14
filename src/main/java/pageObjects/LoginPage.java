package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    By signInAccount = By.id("hdr-account");
    By signIn = By.id("hdr-signin");
    By email = By.id("sign-in-email");
    By password = By.id("sign-in-password");
    By signinButton = By.className("cta");
    By welcomeMessage = By.className("resp-module");





    public WebElement getSignInAccount() {return  driver.findElement(signInAccount);}

    public WebElement getSignIn() {return  driver.findElement(signIn);}

    public WebElement getEmail(){
        return driver.findElement(email);
    }

    public  WebElement getPassword(){
        return  driver.findElement(password);
    }

    public  WebElement getSigninButton(){
        return  driver.findElement(signinButton);
    }

    public List<WebElement> getWelcomeMessage(){ return  driver.findElements(welcomeMessage);}



}
