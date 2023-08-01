package appium;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;


public class Appium6NativeChrome {


    private static final String Appium = "http://127.0.0.1:4723";
    DesiredCapabilities desiredCap;
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws MalformedURLException {


        desiredCap = new DesiredCapabilities();

        desiredCap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        desiredCap.setCapability("appPackage", "com.android.chrome");
        desiredCap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        desiredCap.setCapability("noReset", true);
        driver = new AndroidDriver(new URL(Appium), desiredCap);

    }

    @Test
    public void testName() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.amazon.com");
//

        Set<String> sd = driver.getContextHandles();
        System.out.println(sd);

        System.out.println("driver.getContext() = " + driver.getContext());



      //  WebElement homepage = driver.findElement(AppiumBy.accessibilityId("Amazon"));

       WebElement homepage= wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Amazon")));

        Assert.assertTrue(homepage.isDisplayed());

        WebElement signIn = driver.findElement(AppiumBy.xpath("\t\n" +
                "//android.view.View[@content-desc=\"your account\"]/android.widget.TextView"));
        signIn.click();



        WebElement welcome = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Welcome']")));
        Assert.assertTrue(welcome.getText().contains("Welcome"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
