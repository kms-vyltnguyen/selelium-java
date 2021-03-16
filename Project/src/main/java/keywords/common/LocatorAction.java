package keywords.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorAction {
    private static WebElement element = null;

    public WebElement getObjByXpath(WebDriver driver, String inputXpath) {
        System.out.println(inputXpath);
        element = driver.findElement(By.xpath(inputXpath));
        return element;
    }

    public WebElement getObjById(WebDriver driver, String inputId) {
        element = driver.findElement(By.id(inputId));
        return element;
    }

    public WebElement getObjByName(WebDriver driver, String inputName) {
        element = driver.findElement(By.id(inputName));
        return element;
    }

    public WebElement getObjByLabel(WebDriver driver, String inputLabel) {
        System.out.println("//*[text() = \"" + inputLabel + "\"]");
        element = driver.findElement(By.xpath("//*[text() = \"" + inputLabel + "\"]"));
        return element;
    }

    public WebElement getObjByContainsLabel(WebDriver driver, String inputLabel) {
        element = driver.findElement(By.xpath("//*[contains(text(), \"" + inputLabel + "\")]"));
        return element;
    }

    public WebElement getTxtByPlaceHolder(WebDriver driver, String inputPlaceHolder) {
        System.out.println("//input[@placeholder = \"" + inputPlaceHolder + "\"]");
        element = driver.findElement(By.xpath("//input[@placeholder = \"" + inputPlaceHolder + "\"]"));
        return element;
    }

    public List<WebElement> getElementsList(WebDriver driver, String inputXpath) {
        List<WebElement> listOfElements = driver.findElements(By.xpath(inputXpath));
        return listOfElements;
    }
}
