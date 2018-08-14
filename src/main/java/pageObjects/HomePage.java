package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

        //header objects

        WebElement header = driver.findElement(By.id("header-bar"));

        By logo = By.xpath("img[@class='banner']");
        By selectCountry = By.xpath("a[@id='header-toggle-pos']");
        By selectCurrency = By.id("header-toggle-currency");
        By phoneNumber = By.className("widget-tooltip-delay");

       //menu bar objects

        WebElement menuBar = driver.findElement(By.id("menu-bar"));

        By hotDeals = By.id("hdr-deals");
        By packages = By.id("hdr-packages");
        By groups = By.id("hdr-groups");
        By giftCards = By.id("hdr-gift-card");
        By propertyList = By.id("hdr-add-hotel");
        By help = By.id("hdr-help");
        By signIn_account = By.id("hdr-account");
        By rewards = By.id("hdr-rewards");
        By yourBooking = By.id("hdr-customer-bookings");


        //otherPageObjects

        //footer


        public WebElement getLogo(){
            return header.findElement(logo);
        }

        public WebElement getSelectCountry() {
            return header.findElement(selectCountry);
        }

        public WebElement getSelectCurrency(){
            return header.findElement(selectCurrency);
        }

        public WebElement getPhoneNumber(){
            return header.findElement(phoneNumber);
        }


        public WebElement getHotDeals(){
            return menuBar.findElement(hotDeals);
        }

        public WebElement getPackages(){
            return menuBar.findElement(packages);
        }

        public WebElement getGroups(){
            return menuBar.findElement(groups);
        }

        public WebElement getGiftCards(){
            return  menuBar.findElement(giftCards);
        }

        public WebElement getPropertyList(){
            return menuBar.findElement(propertyList);
        }

        public WebElement getHelp(){
            return menuBar.findElement(help);
        }

        public WebElement getSignInAccount(){
            return  menuBar.findElement(signIn_account);
        }

        public WebElement getRewards(){
            return menuBar.findElement(rewards);
        }
        public  WebElement getYourBooking(){
            return  menuBar.findElement(yourBooking);
        }







}
