package keywords.pages;

import keywords.common.LocatorAction;
import keywords.common.UIAction;
import keywords.common.ValidationAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class CommonPage {
    WebDriver driver;
    public LocatorAction locator = new LocatorAction();
    public UIAction action = new UIAction(driver);
    public ValidationAction validation = new ValidationAction();

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTxtByLabel(WebDriver driver, String inputLabel) {
        String xpath = "//div[@label = \"" + inputLabel + "\"]//input";
        System.out.println(xpath);
        return locator.getObjByXpath(driver, xpath);
    }

    public void verifyPageTitle(String expectedTitle) {
        String currentTitle = driver.getTitle();
        validation.verifyContains(currentTitle, expectedTitle);
    }

    public void clickOnContinue(int timeout) {
        WebElement btnContinue = locator.getObjByLabel(driver, "Continue");
        action.click(btnContinue);
        action.sleep(timeout);
    }

    public void clickOnGetStarted(int timeout) {
        WebElement btnContinue = locator.getObjByLabel(driver, "Get Started");
        action.click(btnContinue);
        action.sleep(timeout);
    }

    public void clickOnSubmit(int timeout) {
        WebElement btnContinue = locator.getObjByLabel(driver, "Submit");
        action.click(btnContinue);
        action.sleep(timeout);
    }

    public void clickOnGetBeginVerification(int timeout) {
        WebElement btnContinue = locator.getObjByLabel(driver, "Begin Verification");
        action.click(btnContinue);
        action.sleep(timeout);
    }
    public void uploadImage(String filePath) {
        File dirFile = new File(filePath);
        WebElement btnImage = locator.getObjByXpath(driver, "(//input[@type = \"file\"])[2]");
        System.out.println("abc: " + dirFile.getAbsolutePath());
        btnImage.sendKeys(dirFile.getAbsolutePath());
    }

}
