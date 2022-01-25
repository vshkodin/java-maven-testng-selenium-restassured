package src.pages.LoginPage;

import src.pages.BaseDriver.BaseDriver;


public class LoginPage extends BaseDriver {

       // values, texts
	   String textExpectedTitleLoginPage = "Sign in | Upgrade";
       // Links
	   String urlLoginPage =  "/portal/login";
	   String textExpectedUrlOfferPage= "/funnel/offer-page";
	   // locators
       String fieldEmail = "[name='username']";
 	   String fieldPassword = "[name='password']";
       // Locators Labels
       String labelUserLoanAmount = "[data-auto='userLoanAmount']";
       String labelDefaultLoanInterestRate = "[data-auto='defaultLoanInterestRate']";
       String labelDefaultLoanTerm = "[data-auto='defaultLoanTerm']";
       String labelDefaultMonthlyPayment = "[data-auto='defaultMonthlyPayment']";
       String labelAPR = "[data-auto='defaultAPR']";
       // Locators Buttons
       String buttonMenu = "[class='header-nav']";
	   String buttonSignOut = "[href='/funnel/logout']";
	   String buttonSignInToYourAccount = "[data-auto='login']";


     public void LoginPage() {
        }

     public void openPage() {
        super.openUrl(urlLoginPage);
        }


     public void exit() {
                 super.exit();
        }

     public void validatePageTitle() {
                 super.assertTitle(textExpectedTitleLoginPage);
            }


     public void validatePageUrl() {
                super.assertCurrentUrl(urlLoginPage);
            }

      public void validatePageUrlAuthUser() {
                super.assertCurrentUrl(textExpectedUrlOfferPage);
             }

     public void logout() {
                super.click(buttonMenu);
                super.click(buttonSignOut);
        }



     public void authUser () {
        super.waitElem(fieldEmail);
        super.sendText(fieldEmail,textUserEmail);
        super.sendText(fieldPassword,textUserPassword);
        super.click(buttonSignInToYourAccount);
        super.waitElem(labelUserLoanAmount);
        }

     public String[] rememberRates() {
        return (super.getRates());
        }

}