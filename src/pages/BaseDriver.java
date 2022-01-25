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


 public void  auth() {
        // Links
	    String baseUrl = "https://www.credify.tech";
	    String urlApplyPage = baseUrl + "/phone/nonDMFunnel";
	    String urlLoginPage = baseUrl + "/portal/login";


	    // values, texts
	    String valueLoanAmount = "2000";
	    String textIncome = "120000";
	    String textAdditionalIncome = "5000";
	    String textFirstName = "TestUserFirstName";
	    String textLastName = "TestUserLastName";
	    String textAddress = "Test Street";
	    String textCity = "Beaumont";
	    String textState = "TX";
	    String textZip = "77705";
	    String textDOB = "08/08/1988";
	    String textUserEmail = "candidate@upgrade-challenge.com";
	    String textUserPassword = "!123TestGoGo";

	    String textExpectedUrlOfferPage= "https://www.credify.tech/funnel/offer-page";
	    String textExpectedUrlLoginPage= "https://www.credify.tech/portal/login";
	    String textExpectedUrlApplyPage= "https://www.credify.tech/funnel/nonDMFunnel";

	    String textExpectedTitleApplyPage = "Upgrade - Personal Loans and Cards";
	    String textExpectedTitleLoginPage = "Sign in | Upgrade";
	    String textExpectedTitleOfferPage = "Affordable Online Personal Loans | Upgrade";



        // Locators
        // Locators fields
        String fieldLoanAmount = "[name='desiredAmount']";
	    String fieldBorrowerFirstName = "[name='borrowerFirstName']";
	    String fieldBorrowerLastName = "[name='borrowerLastName']";
	    String fieldBorrowerStreet = "[name='borrowerStreet']";
	    String fieldBorrowerCity = "[name='borrowerCity']";
	    String fieldBorrowerState = "[name='borrowerState']";
	    String fieldBorrowerZipCode = "[name='borrowerZipCode']";
	    String fieldBorrowerDateOfBirth = "[name='borrowerDateOfBirth']";
	    String fieldBorrowerIncome = "[name='borrowerIncome']";
	    String fieldBorrowerAdditionalIncome = "[name='borrowerAdditionalIncome']";
	    String fieldEmail = "[name='username']";
	    String fieldPassword = "[name='password']";

        // Locators - Dropdowns
	    String dropdownLoanPurpose = "select[aria-label='Loan Purpose']";
	    String dropdownLoanPurposeOptionCreditCard = "option[value='CREDIT_CARD']";
	    // Locators - Buttons
	    String buttonCheckYourRateOne = "button[data-auto='CheckYourRate']";
	    String buttonCheckYourRateTwo = "[data-auto='submitPersonalInfo']";
	    String buttonContinue = "button[data-auto='continuePersonalInfo']";
	    String buttonSubmit = "[data-auto='submitPersonalInfo']";
	    String buttonMenu = "[class='header-nav']";
	    String buttonSignOut = "[href='/funnel/logout']";
	    String buttonSignInToYourAccount = "[data-auto='login']";

        // Locators Checkboxes
        //String checkboxAgreements = "[name='agreements']";
        String checkboxAgreements = "[data-checked='false'] >div[class^='sc-irKD']";

        // Locators Labels
        String labelUserLoanAmount = "[data-auto='userLoanAmount']";
        String labelDefaultLoanInterestRate = "[data-auto='defaultLoanInterestRate']";
        String labelDefaultLoanTerm = "[data-auto='defaultLoanTerm']";
        String labelDefaultMonthlyPayment = "[data-auto='defaultMonthlyPayment']";
        String labelAPR = "[data-auto='defaultAPR']";

        //


        //Driver setup
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
	    System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.get(urlApplyPage);

		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, textExpectedTitleApplyPage);

		String strUrl = driver.getCurrentUrl();
		Assert.assertEquals(strUrl, textExpectedUrlApplyPage);
        driver.findElement(By.cssSelector(fieldLoanAmount)).sendKeys(valueLoanAmount);
        driver.findElement(By.cssSelector(dropdownLoanPurpose)).click();
        driver.findElement(By.cssSelector(dropdownLoanPurposeOptionCreditCard)).click();
        //TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector(buttonCheckYourRateOne)).click();

        driver.findElement(By.cssSelector(fieldBorrowerFirstName)).sendKeys(textFirstName);
        driver.findElement(By.cssSelector(fieldBorrowerLastName)).sendKeys(textLastName);
        driver.findElement(By.cssSelector(fieldBorrowerStreet)).sendKeys(textAddress);
        driver.findElement(By.cssSelector(fieldBorrowerCity)).sendKeys(textCity);
        driver.findElement(By.cssSelector(fieldBorrowerState)).sendKeys(textState);
        driver.findElement(By.cssSelector(fieldBorrowerZipCode)).sendKeys(textZip);
        driver.findElement(By.cssSelector(fieldBorrowerDateOfBirth)).sendKeys(textDOB);
        //TimeUnit.SECONDS.sleep(1);

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(buttonContinue)));
        driver.findElement(By.cssSelector(buttonContinue)).click();

        driver.findElement(By.cssSelector(fieldBorrowerIncome)).sendKeys(textIncome);
        driver.findElement(By.cssSelector(fieldBorrowerAdditionalIncome)).sendKeys(textAdditionalIncome);
        //TimeUnit.SECONDS.sleep(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(buttonContinue)));
        driver.findElement(By.cssSelector(buttonContinue)).click();
        driver.findElement(By.cssSelector(buttonContinue)).click();



        driver.findElement(By.cssSelector(fieldEmail)).sendKeys(textUserEmail);
        driver.findElement(By.cssSelector(fieldPassword)).sendKeys(textUserPassword);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(checkboxAgreements)));
        driver.findElement(By.cssSelector(checkboxAgreements)).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(buttonCheckYourRateTwo)));
        driver.findElement(By.cssSelector(buttonCheckYourRateTwo)).click();

        //Remember Rates
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(labelUserLoanAmount)));
        String expectedUserLoanAmount = driver.findElement(By.cssSelector(labelUserLoanAmount)).getText();
        String expectedDefaultMonthlyPayment = driver.findElement(By.cssSelector(labelDefaultMonthlyPayment)).getText();
        String expectedDefaultLoanTerm = driver.findElement(By.cssSelector(labelDefaultLoanTerm)).getText();
        String expectedDefaultLoanInterestRate = driver.findElement(By.cssSelector(labelDefaultLoanInterestRate)).getText();
        String expectedAPR = driver.findElement(By.cssSelector(labelAPR)).getText();

        // Logout
        driver.findElement(By.cssSelector(buttonMenu)).click();
        driver.findElement(By.cssSelector(buttonSignOut)).click();

        // login
        driver.get(urlLoginPage);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(fieldEmail)));

        driver.findElement(By.cssSelector(fieldEmail)).sendKeys(textUserEmail);
        driver.findElement(By.cssSelector(fieldPassword)).sendKeys(textUserPassword);
        driver.findElement(By.cssSelector(buttonSignInToYourAccount)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(labelUserLoanAmount)));


        // Validate Assertions
        Assert.assertEquals(driver.getCurrentUrl(), textExpectedUrlOfferPage);
        Assert.assertEquals(driver.findElement(By.cssSelector(labelUserLoanAmount)).getText(), expectedUserLoanAmount);
        Assert.assertEquals(driver.findElement(By.cssSelector(labelDefaultMonthlyPayment)).getText(), expectedDefaultMonthlyPayment);
        Assert.assertEquals(driver.findElement(By.cssSelector(labelDefaultLoanTerm)).getText(), expectedDefaultLoanTerm);
        Assert.assertEquals(driver.findElement(By.cssSelector(labelDefaultLoanInterestRate)).getText(), expectedDefaultLoanInterestRate);
        Assert.assertEquals(driver.findElement(By.cssSelector(labelAPR)).getText(), expectedAPR);
        // Exit
       driver.quit();
    }
}