package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class TestBase {
    protected AppiumDriver driver;

    @BeforeMethod
    public void beforeMethod() throws Exception {

    }
/*
    @AfterMethod
    public void afterMethod() {
        // AppiumDriver'ı kapatın
        if (driver != null) {
            driver.quit();
        }
    } */
}
