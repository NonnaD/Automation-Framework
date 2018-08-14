package positiveTC;


import listeners.TestListener;
import myPatterns.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.CreateAccountPage;

import java.io.IOException;

@Listeners({TestListener.class})

public class CreateAnAccount extends Base {
    public static Logger log = LogManager.getLogger(CreateAnAccount.class.getName());
    public static WebDriver driver;


    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[1][4];
        data[0][0] = "qatester1905@yahoo.com";
        data[0][1] = "Qatesting123";
        data[0][2] = "Itester";
        data[0][3] = "Testerlastname";
        log.info("Data provider return data");

        return data;
    }

    @Test(dataProvider = "getData")
    public void craeteAccount( String username, String password, String firstName, String lastName){
        CreateAccountPage account1 = new CreateAccountPage(driver);
        account1.getSignInAccount().click();
        account1.getCreateAnAccount().click();
        account1.getUsername().sendKeys(username);
        log.info("Entered data in 'UserName' field");
        account1.getPassword().sendKeys(password);
        log.info("Entered data in 'Password' field");
        account1.getFirstName().sendKeys(firstName);
        log.info("Entered data in 'FirstName' field");
        account1.getLastName().sendKeys(lastName);
        log.info("Entered data in 'LastName' field");
        account1.getSignup().click();


        Assert.assertTrue(account1.getWelcomepage().size() > 0, account1.getErrorMsg().getText());

    }


     @AfterTest
    public  void  tearDown(){
        driver.quit();
        driver= null;
        log.info("TEST FINISHED");

    }
}

