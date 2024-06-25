package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchCloseApp {
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0"); // Replace with your device's version
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554"); // Replace with your device UDID
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\r.amantayuly\\Desktop\\appiumExample\\src\\test\\resources\\mastodon-githubRelease.apk"); // Replace with the path to your APK file
        // Optional: Set additional capabilities as needed
        caps.setCapability("appPackage", "org.joinmastodon.android");
        caps.setCapability("appActivity", "org.joinmastodon.android.MainActivity");
        caps.setCapability("autoLaunch", false);
        caps.setCapability( "appium:automationName", "uiautomator2");

        URL appiumServerURL = new URL("http://127.0.0.1:4723/"); // Appium server address. Should be the same as in the your config file and Appium Inspector

        driver = new AndroidDriver<>(appiumServerURL, caps);
    }

    @Test
    public void appiumTest() {
        driver.activateApp("org.joinmastodon.android");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.terminateApp("org.joinmastodon.android");
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
