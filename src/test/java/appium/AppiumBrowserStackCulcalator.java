package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBrowserStackCulcalator {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "hello_piPqeW");
        caps.setCapability("browserstack.key", "dJYMNfznpqzCysd6ngcX");

        // Set URL of the application under test
        caps.setCapability("app", "bs://1469bfbdccd0741c3b28c45b337a71100f7f0772");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");
//        caps.setCapability("appPackage","com.google.android.calculator");
//        caps.setCapability("appActivity","com.android.calculator2.Calculator");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Kendi aplikayunumuz");
        caps.setCapability("build", "yeni ");
        caps.setCapability("name", "hesp makinasi");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver driver = new AndroidDriver(
                new URL("http://hub.browserstack.com"), caps);
        Thread.sleep(5000);
        // Write your test case statements here

        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        Thread.sleep(3000);

        driver.findElement(new AppiumBy.ByAccessibilityId("plus")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        Thread.sleep(3000);

        driver.findElement(new AppiumBy.ByAccessibilityId("equals")).click();
        Thread.sleep(10000);

        Assert.assertEquals(driver.findElement(By.id("com.google.android.calculator:id/result")).getText(), "10");

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

    }
}