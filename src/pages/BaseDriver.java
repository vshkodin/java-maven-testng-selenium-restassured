package src.pages.BaseDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;


public class BaseDriver {
        public  String baseUrl = "https://www.credify.tech";
        public  WebDriver driver = new ChromeDriver();
        public  WebDriverWait wait = new WebDriverWait(driver,30);
        public  String textUserEmail = "candidate@upgrade-challenge.com";
	    public  String textUserPassword = "!123TestGoGo";

	    String textExpectedUrlOfferPage= "/funnel/offer-page";
	    String textExpectedUrlLoginPage= "/portal/login";

        // Locators Labels
        String labelUserLoanAmount = "[data-auto='userLoanAmount']";
        String labelDefaultLoanInterestRate = "[data-auto='defaultLoanInterestRate']";
        String labelDefaultLoanTerm = "[data-auto='defaultLoanTerm']";
        String labelDefaultMonthlyPayment = "[data-auto='defaultMonthlyPayment']";
        String labelAPR = "[data-auto='defaultAPR']";


        public BaseDriver() {
            System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }


        public void openUrl(String url) {
            driver.get(baseUrl + url);
            }


        public void sendText(String elem, String text) {
            driver.findElement(By.cssSelector(elem)).sendKeys(text);
            }


        public void click(String elem) {
            driver.findElement(By.cssSelector(elem)).click();
            }


        public void waitElem(String elem) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elem)));
            }


        public void assertTitle(String expectedTitle) {
            //  validate Page Title
            String originalTitle = driver.getTitle();
		    Assert.assertEquals(originalTitle, expectedTitle);

            }


        public void assertCurrentUrl(String expectedUrl) {
            //  validate Page Title
            String strUrl = driver.getCurrentUrl();
            Assert.assertEquals(strUrl, baseUrl + expectedUrl);
            }


        public String[] getRates() {
            String expectedUserLoanAmount = driver.findElement(By.cssSelector(labelUserLoanAmount)).getText();
            String expectedDefaultMonthlyPayment = driver.findElement(By.cssSelector(labelDefaultMonthlyPayment)).getText();
            String expectedDefaultLoanTerm = driver.findElement(By.cssSelector(labelDefaultLoanTerm)).getText();
            String expectedDefaultLoanInterestRate = driver.findElement(By.cssSelector(labelDefaultLoanInterestRate)).getText();
            String expectedAPR = driver.findElement(By.cssSelector(labelAPR)).getText();
            String[] arr = { expectedUserLoanAmount, expectedDefaultMonthlyPayment, expectedDefaultLoanTerm, expectedDefaultLoanInterestRate,expectedAPR };
            return(arr);
            }


        public void exit() {
            driver.quit();
            }
 }
