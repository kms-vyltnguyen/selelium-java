package keywords.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import profiles.DefaultProfile;
import utils.WebElementUtils;
import com.google.inject.Inject;
import org.testng.Reporter;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class UIAction {

    static WebDriver driver;

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    private WebDriverWait wait;

    public UIAction(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * setup Chrome/ Firefox Driver on Mac
     */
    public WebDriver setupDriver(String browser) {
        if (browser.toLowerCase().equals("chrome")) {
            if (System.getProperty("os.name").contains("Mac")) {
                Reporter.log("Launching Google Chrome Driver for this test");
                System.setProperty("webdriver.chrome.driver", UIAction.class.getResource(DefaultProfile.MAC_CHROME_DRIVER).getFile());
                // System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

                // Now checking for existence of Chrome executable.
                if (!new File("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome").exists()) {
                    throw new RuntimeException("Cannot find chromedriver file. Please download and copy to drivers folder in current project");
                }
            }

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(DefaultProfile.MAX_PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(DefaultProfile.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

        } else if (browser.toLowerCase().equals("firefox")) {
            Reporter.log("Launching Firefox Driver for this test");
            if (System.getProperty("os.name").contains("Mac")) {
                System.setProperty("webdriver.gecko.driver", UIAction.class.getResource(DefaultProfile.MAC_FIREFOX_DRIVER).getFile());
                // System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

                // Now checking for existence of Firefox executable.
                if (!new File("/Applications/Firefox.app/Contents/MacOS/firefox").exists()) {
                    throw new RuntimeException("Cannot find geckodriver file. Please download and copy to drivers folder in current project");
                }
            }
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);

        maximizeWindows();
        get(DefaultProfile.urlQA);
        sleep(TIMEOUT);
        return driver;
    }

    /**
     * Maximize windows
     */
    public void maximizeWindows() {
        try {
            Reporter.log("Maximize Window");
            driver.manage().window().maximize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void cleanUp() {
        try {
            Reporter.log("cleanUp");
            if (driver != null) {
                driver.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Click on an element
     *
     * @param by receive the element
     */
    public void click(By by) {
        try {
            Reporter.log("Click on the element by locator " + by.toString());
            WebElement element = driver.findElement(by);
            element.click();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Click on an element
     *
     * @param element the element
     */
    public void click(WebElement element) {
        try {
            Reporter.log("Click on the element");
            element.click();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Click on an element
     *
     * @param element the element
     */
    public void clickJS(WebElement element) {
        try {
            Reporter.log("Click on the element");
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Click on a Pseudo Object
     *
     * @param element the element
     */
    public void clickPseudoObject(WebElement element) {
        try {
            Reporter.log("Click on the element");
            System.out.println("Click on the Pseudo element");
            scrollToElementJS(element);
            Actions action = new Actions(driver);
            action.moveToElement(element).click().build().perform();
            sleep(TIMEOUT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Scroll to an element
     *
     * @param element the element
     */
    public void scrollToElementJS(WebElement element) {
        try {
            Reporter.log("Scroll to element");
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            int loopTime = 0;
            while (!element.isDisplayed() || !element.isEnabled()  && loopTime < 15) {
                executor.executeScript("window.scrollBy(0, 150)");
                loopTime++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Set Text to element
     *
     * @param by   the element
     * @param text the value
     */
    public void setText(By by, String text) {
        try {
            Reporter.log("Set text on the element by locator " + by.toString() + " with the value: " + text);
            WebElement element = driver.findElement(by);
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Set Text to element
     *
     * @param element the element
     * @param text    the value
     */
    public void setText(WebElement element, String text) {
        try {
            Reporter.log("Set text on the element by locator " + element.toString() + " with the value: " + text);
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Return the text of element
     *
     * @param by receive the element
     */
    public String getTextFromElement(By by) {
        String text = "";
        try {
            Reporter.log("Get text of the element with the locator " + by.toString());
            text = driver.findElement(by).getText();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return text;
    }

    /**
     * Return the text of element
     *
     * @param element receive the element
     */
    public String getTextFromElement(WebElement element) {
        String text = "";
        try {
            Reporter.log("Get text of the element with the locator " + element.toString());
            text = element.getText();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return text;
    }

    /**
     * Go to the URL
     *
     * @param url
     */
    public void get(String url) {
        try {
            Reporter.log("Navigate to the URL " + url);
            driver.get(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Go to the URL
     */
    public String getTitle() {
        try {
            Reporter.log("Get the current title");
            return driver.getTitle();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    /**
     * sleep for x seconds
     *
     * @param seconds
     */
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void scrollToElement(WebElement element, int timeout) throws InterruptedException {
        Thread.sleep(timeout);
        if (!element.isDisplayed()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        }
    }
}
