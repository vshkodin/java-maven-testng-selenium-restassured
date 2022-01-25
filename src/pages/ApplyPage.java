package src.pages.ApplyPage;

import src.pages.BaseDriver.BaseDriver;


public class ApplyPage extends BaseDriver {

       String urlApplyPage = "/phone/nonDMFunnel";
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
       String textExpectedUrlApplyPage= "/funnel/nonDMFunnel";
       String textExpectedTitleApplyPage = "Upgrade - Personal Loans and Cards";
       String fieldEmail = "[name='username']";
 	   String fieldPassword = "[name='password']";
       //locators
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


     public void ApplyPage() {
        }

     public void openPage() {
        super.openUrl(urlApplyPage);
        }


     public void exit() {
                 super.exit();
        }

     public void validatePageTitle() {
                 super.assertTitle(textExpectedTitleApplyPage);
            }


      public void validatePageUrl() {
                super.assertCurrentUrl(textExpectedUrlApplyPage);
             }


     public void Logout() {
                super.click(buttonMenu);
                super.click(buttonSignOut);
        }

//      public void rememberRates() {
//         // Remember Rates
//         String expectedUserLoanAmount = driver.findElement(By.cssSelector(labelUserLoanAmount)).getText();
//         String expectedDefaultMonthlyPayment = driver.findElement(By.cssSelector(labelDefaultMonthlyPayment)).getText();
//         String expectedDefaultLoanTerm = driver.findElement(By.cssSelector(labelDefaultLoanTerm)).getText();
//         String expectedDefaultLoanInterestRate = driver.findElement(By.cssSelector(labelDefaultLoanInterestRate)).getText();
//         String expectedAPR = driver.findElement(By.cssSelector(labelAPR)).getText();
//         }

     public void applyUser() {
            super.sendText(fieldLoanAmount,valueLoanAmount);
            super.click(dropdownLoanPurpose);
            super.click(dropdownLoanPurposeOptionCreditCard);
            super.click(buttonCheckYourRateOne);
            super.sendText(fieldBorrowerFirstName,textFirstName);
            super.sendText(fieldBorrowerLastName,textLastName);
            super.sendText(fieldBorrowerStreet,textAddress);
            super.sendText(fieldBorrowerCity,textCity);
            super.sendText(fieldBorrowerState,textState);
            super.sendText(fieldBorrowerZipCode,textZip);
            super.sendText(fieldBorrowerDateOfBirth,textDOB);
            super.sendText(fieldBorrowerDateOfBirth,textDOB);
            super.waitElem(buttonContinue);
            super.click(buttonContinue);
            super.sendText(fieldBorrowerIncome,textIncome);
            super.sendText(fieldBorrowerAdditionalIncome,textAdditionalIncome);
            super.waitElem(buttonContinue);
            super.click(buttonContinue);
            super.click(buttonContinue);
            super.sendText(fieldEmail,super.textUserEmail);
            super.sendText(fieldPassword,super.textUserPassword);
            super.waitElem(checkboxAgreements);
            super.click(checkboxAgreements);
            super.waitElem(buttonCheckYourRateTwo);
            super.click(buttonCheckYourRateTwo);
            super.waitElem(labelUserLoanAmount);
        }
}