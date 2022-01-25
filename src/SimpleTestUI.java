package src.SimpleTestUI;
import src.pages.ApplyPage.ApplyPage;
import src.pages.LoginPage.LoginPage;
import org.testng.annotations.*;
import org.testng.Assert;

public class SimpleTestUI {
	 @Test()
	 public void aFastTest() {
            ApplyPage apply = new ApplyPage();
            apply.openPage();
            apply.validatePageTitle();
            apply.validatePageUrl();
            apply.applyUser();
            String[] arr1 = apply.rememberRates();
            apply.logout();
            apply.exit();

           LoginPage login = new LoginPage();
             login.openPage();
             login.validatePageTitle();
             login.validatePageUrl();
             login.authUser();
             String[] arr2 = login.rememberRates();
             login.logout();
             login.exit();

            Assert.assertEquals(arr1, arr2);
            }
}
