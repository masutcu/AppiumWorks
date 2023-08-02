package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ApiDemosTest {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        //Appium1 sürüm ayarları
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("platformName","Android");//String ile
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");//seleniumdan gelen
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//appiumdan gelen
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "masutcu");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Lenovo\\IdeaProjects\\Appium\\src\\Apps\\ApiDemos-debug.apk");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("appPackage", "com.google.android.permissioncontroller");
        capabilities.setCapability("appActivity", "com.android.permissioncontroller.permission.ui.ReviewPermissionsActivity");
        // Initialize AndroidDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        System.out.println("app yüklendi");

        //api demos butonuna tikla ama bu buton yeni sürüm apk da yok
        //driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
        Thread.sleep(3000);
        //preference butonuna tikladik
        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
        //preference dependencies butonuna bastik
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
        //check box check et
        Thread.sleep(3000);
        driver.findElement(By.id("android:id/checkbox")).click();
        //wifi setting tikladik
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        //text penceresi acildigini gorduk
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.id("android:id/alertTitle")).isDisplayed());
        //text yazdiralim
        driver.findElement(By.id("android:id/edit")).sendKeys("TextAppium");
        //ok butonuna bas
        driver.findElement(By.id("android:id/button1")).click();

        System.out.println("mission completed....");

        Thread.sleep(10000);
        //session kapat

        driver.quit();

    }
}