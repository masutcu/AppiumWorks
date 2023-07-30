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

public class AppiumBrowserChrome {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        //Appium1 sürüm ayarları
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//appiumdan gelen
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "masutcu");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.get("https://www.amazon.com.tr");

        System.out.println("app acıldığındaki tur = " + driver.getContext());
        // Navigate to Amazon.com.tr

        System.out.println("app acıldığındaki tur"+driver.getContext());
        Thread.sleep(3000);

        WebElement homeScreenLogo=driver.findElement(new AppiumBy.ByAccessibilityId("Amazon.com.tr"));
        Assert.assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("ana sayfadayız");

        //System.out.println(driver.getCurrentUrl()+"<========== url ");

        WebElement singInButton= driver.findElement(By.xpath("//android.view.View[@content-desc=\"Sign in ›\"]/android.widget.TextView"));
        singInButton.click();


    }
}
