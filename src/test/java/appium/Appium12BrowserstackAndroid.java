package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Appium12BrowserstackAndroid {
    @Test
    public void browserstackAndroid() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "mehmetayyildiz_HFVDMX");
        caps.setCapability("browserstack.key", "fwuU7xxcgZRSwegDPgvh");

        // Set URL of the application under test
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy A10");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Appium Project");
        caps.setCapability("build", "browserstack-1");
        caps.setCapability("name", "sample_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver driver = new AndroidDriver(
                new URL("http://hub.browserstack.com"), caps);

        // Test case for the BrowserStack sample Android app.
        // If you have uploaded your app, update the test case here.
        WebElement searchElement =  new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                ExpectedConditions.elementToBeClickable(
                        new AppiumBy.ByAccessibilityId("Search Wikipedia")));
        searchElement.click();
        WebElement insertTextElement =  new WebDriverWait(driver,Duration.ofSeconds(10) ).until(
                ExpectedConditions.elementToBeClickable(
                        new By.ById("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);
        List<WebElement> allProductsName = driver.findElements(By.className("android.widget.TextView"));

        assert(allProductsName.size() > 0);


        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
