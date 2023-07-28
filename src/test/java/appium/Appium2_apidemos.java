package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium2_apidemos {
    @Test
    public void test() throws MalformedURLException {

        /*
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("masutcu");
        options.setPlatformVersion("13");
        options.setApp(System.getProperty("user.dir") + "src/Apps/ApiDemos-debug.apk");
        options.setCapability("noReset", true);
        */

        //Appium1 sürüm ayarları
        DesiredCapabilities capabilities=new DesiredCapabilities();
        //capabilities.setCapability("platformName","Android");//String ile
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");//seleniumdan gelen
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//appiumdan gelen
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "masutcu");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");

        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        //capabilities.setCapability("appPackage", "com.google.android.permissioncontroller");
        //capabilities.setCapability("appActivity", "com.android.permissioncontroller.permission.ui.ReviewPermissionsActivity");

        //capabilities.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
        //capabilities.setCapability("appActivity", "com.google.android.apps.nexuslauncher.NexusLauncherActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }
    }
