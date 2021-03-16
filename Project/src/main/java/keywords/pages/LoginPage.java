package keywords.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends CommonPage {
    //Initial Web Element
//    WebElement btnLogin = locator.getObjByLabel("Login");
//    WebElement txtPhoneNumber = locator.getObjByXpath("//input[@name=\"phone\"]");
//    WebElement btnRegister = locator.getObjByXpath("//*[contains(@class,\"login-step-start__register-link\")]");

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Initial Actions for Page
    public void clickOnRegisterButton() {
        Reporter.log("Click Register button");
        WebElement btnRegister = locator.getObjByXpath(driver, "//*[contains(@class,\"login-step-start__register-link\")]");
        action.click(btnRegister);
    }

    public void verifyLoginPageDisplay(int timeout) {
        Reporter.log("Verify Login Page is Login to Aspire | Aspire");
        verifyPageTitle("Login to Aspire | Aspire");
    }
}
