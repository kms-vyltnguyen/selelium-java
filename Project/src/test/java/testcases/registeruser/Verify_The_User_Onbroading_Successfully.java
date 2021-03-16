package testcases.registeruser;

import data.ExcelHelper;
import keywords.common.UIAction;
import keywords.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import profiles.DefaultProfile;
import utils.RandomizeValue;

public class Verify_The_User_Onbroading_Successfully {
    WebDriver driver;
    LoginPage loginPage;
    PersonalPage personalPage;
    EmailOTPPage emailOTPPage;
    ChooseBusinessOptionPage chooseBusinessOptionPage;
    BusinessInfoPage businessInfoPage;

    @Parameters({"browser"})
    @Test(priority = 0)
    public void setUp(@Optional("chrome") String browser) {
        UIAction basePage = new UIAction(driver);
        driver = basePage.setupDriver(browser);
        loginPage = new LoginPage(driver);
        personalPage = new PersonalPage(driver);
        emailOTPPage = new EmailOTPPage(driver);
        chooseBusinessOptionPage = new ChooseBusinessOptionPage(driver);
        businessInfoPage = new BusinessInfoPage(driver);
    }

    @Test(priority = 1, description = "Verify the user navigates to Register successfully")
    public void test_navigate_to_register_successfully() {
        loginPage.clickOnRegisterButton();
        personalPage.verifyRegisterPageDisplay(DefaultProfile.MAX_PAGE_LOAD_TIMEOUT);
    }

    @Test(priority = 2, dataProvider="test1data", description = "Verify the user inputs personal information successfully")
    public void test_input_personal_information(String inputFullName, String inputEmailAddress,
                                                String inputCountry, String inputPhoneNumber,
                                                String inputRoleType, String inputHearLocation) throws InterruptedException {
        personalPage.setTextToFullName(RandomizeValue.randomValue(inputFullName));
        personalPage.setTextToEmail(RandomizeValue.randomMail(inputEmailAddress));
        personalPage.setTextToMobileNumber(inputCountry, inputPhoneNumber);
        personalPage.selectRole(inputRoleType);
        personalPage.selectHearLocation(inputHearLocation);
        personalPage.checkTermsAndConditions(DefaultProfile.WAIT_PRESENT_TIMEOUT);
        personalPage.clickOnContinue(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
        personalPage.verifySetTextPersonalInfoSuccessfully(DefaultProfile.MAX_PAGE_LOAD_TIMEOUT);
    }

    @Test(priority = 3, description = "Verify the user inputs 4-digit OTP sent to email successfully")
    public void test_input_email_otp() throws InterruptedException {
        emailOTPPage.enterEmailOTP(1234);
        emailOTPPage.verifyInputOTPSuccessfully(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
        emailOTPPage.clickOnContinue(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
        emailOTPPage.verifyNavigateToChooseBusinessOptionSuccessfully(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
    }

    @Test(priority = 4, description = "Verify the user completed personal Information successfully")
    public void test_input_personal_information() throws InterruptedException {
        //Choose Business Type
        chooseBusinessOptionPage.clickOnContinueByOption("Yes, my business is registered in Singapore with ACRA");
        chooseBusinessOptionPage.clickOnGetStartedByOption("Standard Registration");
        chooseBusinessOptionPage.clickOnGetStarted(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);

        //Complete Personal Information
        personalPage.setTextToIDNumber("123456");
        personalPage.setTextToDOB("Jul 15, 1995");

        personalPage.selectNationality("American Samoa");
        personalPage.selectGender("Male");
        personalPage.selectInterestedProduct("Debit Card");
        personalPage.clickOnSubmit(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
        personalPage.clickOnContinue(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
    }

    @Test(priority = 5, description = "Verify the user completed business Information successfully")
    public void test_input_business_information() throws InterruptedException {
        //Complete Business Information
        businessInfoPage.setTextToBusinessName("Test Sample");
        businessInfoPage.selectRegistrationParentType("Non profit organization");
        businessInfoPage.selectRegistrationType("Charities");
        businessInfoPage.setTextToUEN(RandomizeValue.randomUEN());
        businessInfoPage.setTextToBusinessWebsite("https://example.com/");
        businessInfoPage.selectIndustry("Charity / not-for-profit");
        businessInfoPage.selectSubIndustry("All activities");
        businessInfoPage.clickOnSubmit(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
        businessInfoPage.clickOnGetStarted(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
        businessInfoPage.clickOnGetBeginVerification(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);

        //Upload Image
        businessInfoPage.uploadImage("src\\main\\java\\testdata\\image\\icon.png");
        businessInfoPage.clickOnContinue(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
        businessInfoPage.action.sleep(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);

//        //Upload Image to Selfie with KTP
//        businessInfoPage.uploadImage("src\\main\\java\\testdata\\image\\icon - Selfie.png");
//        businessInfoPage.clickOnContinue(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
//        businessInfoPage.action.sleep(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
//
//        //Verify
//        businessInfoPage.verifyCompletedBusinessInfoSuccessfully(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
//        businessInfoPage.clickOnContinue(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
//        businessInfoPage.verifyWaitingMessage(DefaultProfile.MIN_PAGE_LOAD_TIMEOUT);
    }

    @AfterMethod
    public void tearDown() {
        loginPage.action.cleanUp();
    }

    @DataProvider(name = "test1data")
    public Object[][] getData() {
        String excelPath = "src\\main\\java\\testdata\\AccountInformation.xlsx";
        Object[][] data = testData(excelPath, "Account");
        return data;

    }


    public Object[][] testData(String excelPath, String sheetName) {

        ExcelHelper excel = new ExcelHelper(excelPath, sheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount-1][colCount];

        for(int i=1; i<rowCount; i++) {
            for(int j=0; j<colCount; j++) {

                String cellData = excel.getCellDataString(i, j);
                //System.out.print(cellData+" | ");
                data[i-1][j] = cellData;

            }
            //System.out.println();
        }
        return data;

    }
}
