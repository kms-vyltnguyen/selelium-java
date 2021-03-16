package keywords.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusinessInfoPage extends CommonPage{
    public BusinessInfoPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setTextToBusinessName(String inputBusinessName) throws InterruptedException {
        action.setText(getTxtByLabel(driver, "Business Name"), inputBusinessName);
    }

    public void setTextToUEN(String inputUEN) throws InterruptedException {
        action.setText(getTxtByLabel(driver, "Business Registration Number (UEN)"), inputUEN);
    }

    public void selectRegistrationType(String inputRegistrationType) {
        WebElement btnRegistrationType= getTxtByLabel(driver, "Registration Type");
        action.click(btnRegistrationType);

        WebElement optionItem = locator.getObjByLabel(driver, inputRegistrationType);
        action.click(optionItem);
    }

    public void selectRegistrationParentType(String inputRegistrationParentType) {
        WebElement btnRegistrationParentType = getTxtByLabel(driver, "Registration Parent Type");
        action.click(btnRegistrationParentType);

        WebElement optionItem = locator.getObjByLabel(driver, inputRegistrationParentType);
        action.click(optionItem);
    }

    public void setTextToBusinessWebsite(String inputBusinessWebsite) throws InterruptedException {
        action.setText(getTxtByLabel(driver, "Business website"), inputBusinessWebsite);
    }

    public void selectIndustry(String inputIndustry) {
        WebElement btnIndustry= getTxtByLabel(driver, "Industry");
        action.click(btnIndustry);

        WebElement optionItem = locator.getObjByLabel(driver, inputIndustry);
        action.click(optionItem);
    }

    public void selectSubIndustry(String inputSubIndustry) {
        WebElement btnSubIndustry = getTxtByLabel(driver, "Sub Industry");
        action.click(btnSubIndustry);

        WebElement optionItem = locator.getObjByLabel(driver, inputSubIndustry);
        action.click(optionItem);
    }

    public void verifyCompletedBusinessInfoSuccessfully(int timeOut) throws InterruptedException {
        String message = "You have successfully completed the KYC processs and we have received your documents.";
        WebElement lblMessage = locator.getObjByContainsLabel(driver, message);
        validation.verifyElementDisplay(lblMessage, timeOut);
    }

    public void verifyWaitingMessage(int timeOut) throws InterruptedException {
        String message = "We have received your KYC documents.";
        WebElement lblMessage = locator.getObjByContainsLabel(driver, message);
        validation.verifyElementDisplay(lblMessage, timeOut);
    }
}
