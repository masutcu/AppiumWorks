package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium09UiSelectorTestCase {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Lenovo\\IdeaProjects\\Appium\\src\\Apps\\GestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset","true");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        //add button tikladik
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Add\")")).click();

        Thread.sleep(5000);

        String isFalse = driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)")).getAttribute("enabled");

        Assert.assertEquals(isFalse,"false");

        WebElement textBox = driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gesture_name\")"));
        textBox.sendKeys("text");
        Thread.sleep(5000);
        WebElement blackScreen = driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/gestures_overlay\")"));
        blackScreen.click();
        String isTrue = driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(true)")).getAttribute("enabled");

        Assert.assertEquals(isTrue,"true");

        System.out.println("done button enabled");

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\")")).click();

        Thread.sleep(5000);
        // session kapat
        // driver.closeApp();
    }
}
