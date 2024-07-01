package appium.testNG;

import org.testng.annotations.Test;

public class LaunchCloseApp extends BaseTest {

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

}
