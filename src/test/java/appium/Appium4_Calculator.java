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

public class Appium4_Calculator {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        //Appium1 sürüm ayarları
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//appiumdan gelen
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "VirtualDevice");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Lenovo\\IdeaProjects\\Appium\\src\\Apps\\Calculator_8.4.1.apk");

        // Initialize AndroidDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        System.out.println("app yüklendi");

        WebElement num1= driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        WebElement num2= driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        WebElement num3= driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        WebElement num4= driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        WebElement num5= driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        WebElement num6= driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
        WebElement num7= driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        WebElement num8= driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
        WebElement num9= driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        WebElement num0= driver.findElement(By.id("com.google.android.calculator:id/digit_0"));

        WebElement plus= driver.findElement(new AppiumBy.ByAccessibilityId("plus"));
        WebElement multiply= driver.findElement(new AppiumBy.ByAccessibilityId("multiply"));
        WebElement divide= driver.findElement(new AppiumBy.ByAccessibilityId("divide"));
        WebElement minus= driver.findElement(new AppiumBy.ByAccessibilityId("minus"));

        WebElement equal= driver.findElement(new AppiumBy.ByAccessibilityId("equals"));

        //64+71
        num6.click();
        num4.click();
        Thread.sleep(1000);
        plus.click();
        Thread.sleep(1000);
        num7.click();
        num1.click();
        Thread.sleep(1000);
        WebElement preResult= driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
        System.out.println("pre result : "+preResult.getText());
        String preRst=preResult.getText();

        equal.click();

        WebElement result=driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        System.out.println("final result : "+result.getText());
        String fnRst=result.getText();

        Assert.assertEquals(preRst,fnRst);






        //session close
        //driver.quit();

    }







}


