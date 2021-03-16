package keywords.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmailOTPPage extends CommonPage{
    WebDriver driver;

    public EmailOTPPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void enterEmailOTP(int otpNumber) {
        String xpathOTP = "//div[@id='q-app']/div/div/div/main/div/form/div[3]/div/input";
        WebElement txtNumberOfOtp = locator.getObjByXpath(driver, xpathOTP);
        txtNumberOfOtp.sendKeys(String.valueOf(otpNumber));
    }

    public void verifyInputOTPSuccessfully(int timeOut) throws InterruptedException {
        String messageSuccess = "You have successfully verified your email. You’re on to a great start!";
        WebElement lblSuccessMessage = locator.getObjByContainsLabel(driver, messageSuccess);
        validation.verifyElementDisplay(lblSuccessMessage, timeOut);
    }

    public void verifyNavigateToChooseBusinessOptionSuccessfully(int timeOut) throws InterruptedException {
        String message = "Is your business incorporated in Singapore?";
        WebElement lblMessage = locator.getObjByContainsLabel(driver, message);
        validation.verifyElementDisplay(lblMessage, timeOut);
    }

}
