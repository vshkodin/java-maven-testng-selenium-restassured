package src.pages.BaseDriver;

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



        public BaseDriver() {
            System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
            //driver.manage().window().maximize();
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
            Assert.assertEquals(strUrl, expectedUrl);
            }


        public void assertURL(String elem) {
            }


        public void exit() {
            driver.quit();
            }

 }

//
//
//         // Links
//
// 	    String urlLoginPage = baseUrl + "/portal/login";
//
// 	    // values, texts
//
// 	    String textExpectedTitleLoginPage = "Sign in | Upgrade";
// 	    String textExpectedTitleOfferPage = "Affordable Online Personal Loans | Upgrade";
//
//         // Locators
//         // Locators fields
//
// 	    String fieldEmail = "[name='username']";
// 	    String fieldPassword = "[name='password']";
//
//         // Locators - Dropdowns
// 	    String dropdownLoanPurpose = "select[aria-label='Loan Purpose']";
// 	    String dropdownLoanPurposeOptionCreditCard = "option[value='CREDIT_CARD']";
// 	    // Locators - Buttons
// 	    String buttonCheckYourRateOne = "button[data-auto='CheckYourRate']";
// 	    String buttonCheckYourRateTwo = "[data-auto='submitPersonalInfo']";
// 	    String buttonContinue = "button[data-auto='continuePersonalInfo']";
// 	    String buttonSubmit = "[data-auto='submitPersonalInfo']";
// 	    String buttonMenu = "[class='header-nav']";
// 	    String buttonSignOut = "[href='/funnel/logout']";
// 	    String buttonSignInToYourAccount = "[data-auto='login']";
//
//         // Locators Checkboxes
//         //String checkboxAgreements = "[name='agreements']";
//         String checkboxAgreements = "[data-checked='false'] >div[class^='sc-irKD']";
//
//         // Locators Labels
//         String labelUserLoanAmount = "[data-auto='userLoanAmount']";
//         String labelDefaultLoanInterestRate = "[data-auto='defaultLoanInterestRate']";
//         String labelDefaultLoanTerm = "[data-auto='defaultLoanTerm']";
//         String labelDefaultMonthlyPayment = "[data-auto='defaultMonthlyPayment']";
//         String labelAPR = "[data-auto='defaultAPR']";

        //


        //Driver setup
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.

	    //driver.get(urlApplyPage);



//         // login
//         driver.get(urlLoginPage);
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(fieldEmail)));
//
//         driver.findElement(By.cssSelector(fieldEmail)).sendKeys(textUserEmail);
//         driver.findElement(By.cssSelector(fieldPassword)).sendKeys(textUserPassword);
//         driver.findElement(By.cssSelector(buttonSignInToYourAccount)).click();
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(labelUserLoanAmount)));
//
//
//         // Validate Assertions
//         Assert.assertEquals(driver.getCurrentUrl(), textExpectedUrlOfferPage);
//         Assert.assertEquals(driver.findElement(By.cssSelector(labelUserLoanAmount)).getText(), expectedUserLoanAmount);
//         Assert.assertEquals(driver.findElement(By.cssSelector(labelDefaultMonthlyPayment)).getText(), expectedDefaultMonthlyPayment);
//         Assert.assertEquals(driver.findElement(By.cssSelector(labelDefaultLoanTerm)).getText(), expectedDefaultLoanTerm);
//         Assert.assertEquals(driver.findElement(By.cssSelector(labelDefaultLoanInterestRate)).getText(), expectedDefaultLoanInterestRate);
//         Assert.assertEquals(driver.findElement(By.cssSelector(labelAPR)).getText(), expectedAPR);

