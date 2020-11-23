package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Finds the first element using given locator
     *
     * @param locator By - locator to find the element
     * @return WebElement - first element found
     */
    protected WebElement find(By locator) {
        return driver.findElements(locator).get(0);
    }

    /**
     * Finds all elements using given locator
     *
     * @param locator By - locator to find the element
     * @return List - all the elements found
     */
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Clicks on the first element with given locator when it's visible
     *
     * @param locator By - locator to find the element
     */
    protected void click(By locator) {
        waitForVisibilityOf(locator, 30);
        find(locator).click();
    }

    /**
     * Waits for specific ExpectedCondition for the given amount of time in seconds
     *
     * @param condition        condition for WebElement to wait for
     * @param timeOutInSeconds int - number of seconds to wait for the condition
     */
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    /**
     * Waits for given number of seconds for the element with given locator to be visible
     *
     * @param locator          By - locator for the element
     * @param timeOutInSeconds int - number of seconds to wait for the condition
     */
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Element not visible by locator " + locator);
            }
            attempts++;
        }
    }
}
