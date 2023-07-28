package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium2_apidemos {
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities desiredCap = new DesiredCapabilities();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("masutcu");
        options.setApp(System.getProperty("user.dir") + "src/Apps/ApiDemos-debug.apk");


        options.setCapability("noReset", true);

        AndroidDriver driver = new AndroidDriver(new URL("C:\\Users\\Lenovo\\IdeaProjects\\Appium\\src\\Apps\\ApiDemos-debug.apk"), options);
    }
    }
