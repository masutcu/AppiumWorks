package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium3_Amazon {

    @Test
    public void test() throws MalformedURLException {
         /*DesiredCapabilities desiredCap=new DesiredCapabilities();

        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("masutcu");
        options.setApp(System.getProperty("user.dir")+"src/Apps/GestureTool.apk");


        options.setCapability("noReset", true);

        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
*/

        //com.google.android.apps.nexuslauncher/com.google.android.apps.nexuslauncher.NexusLauncherActivity

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
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        // Initialize AndroidDriver
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        // Navigate to Amazon.com.tr
        driver.get("https://www.amazon.com.tr");


        //capabilities.setCapability("app", "C:\\Users\\Lenovo\\IdeaProjects\\Appium\\src\\Apps\\Gesture Tool_1.3_Apkpure.apk");

    }

}

