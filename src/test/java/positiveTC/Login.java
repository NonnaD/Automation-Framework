package positiveTC;


import listeners.TestListener;
import myPatterns.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;

import java.io.IOException;

@Listeners({TestListener.class})

public class Login extends Base {

    public static final Logger log = LogManager.getLogger(Login.class.getName());
    public static WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

    }

    @DataProvider
    public Object[][] dataProvider(){
        // Row stands for how many different data types test should run
        //coloumn stands for how many values per each test
        Object[][] data = new Object[1][2];
        data[0][0] = "qatester1905@yahoo.com";
        data[0][1] = "Qatesting123";

        return data;

    }
    @Test(dataProvider = "dataProvider")
    public void logIn(String email, String password) throws IOException {

        log.info("Page is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getSignInAccount().click();
        log.info("Drop down menu is displayed");
        loginPage.getSignIn().click();
        log.info("Sign In grid is displayed ");
        //Assert.assertTrue(loginPage.getEmail().isDisplayed());
        loginPage.getEmail().sendKeys(email);
        loginPage.getPassword().sendKeys(password);
        loginPage.getSigninButton().click();
        int a = loginPage.getWelcomeMessage().size();
        if(a > 0){
            log.info("Your successfully signed in ");
        }else{
            log.error("Error message");
        }

        Assert.assertTrue(loginPage.getWelcomeMessage().size() > 0);


    }

     @AfterTest
     public  void tearDown(){
        driver.close();
        driver = null;
        log.info("TEST FINISHED");
    }





}
