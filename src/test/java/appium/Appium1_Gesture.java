package appium;



import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium1_Gesture {

    @Test
    public void test() throws MalformedURLException {

        //Appium1 sürüm ayarları
        DesiredCapabilities capabilities=new DesiredCapabilities();
        //capabilities.setCapability("platformName","Android");//String ile
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");//seleniumdan gelen
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//appiumdan gelen
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "masutcu");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Lenovo\\IdeaProjects\\Appium\\src\\Apps\\GestureTool.apk");


        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        //izinler için
        //capabilities.setCapability(MobileCapabilityType.NO_RESET, true);


        // Initialize AndroidDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        System.out.println("app yüklendi");
        //izinler için bu kodlar veya üst satırdaki noReset komutu
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='Tamam']")).click();

        WebElement homeScreenTitle =driver.findElement(By.id("android:id/title"));
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("ana sayfa açıldı");

        WebElement testbutton=driver.findElement(By.id("com.davemac327.gesture.tool:id/testButton"));
        testbutton.click();
        System.out.println("test button çalışıyor");

        WebElement testGestureIdTitle =driver.findElement(By.id("android:id/title"));
        Assert.assertTrue(testGestureIdTitle.isDisplayed());
        System.out.println("test ana sayfa açıldı");

        //session close
        driver.quit();









    }

}
