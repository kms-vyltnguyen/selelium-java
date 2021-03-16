package keywords.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.RandomizeValue;

import java.security.Key;

public class PersonalPage extends CommonPage {
    WebDriver driver;

    public PersonalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Initial Actions for Page

    public void verifyRegisterPageDisplay(int timeout) {
        verifyPageTitle("Let's get started | Aspire");
    }

//    public WebElement getTxtByLabel(WebDriver driver, String inputLabel) {
//        String xpath = "//div[@label = \"" + inputLabel + "\"]//input";
//        System.out.println(xpath);
//        return locator.getObjByXpath(driver, xpath);
//    }

    public void setTextToFullName(String inputName) throws InterruptedException {
        action.setText(getTxtByLabel(driver, "Full Name as per ID"), inputName);
    }

    public void setTextToEmail(String inputEmail) throws InterruptedException {
        action.setText(getTxtByLabel(driver, "Email address"), inputEmail);
    }

    public void setTextToMobileNumber(String inputCountry, String inputNumber) throws InterruptedException {
        String xpathCountryIcon = "//div[@label = \"Mobile number\"]//label[1]//div[@class=\"q-img__content absolute-full\"]";
        WebElement btnCountryIcon = locator.getObjByXpath(driver, xpathCountryIcon);
        action.click(btnCountryIcon);

        WebElement btnCountryItem = locator.getObjByLabel(driver, inputCountry);
        action.click(btnCountryItem);

        inputNumber = RandomizeValue.randomPhoneNumber(inputNumber);
        action.setText(getTxtByLabel(driver, "Mobile number"), inputNumber);
    }

    public void selectRole(String inputRole) throws InterruptedException {
        String xpathRole = "//div[text() = \"" + inputRole + "\"]/preceding-sibling::div";
        WebElement btnRole = locator.getObjByXpath(driver, xpathRole);

        action.click(btnRole);
    }

    public void selectHearLocation(String inputHearLocation) {
        WebElement btnHearLocation = locator.getTxtByPlaceHolder(driver, "Select any of the following");
        action.click(btnHearLocation);

        WebElement optionItem = locator.getObjByLabel(driver, inputHearLocation);
        action.click(optionItem);
    }

    public void checkTermsAndConditions(int timeout) {
        String xpathChk = "//*[@class=\"q-checkbox__bg absolute\"]";
        WebElement chkTermsAndConditions = locator.getObjByXpath(driver, xpathChk);

        action.click(chkTermsAndConditions);
        action.sleep(timeout);
    }

    public void verifySetTextPersonalInfoSuccessfully(int timeOut) throws InterruptedException {
        WebElement lblEnterEmailOtp = locator.getObjByContainsLabel(driver, "Enter email OTP");
        validation.verifyElementDisplay(lblEnterEmailOtp, timeOut);
    }

    public void setTextToIDNumber(String inputIDNumber) throws InterruptedException {
        action.setText(getTxtByLabel(driver, "Identity Card Number"), inputIDNumber);
    }

    public void setTextToDOB(String inputDOB) throws InterruptedException {
        WebElement element = getTxtByLabel(driver, "Date of Birth");
        element.click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='March'])[1]/following::span[10]")).click();
        action.sleep(2);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='—'])[2]/following::i[1]")).click();
        action.sleep(2);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='—'])[2]/following::i[1]")).click();
        action.sleep(2);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='—'])[2]/following::span[67]")).click();
        action.sleep(2);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sat'])[1]/following::span[60]")).click();
    }

    public void selectNationality(String inputNationality) {
        WebElement btnNationality = locator.getTxtByPlaceHolder(driver, "Select any of the following");
        action.click(btnNationality);

        WebElement optionItem = locator.getObjByLabel(driver, inputNationality);
        action.click(optionItem);
    }

    public void selectGender(String inputGender) {
        WebElement btnGender = locator.getTxtByPlaceHolder(driver, "Set your gender");
        action.click(btnGender);

        WebElement optionItem = locator.getObjByLabel(driver, inputGender);
        action.click(optionItem);
    }

    public void selectInterestedProduct(String inputInterestedProduct) {
        WebElement btnInterestedProduct = locator.getObjByXpath(driver, "(//div[@placeholder = \"Select your purpose of using Aspire\"])[last()]");
        action.click(btnInterestedProduct);

        WebElement optionItem = locator.getObjByLabel(driver, inputInterestedProduct);
        action.click(optionItem);
    }
}
