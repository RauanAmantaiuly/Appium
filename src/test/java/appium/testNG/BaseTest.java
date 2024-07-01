package appium.testNG;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        caps.setCapability(MobileCapabilityType.UDID, "RZCT80ZZNAZ");
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\r.amantayuly\\Desktop\\appiumExample\\src\\test\\resources\\apps\\mastodon-githubRelease.apk");
        caps.setCapability("appPackage", "org.joinmastodon.android");
        caps.setCapability("appActivity", "org.joinmastodon.android.MainActivity");
        caps.setCapability("autoLaunch", false);
        caps.setCapability( "appium:automationName", "uiautomator2");

        URL appiumServerURL = new URL("http://127.0.0.1:4723/");

        driver = new AndroidDriver<>(appiumServerURL, caps);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
