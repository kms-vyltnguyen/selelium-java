package keywords.common;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import utils.LogUtils;

public class ValidationAction {
    public void verifyElementDisplay(WebElement element, int timeout) throws InterruptedException {
        Thread.sleep(timeout);
        if (!element.isDisplayed()){
            Assert.fail("The element is not displayed");
        } else {
            System.out.println("The element is displayed");
        }
    }

    public void verifyElementEnable(WebElement element, int timeout) throws InterruptedException {
        Thread.sleep(timeout);
        if (!element.isEnabled()){
            Assert.fail("The element is not enabled");
        } else {
            System.out.println("The element is enabled");
        }
    }

    public void verifyElementSelected(WebElement element, int timeout) throws InterruptedException {
        Thread.sleep(timeout);
        if (!element.isSelected()){
            Assert.fail("The element is not selected");
        } else {
            System.out.println("The element is selected");
        }
    }

    public void verifyContains(String actualValue, String expectedValue) {
//        LogUtils.info("Verify " + actualValue + " equal to " + expectedValue);
        Reporter.log("Verify " + actualValue + " equal to " + expectedValue);
        Assert.assertEquals(expectedValue, actualValue);

    }
}
