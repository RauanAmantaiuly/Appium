package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SearchingForItemsMastodon {
    private AppiumDriver<MobileElement> driver;
    private MobileElement logInBtn = driver.findElement(By.id("org.joinmastodon.android:id/btn_log_in"));

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\r.amantayuly\\Desktop\\appiumExample\\src\\test\\resources\\mastodon-githubRelease.apk");
        caps.setCapability("appPackage", "org.joinmastodon.android");
        caps.setCapability("appActivity", "org.joinmastodon.android.MainActivity");
        caps.setCapability("autoLaunch", false);
        caps.setCapability( "appium:automationName", "uiautomator2");
        caps.setCapability("appium:enforceXPath1", true);

        URL appiumServerURL = new URL("http://127.0.0.1:4723/");

        driver = new AndroidDriver<>(appiumServerURL, caps);
    }

    @Test
    public void appiumTest() {
        driver.activateApp("org.joinmastodon.android");
        driver.terminateApp("org.joinmastodon.android");
        driver.activateApp("org.joinmastodon.android");

        logInBtn.click();

    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
