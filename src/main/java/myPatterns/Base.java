package myPatterns;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public  class Base {


    public static WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        Properties dataProp = new Properties();
       FileInputStream dataPropInput = new FileInputStream("./src/main/resources/data.properties");
        dataProp.load(dataPropInput);
        String browserName = dataProp.getProperty("browser");
        String osName = dataProp.getProperty("os");
        String testTypeName = dataProp.getProperty("testType");



        if (testTypeName.equals("web")) {
            if (osName.equals("mac")) {
                if (browserName.equals("chrome")) {

                    System.setProperty("webdriver.chrome.driver", "web_drivers/mac_drivers/chromedriver");
                    driver = new ChromeDriver();
                    driver.get(dataProp.getProperty("url"));


                } else if (browserName.equals("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "web_drivers/mac_drivers/gecko.driver");
                    driver = new FirefoxDriver();
                    driver.get(dataProp.getProperty("url"));


                } else if (browserName.equals(("opera"))) {
                    System.setProperty("webdriver.opera.driver", "web_drivers/mac_drivers/operadriver");
                    driver = new OperaDriver();
                    driver.get(dataProp.getProperty("url"));
                }


            } else if (osName.equals("win")) {
                System.out.println("win");

                if (browserName.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "web_drivers/win_drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.get(dataProp.getProperty("url"));

                } else if (browserName.equals("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "web_drivers/win_drivers/geckodriver_32.exe");
                    driver = new FirefoxDriver();
                    driver.get(dataProp.getProperty("url"));

                } else if (browserName.equals(("opera"))) {
                    System.setProperty("webdriver.opera.driver", "web_drivers/mac_drivers/operadriver.exe");
                    driver = new OperaDriver();
                    driver.get(dataProp.getProperty("url"));
                }

            }else{
                System.out.println("Unknown system name");
            }

        }else if (testTypeName.equals("mobile")) {


            //drivers for mobile testing


        }else{
            System.out.println("Unknown testTypeName");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver ;



     }


     public void getScreenshot(String screenName) throws IOException {
         File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

      //   FileUtils.copyFile(src, new File("/Users/nonna/Desktop/test_framework/screenshots/" + screenName + ".png"));
     }
}

