package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class AppiumNativeChrome {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        //Appium1 sürüm ayarları
        DesiredCapabilities capabilities=new DesiredCapabilities();
        //capabilities.setCapability("platformName","Android");//String ile
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");//seleniumdan gelen
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//appiumdan gelen
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "masutcu");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        // Appium server URL
        URL url = new URL("http://127.0.0.1:4723");

        // Initialize AndroidDriver
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        // Navigate to Amazon.com.tr
        driver.get("https://www.amazon.com.tr");
        System.out.println("app acıldığındaki tur = " + driver.getContext());
        Thread.sleep(5000);


        WebElement homeScreenLogo=driver.findElement(new AppiumBy.ByAccessibilityId("Amazon.com.tr"));
        Assert.assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("ana sayfadayız");

        //System.out.println(driver.getCurrentUrl()+"<========== url ");

        WebElement singInButton= driver.findElement(By.xpath("//android.view.View[@content-desc=\"Sign in ›\"]/android.widget.TextView"));
        singInButton.click();


    }
}
