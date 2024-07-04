package appium.tests;

import org.testng.annotations.Test;

public class StartShutdownApp extends BaseTest{

    @Test
    public void testStartShutdownApp(){
        application.activate("org.joinmastodon.android");
        application.terminate("org.joinmastodon.android");
    }
}
