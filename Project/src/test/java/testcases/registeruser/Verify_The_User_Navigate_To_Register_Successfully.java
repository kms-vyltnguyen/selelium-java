package testcases.registeruser;

import keywords.common.UIAction;
import keywords.pages.LoginPage;
import keywords.pages.PersonalPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import profiles.DefaultProfile;

public class Verify_The_User_Navigate_To_Register_Successfully {
    WebDriver driver;
    LoginPage loginPage;
    PersonalPage personalPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        UIAction basePage = new UIAction(driver);
        driver = basePage.setupDriver(browser);
        loginPage = new LoginPage(driver);
        personalPage = new PersonalPage(driver);
    }

    @Test(priority = 0, description = "Verify test case navigates to Register successfully")
    public void test_navigate_to_login_successfully() {
        loginPage.verifyLoginPageDisplay(DefaultProfile.MAX_PAGE_LOAD_TIMEOUT);
    }

    @Test(priority = 0, description = "Verify test case navigates to Register successfully")
    public void test_navigate_to_register_successfully() {
        loginPage.clickOnRegisterButton();
        personalPage.verifyRegisterPageDisplay(DefaultProfile.MAX_PAGE_LOAD_TIMEOUT);
    }

    @AfterMethod
    public void tearDown() {
        loginPage.action.cleanUp();
    }
}
