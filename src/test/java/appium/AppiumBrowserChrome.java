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

public class AppiumBrowserChrome {
    private static final String Appium = "http://127.0.0.1:4723";
    DesiredCapabilities capabilities;
    AndroidDriver driver;

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        //Appium1 sürüm ayarları
        capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//appiumdan gelen
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "masutcu");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        //yeni bir komut almadığında 60 saniye sonra ana sayfaya döner
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
        //capabilities.setCapability("chromeDriverExecutable","");
        driver = new AndroidDriver(new URL(Appium), capabilities);
        driver.get("https://www.amazon.com.tr");

        System.out.println("app acıldığındaki tur = " + driver.getContext());
        Set<String> butunturler= driver.getContextHandles();
        for(String tur: butunturler){
            System.out.println(tur);
            if(tur.contains("WEBVIEW_chrome")){
                driver.context(tur);
            }
        }

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
