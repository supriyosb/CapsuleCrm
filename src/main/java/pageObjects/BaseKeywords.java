package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseKeywords {
    private WebDriver driver;

    /**
     * Constructor
     * It will initialize the WebDriver instance
     * @param driver
     */
    public BaseKeywords(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * It will explicitely wait until the element got visible in the screen
     * Once the element is visible, itwill return the element
     * It will wait until the timeout got expired
     * @param locator
     * @param timeout
     * @return
     */
    protected WebElement waitForVisibilityOfElement(By locator, Integer timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    /**
     * It will vertically scroll from top to bottom
     */
    protected void verticalScrollUsingJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * It will inject a hard wait
     * @param timeout
     */
    protected void sleep(Integer timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
        }
    }

    /**
     * It will vertically scroll from bottom to top
     */
    protected void scrollToTop(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    /**
     * It will click the element using JavascriptExecutor
     * @param element
     */
    protected void clickUsingJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}
