package src.SimpleTestUI;

//import src.pages.BaseDriver.BaseDriver;
import src.pages.ApplyPage.ApplyPage;
import org.testng.annotations.*;
import org.testng.Assert;

public class SimpleTestUI {
	 @Test()
	 public void aFastTest() {

            //BaseDriver apply = new BaseDriver();
            ApplyPage apply = new ApplyPage();
            apply.openPage();
            apply.validatePageTitle();
            apply.applyUser();
//             apply.rememberRates();
//             apply.logout();
//             apply.exit();
            }
}
