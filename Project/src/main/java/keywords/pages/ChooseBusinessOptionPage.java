package keywords.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChooseBusinessOptionPage extends CommonPage{
    WebDriver driver;
    public ChooseBusinessOptionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnContinueByOption(String inputOption) {
        String xpathContinue = "//div[span[contains(text() , \"" + inputOption +
                "\")]]/following-sibling::button//span[text() = \"Continue\"]";
        WebElement btnContinue = locator.getObjByXpath(driver, xpathContinue);
        action.click(btnContinue);
    }

    public void clickOnGetStartedByOption(String inputOption) {
        String xpathGetStarted = "//div[contains(text() , \"" + inputOption +
                "\")]/following-sibling::button//span[text() = \"Get Started\"]";
        WebElement btnGetStarted = locator.getObjByXpath(driver, xpathGetStarted);
        action.click(btnGetStarted);
    }
}
