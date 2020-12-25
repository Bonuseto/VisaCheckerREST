package com.staxrt.tutorial.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;



public class Selenium {
    static String result;

    WebElement applicationNum;
    public static String check(String applicationNumImport, String xxFieldImport, String applicationTypeImport, String yearImport ){
        // declaration and instantiation of objects/variables
        //System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://frs.gov.cz/en/ioff/application-status";
        String expectedTitle = "Status of your application | Foreigners reservation system";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        WebElement applicationNum = driver.findElement(By.id("edit-ioff-application-number"));
        WebElement xxField = driver.findElement(By.id("edit-ioff-application-number-fake"));
        Select type = new Select(driver.findElement(By.id("edit-ioff-application-code")));
        Select year = new Select(driver.findElement(By.id("edit-ioff-application-year")));
        WebElement applyButton = driver.findElement(By.id("edit-submit-button"));


        applicationNum.sendKeys(applicationNumImport);
        xxField.sendKeys(xxFieldImport);
        type.selectByVisibleText(applicationTypeImport);
        year.selectByVisibleText(yearImport);
        applyButton.click();

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            WebElement webElementNegative = driver.findElement(By.xpath("//*[text()='Decided – REJECTED']"));
            result = "Decided – REJECTED";
        }
        catch (Exception e){

        }
        try {
            WebElement webElementPositive = driver.findElement(By.xpath("//*[text()='Decided – APPROVED']"));
            result = "Decided – APPROVED";
        }
        catch (Exception e){
        }
        try {
            WebElement webElementPositive = driver.findElement(By.xpath("//*[text()='In Process']"));
            result = "In Process";
        }
        catch (Exception e){
        }


        // get the actual value of the title
        actualTitle = driver.getTitle();
      //  String result = (webElement.getText());

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
            System.out.println(result);
        } else {
            System.out.println("Test Failed");
            System.out.println(result);
        }

        //close Fire fox
        driver.close();
        return result;
    }
}
