package src.SimpleTestUI;
import src.pages.BaseDriver.BaseDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class SimpleTestUI {
	 @Test()
	 public void aFastTest() {

            BaseDriver signInPage = new BaseDriver();
            signInPage.auth();
            }
}
