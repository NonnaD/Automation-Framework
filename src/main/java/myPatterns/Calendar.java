package myPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import myPatterns.Base;

import java.util.List;

public class Calendar {
    // public WebDriver driver;

    public void Calendar(WebDriver driver, WebElement nextButton1, WebElement monthPath1, String month, String dayPath1, String day) {

        // select month
        while (!monthPath1.getText().equals(month)) {

            nextButton1.click();

        }

        //select day
        int datesize = driver.findElements(By.className(dayPath1)).size();
        //System.out.println(datesize);
        List<WebElement> dayList = driver.findElements(By.className(dayPath1));
        System.out.println(dayList.get(2).getText());
        for (int i = 0; i < dayList.size(); i++) {
            String day1 = driver.findElements(By.className(dayPath1)).get(i).getText();
          //  System.out.println(day1);
            if (day1.contains(day)) {
                driver.findElements(By.className(dayPath1)).get(i).click();
                break;

            }

        }
    }
}
