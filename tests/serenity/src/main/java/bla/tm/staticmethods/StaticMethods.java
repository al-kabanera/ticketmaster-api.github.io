package bla.tm.staticmethods;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Map;
import static java.util.Optional.ofNullable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class StaticMethods {

    public static WebElementFacade findWebElementByKey(String key, Map<String, WebElementFacade> webElementsList) {
        return ofNullable(webElementsList.get(key)).orElseThrow(
                () -> new RuntimeException("There is no " + key + " element on the page"));
    }

    public static WebElementFacade checkIfWebElementExist(WebElementFacade webElement) {
        return ofNullable(webElement).orElseThrow(
                () -> new RuntimeException("There is no element on the page"));
    }

    public static void waitForSomeActionHappened(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void scrollToElement(WebElementFacade element){
        int screenHeight = getDriver().manage().window().getSize().getHeight();
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollTo(0," + (element.getLocation().y - screenHeight / 2) + ")");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
