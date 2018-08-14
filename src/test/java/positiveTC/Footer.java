package positiveTC;

import myPatterns.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.FooterPage;

import javax.xml.bind.Element;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Footer extends Base {
    public static final Logger log = LogManager.getLogger(Footer.class.getName());
    public  WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

    }

   @Test
    public void footer(){
        //for scrolling page down

       JavascriptExecutor js = (JavascriptExecutor) driver;
       FooterPage fot = new FooterPage(driver);
       final String title = driver.getTitle();
       System.out.println(title);

        js.executeScript("arguments[0].scrollIntoView();", fot.getTopDestinations());
        fot.getTopDestinationButton().click();
        List<WebElement> links = fot.getTopDestinations().findElements(By.tagName("a"));
        //System.out.println(links);

        for(int y = 1; y < links.size(); y++){

            links.get(y).sendKeys(Keys.COMMAND, Keys.ENTER );
            log.info("Link opened -" + links.get(y).getText());

        }

        Set<String> winControl = driver.getWindowHandles();
        Iterator<String> iterator = winControl.iterator();
       
        String parent = iterator.next();


        while (iterator.hasNext() ){
            driver.switchTo().window(iterator.next());
            driver.close();
            driver.switchTo().window(parent);

        }
      
        Assert.assertTrue(driver.getTitle().contains("Hotels.com"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        driver = null;
        log.info("TEST FINISHED");

    }


 }
